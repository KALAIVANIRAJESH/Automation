package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractice {
	
	@Test
	public void createCustomer()
	{
		System.out.println("Create");
	}
	
	@Test(dependsOnMethods = "createCustomer")
	public void modifyCustomer()
	{
		System.out.println("modify");
	}
	
	@Test(enabled = false)
	public void deleteCustomer()
	{
		System.out.println("delete");
	}

}
