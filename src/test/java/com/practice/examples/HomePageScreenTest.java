package com.practice.examples;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.readerassignapp.base.TestBase;
import com.readerassignapp.pages.HomePageScreen;
import com.readerassignapp.pages.LoginScreen;



public class HomePageScreenTest extends TestBase{
	
	HomePageScreen homepage;
	LoginScreen login;
	
	String perm_message;
	
	public HomePageScreenTest() throws IOException
	{
		super(driver);
	}
	
	@BeforeClass
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		login = new LoginScreen(driver);
		Thread.sleep(10000);
		homepage = login.toCheckLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority=1)
	public void toVerifyUserIsLoggedIn()
	{
		if(homepage.toCheckPermissionMessage().isEmpty())
		{
			System.out.println("User is not logged In");
		}else
		{
			System.out.println("User logged In Successfully");
		}
	}
	
	@Test(priority =2)
	public void toVerifyPermissionAlert()
	{
		 int number = homepage.toCheckPopUpCount();
		 System.out.println(number);
		 for(int i=1;i<=number;i++)
		 {
			 perm_message = homepage.toCheckPermissionMessage();
			 System.out.println(perm_message);
			 if(perm_message.contains("Allow Reader Assign App"))
			 	{
				 	homepage.toallowPermissionMessage();
			 	}else
			 	{
			 		homepage.todenyPermissionMessage();
			 	}
		 }
	}
	
	/*
	 * @Test(priority =3) public void toVerifyHomeScreenContent() { String
	 * screen_title = homepage.toCheckHomeScreenTitle();
	 * Assert.assertEquals(screen_title, "Events"); }
	 */
	
	@Test(priority = 4)
	public void toVerifyEventDetails()
	{
		String event_name = homepage.toCheckEventName();
		Assert.assertEquals(event_name,prop.getProperty("eventname"), "Wrong Event Name shown");
		System.out.println("Event Name: "+event_name);
		
		String event_date = homepage.toCheckEventDate();
		Assert.assertEquals(event_date,prop.getProperty("eventdate"), "Wrong Event date shown");
		System.out.println("Event Date: "+event_date);
		
		String event_location = homepage.toCheckEventLocation();
		Assert.assertEquals(event_location,prop.getProperty("eventlocation"), "Wrong Event location shown");
		System.out.println("Event Location: "+event_location);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
