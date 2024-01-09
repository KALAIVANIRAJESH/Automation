package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUTilities.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility{
	

	@FindBy(name = "lastname")
	private WebElement LastNameEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropdown;
	

	// initiliazation
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getLastNameEdt() {
		return LastNameEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getleadSourceDropdown() {
		return leadSourceDropdown;
	}
	

	//Business Library
	
	/**
	 * This method will create a new Contact and save it
	 * @param LASTNAME
	 */
	public void createNewContact(String LASTNAME)
	{
		LastNameEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	
	/**
	 * This method will create a new Contact using lead source drop-down and save it
	 * @param LASTNAME
	 * @param LEADSOURCEVALUE
	 */
	public void createNewContact(String LASTNAME, String LEADSOURCEVALUE)
	{
		LastNameEdt.sendKeys(LASTNAME);
		handleDropdown(leadSourceDropdown, LEADSOURCEVALUE);
		SaveBtn.click();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
