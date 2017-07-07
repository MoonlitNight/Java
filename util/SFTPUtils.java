import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Vector;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
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
	
	private static final String DEFAULT_CHARSET = "UTF-8";
	
	private static final int DEFAULT_TIMEOUT = 3000;
	
	private static final String DEFAULT_SSH_HOSTS_DIR = System.getProperty("user.home").concat("/ssh/");
	
	private static final String DEFAULT_KEY_FILENAME_PATTERN = "key_%s_%d.pub";
	
	private static final String KEY_CONTENT_PATTERN = "%s ssh-rsa %s";

	private static final String PROTOCOL = "sftp";
	
	private String host;      
    
    private String username;      
     
    private String password;
    
    private Integer port;
    
    private Integer timeout = DEFAULT_TIMEOUT;
    
	public SFTPUtils() {
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
		return upload(filePath, remoteDir, null);
	}

	/**
	 * 
	 * @param filePath 上传文件路径
	 * @param remoteDir 远程文件路径
	 * @param remoteChildDir 远程子文件目录
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public boolean upload(String filePath,String remoteDir,String remoteChildDir) {
		Boolean result = Boolean.FALSE;
		Session session = null;
		ChannelSftp sftp = null;
		try {
			session = getSession();
			sftp = (ChannelSftp)session.openChannel(PROTOCOL);
			sftp.connect(timeout);
			sftp.cd(remoteDir);
			if(StringUtils.isNotBlank(remoteChildDir)) {
				Vector<LsEntry> vector = sftp.ls("*");
				boolean exist=false;
				for(int i=0;i<vector.size();i++){  
					LsEntry entry = vector.get(i);
					String filename = entry.getFilename();
					boolean isDir = entry.getAttrs().isDir();
					exist = StringUtils.equals(filename, remoteChildDir)&&isDir;
				} 
				if(!exist) {
					sftp.mkdir(remoteChildDir);
					sftp.cd(remoteChildDir);
				}
			}
            File file = new File(filePath);
            if(!file.exists()) {
            	LOGGER.error("upload file not exists");
            	return result;
            }
            sftp.put(filePath, file.getName());
            result = Boolean.TRUE;
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
		jsch.setKnownHosts(getHostKeyPath());
		Session session = jsch.getSession(username, host, port );
		session.setPassword(password);
		session.connect(timeout);
		return session;
	}

	private String getHostKeyPath() {
		File file = new File(DEFAULT_SSH_HOSTS_DIR);
		if(!file.exists())
			file.mkdirs();
		String path = String.format(DEFAULT_SSH_HOSTS_DIR.concat(DEFAULT_KEY_FILENAME_PATTERN), host, port);
		File keyFile = new File(path);
		if(keyFile.exists())
			return path;
		LOGGER.info("rsa key not find");
		JSch jsch = new JSch();
		Session session = null;
		try {
			session = jsch.getSession( username, host, port);
			session.setPassword(password);
			session.connect(timeout);
		} catch (JSchException e) {
			addHostkey(session.getHostKey().getKey(),path);
		} finally {
			if(session!=null)
				session.disconnect();
		}
		return path;
	}

	private void addHostkey(String key, String path) {
		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), DEFAULT_CHARSET));
			writer.write(String.format(KEY_CONTENT_PATTERN, host, key));
		} catch (Exception e) {
			LOGGER.error("host key file write failure");
		} finally {
			try {
				if(writer!=null)
					writer.close();
			} catch (IOException e) {
				writer = null;
				LOGGER.error("close OutputStream failure",e);
			}
		}
	}
	
}
