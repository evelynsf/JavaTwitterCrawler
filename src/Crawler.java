import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import settings.*;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

/**
 * Classe construtora do crawler
 * @author Evelyn
 *
 */
public class Crawler {
	
	private TwitterStream twitterStream; 
	private TweetListener listener;
	
	/*
	 * Crawlers constructor
	 */
	public Crawler() throws IllegalStateException, TwitterException, FileNotFoundException, IOException{
		this.start();
	}
	
	/*
	 * Start connection via OAuth to Twitter server, tweets stream filtered by a query 
	 */
	private void start() throws IllegalStateException, TwitterException, FileNotFoundException, IOException {
		
		OAuthUser oauth = new OAuthUser();
				
		listener = new TweetListener();			
	    twitterStream = new TwitterStreamFactory(oauth.build()).getInstance();		
		twitterStream.addListener(listener);
		
		//Stream of all flow of tweets (no filter query)
		//twitterStream.sample();
					
		Query query = new Query();
		//FilterQuery(int count, long[] follow, java.lang.String[] track, double[][] locations, java.lang.String[] language)
		twitterStream.filter(new FilterQuery(0, null, query.getKeywords(), null, query.getLanguages() ));
		
		System.out.println("Twitter stream is running...");
		//stops the streamming
		onInputExit();
		
	}
	
	/*
	 * Stop streamming if user puts exit on keyboard
	 */
	public void onInputExit() throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();   

		if (input.toLowerCase().equalsIgnoreCase("exit")){
			this.stop();
		}	
	}
	
	/*
	 * Stop the streaming
	 */
	private void stop(){
		System.out.println("The Twitter stream is shutting down...!\n" +
				listener.getContTweets() + " tweets coletados");
		twitterStream.shutdown();
	}
	 

}
