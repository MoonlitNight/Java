package com.jumbo.shop.daemon.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * FTP上传工具类
 * @author jin.wang
 *
 */
public class FTPTemplate {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(FTPTemplate.class);

	private static final Integer DEFAULT_PORT = 21;
	
	private static final int RETRY_COUNT = 10;
	
	private String hostname;      
    
    private String username;      
     
    private String password;
    
    private Integer port = DEFAULT_PORT;
    
	public FTPTemplate() {
		super();
	}

	public FTPTemplate(String hostName) {
		this(hostName,DEFAULT_PORT);
	}

	public FTPTemplate(String hostName, Integer port) {
		this(hostName,null,null,port);
	}
	
	public FTPTemplate(String hostName, String username, String password) {
		this(hostName,username,password,DEFAULT_PORT);
	}
	
	public FTPTemplate(String hostName, String username, String password, Integer port) {
		if(StringUtils.isBlank(hostName))
			throw new IllegalArgumentException("hostName is not null");
		this.hostname = hostName;
		this.username = username;
		this.password = password;
		this.port = port;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}
	
	private FTPClient getFTPClient() throws SocketException, IOException{
		FTPClient ftpClient = new FTPClient();
		//设置被动FTP连接模式
		ftpClient.enterLocalPassiveMode();
		LOGGER.debug("change passive mode");
		ftpClient.connect(hostname, port);
		LOGGER.debug("Connected to " + hostname + " .");
		if (StringUtils.isBlank(username)||StringUtils.isBlank(password))
			return ftpClient;
		boolean isSuccess =ftpClient.login(username, password);//登陆  
		if (!isSuccess) 
			throw new RuntimeException("FTP login " + hostname + " error.");
		int reply = ftpClient.getReplyCode();
		if(!FTPReply.isPositiveCompletion(reply)) {
			ftpClient.disconnect();
			throw new RuntimeException("FTP server refused connection.");
	      }
		return ftpClient;
	}
	
	/**
	 * 使用被动模式连接FTP服务器
	 * @param fileType 文件类型 {@link FTP}
	 * @param remoteDir 远程文件夹
	 * @param path 本地文件路径
	 * @param isReplace 是否替换远程同名文件（超过重试次数则直接替换重名文件）
	 * @return
	 * @throws IOException
	 */
	public  boolean upload(int fileType,String remoteDir,String path,boolean isReplace) throws IOException {
		FTPClient ftpClient = getFTPClient();
		ftpClient.setFileType(fileType);
		boolean isChange = ftpClient.changeWorkingDirectory(remoteDir);
		if(!isChange) {
			LOGGER.error("未找到目录：{}",remoteDir);
			return Boolean.FALSE;
		}
		File file = new File(path);
		String name = file.getName();
		int count = 0;
		boolean isSuccess = false;
		while(!isReplace&&fileExist(ftpClient, name)&& count<RETRY_COUNT) {
			count++;
			name = changeName(name,count);
		}
		FileInputStream inputStream = new FileInputStream(file);
		isSuccess = ftpClient.storeFile(name, inputStream);
		inputStream.close();
		if(ftpClient!=null || ftpClient.isConnected())
			ftpClient.logout();
		return isSuccess;
	}
	
	private boolean fileExist(FTPClient ftpClient,String fileName) throws IOException{
		String[] names = ftpClient.listNames();
		if(names==null||names.length==0)
			return false;
		List<String> list = Arrays.asList(names);
		return list.contains(fileName);
	}
	

	private String changeName(String name,int count) {
		int index = name.lastIndexOf(".");
		if (index==-1)
			return name+count;
		String fileName = name.substring(0,index);  
		String extension  = name.substring(index, name.length()); 
		return fileName+"_"+count+extension;
	}
	
}
