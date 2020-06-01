package com.readerassignapp.base;

import java.io.FileInputStream;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.AppiumDriver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {

	public static AppiumDriver<WebElement> driver;
	public Properties prop;
	
	public TestBase(AppiumDriver<WebElement> driver) throws IOException
	{
		prop = new Properties();
		FileInputStream file = new FileInputStream("G:\\Automation_Workspace\\PracticeAppium\\src\\main\\java\\com\\readerassignapp\\configuration\\config.properties");
		prop.load(file);
			
	}
	
	public void initialization() throws MalformedURLException, InterruptedException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//Device details
		
		/*
		 * cap.setCapability(MobileCapabilityType.DEVICE_NAME, "VIVO 1726");
		 * cap.setCapability(MobileCapabilityType.UDID, "C6J7IZG6AAAADAMV");
		 * cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		 */
		 
		
		
		
		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "VIVO V9");
		  cap.setCapability(MobileCapabilityType.UDID, "7d4d90a0");
		  cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		 
		 
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

		cap.setCapability(MobileCapabilityType.APP, prop.getProperty("apkpath"));

		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, cap);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
}
