package ch.nyp.atm.config;

import java.io.IOException;
import java.util.Properties;

/**
 * This class loads content of a given property file and parses its string and
 * int values
 *
 * @author Yves Kaufmann
 */
public class PropertyReader {
	
	private Properties properties;
	
	/**
	 * @param fileURL URL to the property file
	 */
	public PropertyReader(String fileURL) throws IOException {
		
		properties = new Properties();
		properties.load(getClass().getClassLoader().getResourceAsStream(fileURL));
	}
	
	/**
	 * This method gets the requested property as a string and parses it into an
	 * integer
	 *
	 * @param  propName Requested property
	 * @return          Requested property as an integer
	 */
	public Integer getIntProperty(String propName) {
		
		String propVal = properties.getProperty(propName);
		return Integer.parseInt(propVal);
	}
	
	/**
	 * This method gets the requested property as a string
	 *
	 * @param  propName Requested property
	 * @return          Requested property as a string
	 */
	public String getStringProperty(String propName) {
		
		String propVal = properties.getProperty(propName);

		return propVal;
		
	}
}
