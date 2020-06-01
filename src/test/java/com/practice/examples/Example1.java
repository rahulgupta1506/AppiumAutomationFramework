package com.practice.examples;

import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Example1 {

	static AppiumDriver<MobileElement> driver;

	public static void main(String arg[]) throws Exception {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "VIVO V9");
		cap.setCapability(MobileCapabilityType.UDID, "7d4d90a0");

		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

		
		  cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
		  cap.setCapability(MobileCapabilityType.BROWSER_VERSION, "80.0");
		  cap.setCapability("chromedriverExecutable", "G:\\Selenium\\chromedriver.exe");
		 
		/*
		 * cap.setCapability(MobileCapabilityType.APP,
		 * "G:\\Automation_Workspace\\PracticeAppium\\src\\test\\resources\\Apps\\readerassignapp_new_v3.0.6.apk"
		 * );
		 */
		// cap.setCapability("appPackage","com.android.bbkcalculator");
		// cap.setCapability("appActivity","com.android.bbkcalculator.Calculator");

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);

		
		/*
		 * cap.setCapability(MobileCapabilityType.NO_RESET, false);
		 * cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		 */
		  
		 
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);

		//driver.findElement(By.id("")).sendKeys("");
		
		driver.get("http://www.google.com");

	}
}
