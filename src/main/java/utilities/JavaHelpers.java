package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class JavaHelpers 
{

	//Data Reader 
	/** 
	 * Get Property value
	 * @param propertyfile property file name
	 * @param propertyname property name
	 * @return String property value
	 */
	public static String getPropertyValue(String propertyfile, String propertyname) 
	{
		Properties prop = accessPropertiesFile(propertyfile);
		return prop.getProperty(propertyname);
	}

	/**
	 * Access property file
	 * @param propertyfile property file name
	 * @return Properties object
	 */
	public static Properties accessPropertiesFile(String propertyfile) 
	{
		Properties prop = new Properties();
		// try retrieve data from file 
		try 
		{
			prop.load(new FileInputStream(propertyfile));
		}
		// catch exception in case properties file does not exist 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return prop;
	}


	/**
	 * extract number from string given
	 * @param word is the String that we want to extract
	 * Example : "Rp. 13.000 / bulan" > 13000
	 */
	public static int extractNumber(String word)
	{
		String str = word.replaceAll("[A-Z a-z . / : , ' ; ( )]","").trim();
		return Integer.parseInt(str);
	}

	
}