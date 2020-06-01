package com.practice.examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class VerticalScrollAPP {
AppiumDriver<MobileElement> driver;
	
	@BeforeMethod
	public void setup() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		/*
		 * cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Vivo V9");
		 * cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		 * cap.setCapability(MobileCapabilityType.UDID,"7d4d90a0");
		 *
		 */
		
		
		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "VIVO 1726");
		  cap.setCapability(MobileCapabilityType.UDID, "C6J7IZG6AAAADAMV");
		  cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		  
		  
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.APP,
				"G:\\Automation_Workspace\\PracticeAppium\\src\\test\\resources\\Apps\\readerassignapp_new_v3.0.6.apk");

		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);
		
		
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void VerticalScroll() throws InterruptedException {
		
		driver.findElementById("assign.raspi.ui.newraspi_assign:id/email").sendKeys("harpreet");
		driver.findElementById("assign.raspi.ui.newraspi_assign:id/password").sendKeys("qaevent63");
		driver.findElementById("assign.raspi.ui.newraspi_assign:id/email_sign_in_button").click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		driver.findElementById("com.android.packageinstaller:id/permission_allow_button").click();
		
		
		String text = driver.findElementById("assign.raspi.ui.newraspi_assign:id/eventNameText").getText();
		System.out.println(text);
		/*
		 * Thread.sleep(5000); WebElement element =
		 * driver.findElement(By.xpath("//android.widget.TextView[@text = 'All']"));
		 * 
		 * TouchActions action = new TouchActions(driver); action.singleTap(element);
		 * action.perform();
		 */
		 

	}
	
	
}
