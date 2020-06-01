package com.practice.examples;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Example2 {

	static AppiumDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {

		DesiredCapabilities cap = new DesiredCapabilities();
		
		//Device details
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "VIVO 1726");
		cap.setCapability(MobileCapabilityType.UDID, "C6J7IZG6AAAADAMV");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		
		/*
		 * cap.setCapability(MobileCapabilityType.DEVICE_NAME, "VIVO V9");
		 * cap.setCapability(MobileCapabilityType.UDID, "7d4d90a0");
		 * cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		 */
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		

		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");

		cap.setCapability(MobileCapabilityType.APP,
				"G:\\Automation_Workspace\\PracticeAppium\\src\\test\\resources\\Apps\\readerassignapp_new_v3.0.6.apk");

		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AppiumDriver<MobileElement>(url, cap);
		
		Thread.sleep(10000);
		String appname =driver.findElement(By.id("assign.raspi.ui.newraspi_assign:id/text2")).getText();
		
		if(appname.equalsIgnoreCase("Reader Assign App"))
		{
			System.out.println("Reader Assign app launched successfully");
		}else
		{
			System.out.println("Wrong app installed");
		}
		
		driver.findElement(By.id("assign.raspi.ui.newraspi_assign:id/email")).sendKeys("harpreet");
		driver.findElement(By.id("assign.raspi.ui.newraspi_assign:id/password")).sendKeys("qaevent63");
		driver.findElement(By.id("assign.raspi.ui.newraspi_assign:id/email_sign_in_button")).click();
		
		Thread.sleep(5000);
		
		
		//driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		
		//driver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		//com.android.packageinstaller:id/permission_deny_button
		
		/*com.android.packageinstaller:id/permission_message
		 * com.android.packageinstaller:id/permission_message
		 * com.android.packageinstaller:id/permission_allow_button
		 * 
		 * com.android.packageinstaller:id/permission_deny_button
		 */
	}
}
