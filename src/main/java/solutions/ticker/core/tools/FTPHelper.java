package solutions.ticker.core.tools;

import java.io.InputStream;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;


public class FTPHelper {

	String SFTPHOST = "ticker.solutions";
	int    SFTPPORT = 7822;
	String SFTPUSER = "root";
	String SFTPPASS = "newarch11*";
	String SFTPWORKINGDIR = "/var/www/html/ticker.solutions/library_template/";
	 
	Session     session     = null;
	Channel     channel     = null;
	ChannelSftp channelSftp = null;
	
	public void connect(){
		try {
			 JSch jsch = new JSch();
			 session = jsch.getSession(SFTPUSER,SFTPHOST,SFTPPORT);
	         session.setPassword(SFTPPASS);
	         java.util.Properties config = new java.util.Properties();
	         config.put("StrictHostKeyChecking", "no");
	         session.setConfig(config);
	         session.connect();
	         channel = session.openChannel("sftp");
	         channel.connect();
	         channelSftp = (ChannelSftp)channel;
	         channelSftp.cd(SFTPWORKINGDIR);
        } catch (JSchException e) {
 			e.printStackTrace();
 		} catch (SftpException e) {
			e.printStackTrace();
		}
	}
	

	public void uploadFile(InputStream fileInputStream,String fileName){
		try {
			channelSftp.put(fileInputStream,fileName);
		} catch (SftpException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect(){
		  channel.disconnect();
		  session.disconnect();		
	}
	
}
