package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
	@Test
	public void sample()
	{
		System.out.println("step1");
		System.out.println("step2");
		
		Assert.assertEquals(true, true);
		
		System.out.println("step3");
		
		Assert.assertEquals(1, 1);
		
		System.out.println("step4");
	}
	
	@Test
	public void sample1()
	{
		SoftAssert sa = new SoftAssert();
		
		System.out.println("step1");
		System.out.println("step2");
	
		System.out.println("step3");
		
		sa.assertEquals(1, 0);
		
		System.out.println("step4");
		
		Assert.assertTrue(false);
		
		sa.assertAll();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
