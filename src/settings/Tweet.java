package settings;

/**
 * Tweet object implementation
 * @author Evelyn
 *
 */
public class Tweet{
	
	private String tweet;
	private String userName;
	private String userScreenName;
	private TimeStamp timeStamp;
	private String location;
	private String timeCreated;
	
	public Tweet(){
		this.setTweet(null);
		this.setUserName(null);
		this.setUserScreenName(null);
		this.setTimeStamp(null);
		this.setLocation(null);
	}
	
	public Tweet(String twt, String name, String screenName, TimeStamp timestamp,
			String local){
		
		this.setTweet(twt);
		this.setUserName(name);
		this.setUserScreenName(screenName);
		this.setTimeStamp(timestamp);
		this.setLocation(local);
	}
	
	/*
	 * Uses the status.createdAt() method 
	 */
	public Tweet(String twt, String name, String screenName, String timestamp,
			String local){
		
		this.setTweet(twt);
		this.setUserName(name);
		this.setUserScreenName(screenName);
		this.setTimeCreated(timestamp);
		this.setLocation(local);
	}
	
	public String toString(){
		return 
				//this.timeStamp.getDayFormatBR() + " " 
				//+ this.timeStamp.getHourFormat()
				this.getTimeCreated()
				+ " " + this.getLocation() + " "
		+ this.getUserName() + " " 
		+ this.getUserScreenName() + " " 
		+ this.getTweet();
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserScreenName() {
		return userScreenName;
	}

	public void setUserScreenName(String userScreenName) {
		this.userScreenName = userScreenName;
	}

	public TimeStamp getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(TimeStamp timeStamp) {
		this.timeStamp = timeStamp;
	}
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(String timeCreated) {
		this.timeCreated = timeCreated;
	}
	
	

}
