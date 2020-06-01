package com.readerassignapp.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.readerassignapp.base.TestBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class LoginScreen extends TestBase{

	//Page Factory
	@AndroidFindBy(id = "assign.raspi.ui.newraspi_assign:id/email")
	MobileElement uname;
	
	@AndroidFindBy(id = "assign.raspi.ui.newraspi_assign:id/password")
	MobileElement pword;
	
	@AndroidFindBy(id = "assign.raspi.ui.newraspi_assign:id/email_sign_in_button")
	MobileElement loginbtn;
	
	@AndroidFindBy(id = "assign.raspi.ui.newraspi_assign:id/text2")
	MobileElement screenText;
	
	@AndroidFindBy(id= "android:id/text1")
	MobileElement suggestion;
	
	@AndroidFindBy(id= "android:id/content")
	MobileElement contenttext;
	
	//Initialization
	public LoginScreen(AppiumDriver<WebElement> driver) throws IOException
	{
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	//Feature-1 
	public String screenVerify()
	{
		return(screenText.getText());
	}
	
	//Feature-2
	public HomePageScreen toCheckLogin(String us, String pwd) throws IOException, InterruptedException
	{
		
		  Thread.sleep(5000); 
		  boolean suggestiontext = suggestion.isDisplayed();
		  if(suggestiontext == true) 
		  { contenttext.click(); Thread.sleep(5000); }
		 
		
		uname.sendKeys(us);
		pword.sendKeys(pwd);
		loginbtn.click();
		return new HomePageScreen(driver);
	}
	
	
}
