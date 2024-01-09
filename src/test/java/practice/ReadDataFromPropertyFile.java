package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	
	public static void main(String[] args) throws IOException {
		
		//Step 1: Open then document in Java Readable format
		FileReader fis = new FileReader(".\\src\\test\\resources\\CommonData.properties");
		
		//Step 2: Create Object of Properties Class from Java.util
		Properties p = new Properties();
		
		//Step 3: Load the File input stream to properties class
		p.load(fis);
		
		//Step 4: provide key and read the value
		String value = p.getProperty("abc");
		System.out.println(value);
		
		
	}

}
