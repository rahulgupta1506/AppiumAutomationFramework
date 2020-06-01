package com.apidemos.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class HorizontalScrollMain {

	AppiumDriver<WebElement> driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException
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

		//cap.setCapability(MobileCapabilityType.APP, "G:\\Automation_Workspace\\PracticeAppium\\src\\test\\resources\\Apps\\ApiDemos-debug.apk");
		cap.setCapability("appPackage", "com.til.timesnews");
		cap.setCapability("appActivity","com.urbanairship.actions.LandingPageActivity");
		
		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, cap);
	}
	
	@Test
	public void horizontalScrollDown()
	{
		WebElement panel = driver.findElement(By.id(""));
		
		
		Dimension dim = panel.getSize();
		
		int anchor = panel.getSize().getHeight()/2;
		
		Double screenWidthStart = dim.getWidth()*0.8;
		int scrollStart = screenWidthStart.intValue();
		
		Double screenWidthEnd = dim.getWidth()*0.2;
		int scrollEnd = screenWidthEnd.intValue();
		
		new TouchAction((PerformsTouchActions) driver)
		.press(PointOption.point(scrollStart, anchor))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(scrollEnd, anchor))
		.release().perform();
	}
}
