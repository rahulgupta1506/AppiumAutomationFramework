package com.readerassignapp.pages;



import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.readerassignapp.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class HomePageScreen extends TestBase{

	  //Page Factory
	  @AndroidFindBy(id = "com.android.packageinstaller:id/permission_message")
	  MobileElement permision_message;
	  
	  @AndroidFindBy(id = "com.android.packageinstaller:id/current_page_text")
	  MobileElement popup_count;
	
	  @AndroidFindBy(id ="com.android.packageinstaller:id/permission_allow_button")
	  MobileElement allow_btn;
	  
	  @AndroidFindBy(id = "com.android.packageinstaller:id/permission_deny_button")
	  MobileElement deny_btn;
	  
	  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Events']")
	  MobileElement title;
	  
	  @AndroidFindBy(id = "assign.raspi.ui.newraspi_assign:id/eventNameText")
	  MobileElement event_name;
	  
	  @AndroidFindBy(id = "assign.raspi.ui.newraspi_assign:id/datetext")
	  MobileElement event_duration;
	  
	  @AndroidFindBy(id = "assign.raspi.ui.newraspi_assign:id/locationText")
	  MobileElement event_location;
	  
	  //Initialization
	  public HomePageScreen(AppiumDriver<WebElement> driver) throws IOException 
	  {
		super(driver);	
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	  }
	
	  
	  //Features-1
	  public String toCheckPermissionMessage() 
	  { 
		  return permision_message.getText(); 	  
	  }
	  
	  //Features-2
	  public void toallowPermissionMessage()
	  {
		  allow_btn.click();
	  }
	  
	  //Features-3
	  public void todenyPermissionMessage()
	  {
		  deny_btn.click();
	  }
	  
	  public int toCheckPopUpCount()
	  {
		  int size = 0;
		  String text = popup_count.getText();
		  if(text.contains("2"))
		  {
			 size = 2;
		  }
		  return size;
	  }
	  
	
	  public String toCheckHomeScreenTitle() 
	  { 
		  //MobileElement title = driver.findElement(By.xpath("//android.widget.TextView[@text='Events']"));
			String screentitle = title.getText();
			return screentitle;
	  }
	 
	  public String toCheckEventName()
	  {
		  	return event_name.getText();
		  	
	  }
	  
	  public String toCheckEventDate()
	  {
		  	return event_duration.getText();
		  	
	  }
	  public String toCheckEventLocation()
	  {
		  	return event_location.getText();
		  	
	  }
}
	  
	  
	 
