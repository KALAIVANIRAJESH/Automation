package genericUTilities;

//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * This Class consists of reusable methods related to property file
 * @author Chaitra M
 *
 */
public class PropertyFileUtility {
	
	
	/**
	 * This method will read data from Property File and return the value to the caller
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException
	{
		FileReader fis = new FileReader(".\\src\\test\\resources\\CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;
	}

}
