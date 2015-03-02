package settings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Twitter query class
 * @author Evelyn
 *
 */
public class Query{
	
	public final static String[] LANGUAGES = {"pt"};
	
	private String[] languages;
	private String[] keywords;
	
	private Properties properties;
	
	/*
	 * Constructor
	 */
	public Query() throws FileNotFoundException, IOException{
		this.languages = null;
		this.keywords = null;
		this.build();
	}
	
	
	/*
	 * Loads the query properties from a input config file
	 */
	private Properties load() throws FileNotFoundException, IOException{
		
		properties = new Properties();
		
		try{
			properties.load(new FileInputStream("twitterQuery.config"));
		}
		catch(FileNotFoundException fnfe){
			System.out.println("Twitter Query configuration - file not found." + fnfe.getMessage());
		}
		catch(IOException ioe){
			System.out.println("Twitter Query Configuration - Error reading file" + ioe.getMessage());
		}
		
		return properties;
	}
	
	/*
	 * Read string transforming it in vector of strings
	 */
	private String[] readString(Properties p, String prop){
		
		String[] output = null;
		
		String aux = p.getProperty(prop); 
		if ((aux.equalsIgnoreCase(null) || aux.trim().equalsIgnoreCase(""))){
			
			if(prop.equalsIgnoreCase("keywords")){
			
				System.out.println(prop.toUpperCase() + " - fix it in twitterQuery.config file." 
						+ "\nApplication stopped");
				System.exit(0);
			}
			else{
				System.out.println(prop.toUpperCase() + " - none");
			}
		}
		else{
			output = aux.split(",");
			for (int i = 0; i < output.length; i++){
				output[i] = output[i].trim();
			}
			System.out.println(prop.toUpperCase() + " = " + propString(output));			
		}
		
		return output ;
	}
	
	private String propString(String[] in){
		String out = in[0];
		if (in.length > 1){
			for (int i = 1; i < in.length; i++){
				out += ", " + in[i];
			}
		}
		return out;
	}

	/*
	 * Build a query with its settings
	 */
	public Query build() throws FileNotFoundException, IOException{
		
		properties = this.load();
		System.out.println("JTwitterCrawler - Search Query Settings");
		
		this.languages = readString(properties, "languages");
		this.keywords = readString(properties, "keywords");
		
		return this;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	
}
