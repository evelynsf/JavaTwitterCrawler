package settings;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * Listener for twitter stream
 * @author Evelyn
 *
 */
public class TweetListener implements StatusListener {
	

	private TimeStamp time;
	private Tweet tweet;
	private File file;
	private long contTweets;
	
	
    public TweetListener(){
    	this.contTweets = 0;
    }
    
	public void onStatus(Status status) {
		
		setTime(new TimeStamp());
		tweet = new Tweet(status.getText(),status.getUser().getName(), status.getUser().getScreenName(), 
				status.getCreatedAt().toString(), status.getUser().getLocation());

		try {
			
	          file = new File("tweets.txt");
	          PrintWriter writer = new PrintWriter(new FileWriter(file, true)); 
	          writer.append(tweet.toString() + "\n");
	          writer.close();
	          
	        
		} catch ( IOException e ) {
	           e.printStackTrace();
	    }
		this.incrementContTweets();
	
		/*		
			System.out.println("[" + 
			//new GregorianCalendar().getTime().toString() 
			time.getTimeFormat()
			+ "] " 
	        		+ status.getUser().getName() + " : " + status.getText());
	    */
    }
	
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
    	System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
    }
    
    public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
    	System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
    }
    
    public void onException(Exception ex) {
        ex.printStackTrace();
    }
    
	@Override
	public void onScrubGeo(long userID, long upToStatusID) {
		System.out.println("Got scrub_geo event userId:" + userID + " upToStatusId:" + upToStatusID);
		
	}
	@Override
	public void onStallWarning(StallWarning stallWarning) {
		System.out.println("Got stall warning:" + stallWarning);
		
	}
	
	public long getContTweets(){
		return this.contTweets;
	}
	
	public void incrementContTweets(){
		this.contTweets++;
	}

	public TimeStamp getTime() {
		return time;
	}

	public void setTime(TimeStamp time) {
		this.time = time;
	}

}
