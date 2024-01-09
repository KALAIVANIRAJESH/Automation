package practice;

//import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import genericUTilities.ExcelFileUtility;
import genericUTilities.PropertyFileUtility;
import genericUTilities.SeleniumUtility;
import objectRepository.LoginPage;

public class Scenario1WithDDTAndUtils {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
		//Create Object of Required Utility Classes
		PropertyFileUtility pUtil = new PropertyFileUtility();
		ExcelFileUtility eUtil = new ExcelFileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		
		/*Read Common Data from Property File*/
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		/*Read Test Data From Excel File*/
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		
		// Step 1: Launch the Base browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitilyWait(driver);

		// Step 2: Load the Application
		driver.get(URL);

		// Step 3: Login to Application
		
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
//		lp.getUsernameEdt().sendKeys(USERNAME);
//		lp.getPasswordEdt().sendKeys(PASSWORD);
//		lp.getLoginBtn().click();
//		

		// Step 4: Click On Contacts Link
		driver.findElement(By.linkText("Contacts")).click();

		// Step 5: Click on Create Contact Look Image
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();

		// Step 6: Create new contact
		driver.findElement(By.name("lastname")).sendKeys(LASTNAME);

		// Step 7: Save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Step 8: Validate
		String contactHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (contactHeader.contains(LASTNAME)) {
			System.out.println(contactHeader);
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}

		// Step 9: Logout of App
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));

		sUtil.mouseOverAction(driver, ele);

		Thread.sleep(1000);

		driver.findElement(By.linkText("Sign Out")).click();

		// Step 10: Close the browser
		driver.quit();
		
		
	}

}
