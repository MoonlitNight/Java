

import java.io.*;
import java.util.Properties;
import java.util.Vector;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

/**
 * FTP上传工具类
 * @author jin.wang
 *
 */
public class SFTPUtils {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(SFTPUtils.class);
	
	/**
	 * 默认超时时间
	 */
	private static final int DEFAULT_TIMEOUT = 3000;

	/**
	 * 默认端口
	 */
	private static final int DEFAULT_PORT = 22;

	private static final String PROTOCOL = "sftp";
	
	private String host;      
    
    private String username;      
     
    private String password;
    
    private Integer port = DEFAULT_PORT;
    
    private Integer timeout = DEFAULT_TIMEOUT;
    
	public SFTPUtils() {
	}

	public SFTPUtils(String host, String username, String password) {
		if(StringUtils.isBlank(host))
			throw new IllegalArgumentException("host is not null");
		if(StringUtils.isBlank(username))
			throw new IllegalArgumentException("username is not null");
		if(StringUtils.isBlank(password))
			throw new IllegalArgumentException("password is not null");
		this.host = host;
		this.username = username;
		this.password = password;
	}

	public SFTPUtils(String host, Integer port, String username, String password) {
		if(StringUtils.isBlank(host))
			throw new IllegalArgumentException("host is not null");
		if(port==null)
			throw new IllegalArgumentException("port is not null");
		if(StringUtils.isBlank(username))
			throw new IllegalArgumentException("username is not null");
		if(StringUtils.isBlank(password))
			throw new IllegalArgumentException("password is not null");
		this.host = host;
		this.username = username;
		this.password = password;
		this.port = port;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
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
	
	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	/**
	 * 
	 * @param filePath 上传文件路径
	 * @param remoteDir 远程文件路径
	 * @return
	 */
	public boolean upload(String filePath,String remoteDir) {
		Boolean result = Boolean.FALSE;
		Session session = null;
		ChannelSftp sftp = null;
		try {
			session = getSession();
			sftp = (ChannelSftp)session.openChannel(PROTOCOL);
			sftp.connect(timeout);
			sftp.cd(remoteDir);
            File file = new File(filePath);
            if(!file.exists()) {
            	LOGGER.error("upload file not exists,path:{}",file.getAbsolutePath());
            	return false;
            }
            sftp.put(filePath, file.getName());
            result = true;
		} catch (Exception e) {
			LOGGER.error("sftp upload failure",e);
		} finally {
			if(sftp!=null)
				sftp.disconnect();
	        if(session!=null)
	        	session.disconnect();
		}
		return result;
	}

	private Session getSession() throws JSchException {
		JSch jsch = new JSch();
		Session session = jsch.getSession(username, host, port );
		Properties sshConfig = new Properties();
		sshConfig.put("StrictHostKeyChecking", "no");
		session.setConfig(sshConfig);
		session.setPassword(password);
		session.connect(timeout);
		return session;
	}

	
}
