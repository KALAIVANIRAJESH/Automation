package contactsTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUTilities.BaseClass;
import genericUTilities.ExcelFileUtility;
import genericUTilities.PropertyFileUtility;
import genericUTilities.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

@Listeners(genericUTilities.ListenersImplementation.class)
public class CreateContactTest extends BaseClass{

	@Test(groups = "SmokeSuite")
	public void createContactWithMandatoryFields() throws IOException, InterruptedException
	{
		/* Read Test Data From Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);

		// Step 4: Click On Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		// Step 5: Click on Create Contact Look Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		// Step 6: Create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);

       // Assert.fail();
		// Step 7: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.captureHeadertext();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);

	}

}
