package practice;

import java.io.IOException;

import genericUTilities.ExcelFileUtility;
import genericUTilities.JavaUtility;
import genericUTilities.PropertyFileUtility;

public class GenericUtilityPractice {
	
	public static void main(String[] args) throws IOException {
		
		PropertyFileUtility pUtil = new PropertyFileUtility();
		String value = pUtil.readDataFromPropertyFile("username");
		System.out.println(value);
		
		ExcelFileUtility eUtil = new ExcelFileUtility();
		String data = eUtil.readDataFromExcel("Contacts", 1, 1);
		System.out.println(data);
		
		JavaUtility jUtil = new JavaUtility();
		System.out.println(jUtil.getSystemDate());
		
	}

}
