package genericUTilities;

import java.util.Date;

/**
 * This class consists of reusable methods related to Java
 * @author Chaitra M
 *
 */
public class JavaUtility {
	
	/**
	 * This method will return the current system Date in specified format
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String[] dArr = d.toString().split(" ");
		String currentDate = dArr[2]+"-"+dArr[1]+"-"+dArr[5]+" "+dArr[3].replace(":", "_");
		return currentDate;
	}

}
