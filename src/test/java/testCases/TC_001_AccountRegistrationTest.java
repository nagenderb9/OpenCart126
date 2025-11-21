package testCases;


import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

	//WebDriver driver;
	
	
	@Test(groups= {"Sanity","Master"}) //Step8 groups added
	public void verify_account_registration()
	{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		try
		{
	
		
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on MyAccount Link.. ");
		
		hp.clickRegister();
		logger.info("Clicked on Register Link.. ");
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstName(randomestring().toUpperCase());
		regpage.setLastName(randomestring().toUpperCase());;
		regpage.setEmail(randomestring()+"@gmail.com");
		
		regpage.setTelephone(randomenumber());
		
		String password=randomeAplhanumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		
		logger.info("Validating expected message..");
		
		String confmsg= regpage.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
				{
			Assert.assertTrue(true);
			
				}
		else
		{
			logger.error("Test failed:");
			logger.debug("debug logs");
			Assert.assertTrue(false);
		}
		//Assert.assertEquals(confmsg, "Your Account Has Been Created!!!");
		
		
		//logger.info("Test passed");
	}
		catch (Exception e)
		{
			//logger.error("Test failed:" + e.getMessage());
		//	logger.debug("debug logs");
			Assert.fail();
		} 
	
		logger.info("***** Finished TC001_AccountRegistrationTest *****");
		
	}
	
}
