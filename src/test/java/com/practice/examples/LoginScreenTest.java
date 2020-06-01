package com.practice.examples;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.readerassignapp.base.TestBase;
import com.readerassignapp.pages.HomePageScreen;
import com.readerassignapp.pages.LoginScreen;

public class LoginScreenTest extends TestBase
{
	LoginScreen log;
	HomePageScreen homepage;
	
	public LoginScreenTest() throws IOException
	{ 
		 super(driver); 
	}
	 
	
	@BeforeClass
	public void setup() throws IOException, InterruptedException
	{
		initialization();
		log = new LoginScreen(driver);
		homepage = new HomePageScreen(driver);	
	}
	
	//To verify launched App correct or not?
	@Test(priority =1)
	public void toVerifyScreenTitle() throws InterruptedException
	{
		String text = log.screenVerify();
		System.out.println("App Name: "+text);
		Assert.assertEquals(text, "Reader Assign App");
	}
	
	//To verify login is working or not?
	@Test(priority =2)
	public void toVerifyLogin() throws InterruptedException, IOException
	{
	
		homepage = log.toCheckLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}

