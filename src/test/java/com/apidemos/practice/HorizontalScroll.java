package com.apidemos.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class HorizontalScroll {

AppiumDriver<WebElement> driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Vivo V9");
		  cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		  cap.setCapability(MobileCapabilityType.UDID,"7d4d90a0");
		
		/*
		 * cap.setCapability(MobileCapabilityType.DEVICE_NAME, "VIVO 1726");
		 * cap.setCapability(MobileCapabilityType.UDID, "C6J7IZG6AAAADAMV");
		 * cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		 */
		 
		  
		  
		  cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		  cap.setCapability(MobileCapabilityType.APP,
				"G:\\Automation_Workspace\\PracticeAppium\\src\\test\\resources\\Apps\\ApiDemos-debug.apk");

		  cap.setCapability(MobileCapabilityType.NO_RESET, false);
		  cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		
		
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		  driver = new AndroidDriver<WebElement>(url, cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
}
