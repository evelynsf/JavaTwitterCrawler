package settings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import twitter4j.conf.Configuration;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Oauth user class - oauth authentication
 * 
 * @author Evelyn
 *
 */
public class OAuthUser {
	
	private Properties loadProperties() throws FileNotFoundException, IOException{
		
		Properties properties = new Properties();
		try{
			properties.load(new FileInputStream("oauthKeys.config"));
		}
		catch(FileNotFoundException fnfe){
			System.out.println("Oauth keys configuration - file not found." + fnfe.getMessage());
		}
		catch(IOException ioe){
			System.out.println("Oauth Keys Configuration - Error reading file" + ioe.getMessage());
		}
		
		return properties;
	}
		
	//public Configuration build(String consumerKey, String consumerSecret, String accessToken, String accessSecret) throws FileNotFoundException, IOException {
	public Configuration build() throws FileNotFoundException, IOException {
		
		ConfigurationBuilder cb = new ConfigurationBuilder();
		
		Properties properties = loadProperties();
		
	    cb.setDebugEnabled(true)
	    	.setOAuthConsumerKey(properties.getProperty("consumerKey"))
	    	.setOAuthConsumerSecret(properties.getProperty("consumerSecret"))
	    	.setOAuthAccessToken(properties.getProperty("accessToken"))
	    	.setOAuthAccessTokenSecret(properties.getProperty("accessTokenSecret"));
		
		return cb.build();
	}
}
