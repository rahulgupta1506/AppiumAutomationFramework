package com.apidemos.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

public class NaukriScrollDown {

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
		  
		  cap.setCapability("appPackage","naukriApp.appModules.login");
		  cap.setCapability("appActivity","com.naukri.dashboard.view.NaukriSplashScreen");
		  
		  cap.setCapability(MobileCapabilityType.NO_RESET, false);
		  cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		
		
		  URL url = new URL("http://127.0.0.1:4723/wd/hub");
		  driver = new AndroidDriver<WebElement>(url, cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void screenScrolldown() throws InterruptedException
	{
		Thread.sleep(10000);
		driver.findElement(By.id("naukriApp.appModules.login:id/tv_jbrecuriter_title")).click();
		
		List<WebElement> list = driver.findElementsById("naukriApp.appModules.login:id/inboxRowCard");
		
		System.out.println(list.size());
		
		Dimension dim = driver.manage().window().getSize();
		Double scrollHeightStart  = dim.getHeight() * 0.5;
		int scrollStart  = scrollHeightStart.intValue();
		
		Double scrollHeightEnd  = dim.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();
		
		TouchAction action = new TouchAction((PerformsTouchActions) driver);
	
		action.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
	}
}
