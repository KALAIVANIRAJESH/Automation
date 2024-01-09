package contactsTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUTilities.BaseClass;
import objectRepository.ContactInfoPage;
import objectRepository.ContactsPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;

@Listeners(genericUTilities.ListenersImplementation.class)
public class CreateContactWithLeadSourceTest extends BaseClass{
	
	@Test(groups = "RegressionSuite")
	public void createContactWithLead() throws EncryptedDocumentException, IOException
	{
		
		/* Read Test Data From Excel File */
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 4, 2);
		String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 4, 3);

		// Step 4: Click On Contacts Link
		HomePage hp = new HomePage(driver);
		hp.clickOnContactsLink();

		// Step 5: Click on Create Contact Look Image
		ContactsPage cp = new ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		// Step 6: Create new contact
		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME,LEADSOURCE);

        //Assert.fail();//failed
		// Step 7: Validate
		ContactInfoPage cip = new ContactInfoPage(driver);
		String contactHeader = cip.captureHeadertext();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
	}

}
