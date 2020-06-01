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

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class VerticalScrollMain {

	AppiumDriver<WebElement> driver;
	public static void main(String args[]) throws MalformedURLException, InterruptedException
	
	{
		VerticalScrollMain scroll = new VerticalScrollMain();
		scroll.initialization();
		scroll.scrollTillWebView();
	}
		
	public void scrollDown() {
			Dimension dimension = driver.manage().window().getSize();
			
			Double scrollHeightStart = dimension.getHeight() * 0.5;
			int scrollStart = scrollHeightStart.intValue();
			
			Double scrollHeightEnd = dimension.getHeight() * 0.2;
			int scrollEnd = scrollHeightEnd.intValue();
			
			new TouchAction((PerformsTouchActions) driver)
			.press(PointOption.point(0, scrollStart))
			.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
			.moveTo(PointOption.point(0, scrollEnd))
			.release().perform();
		}
		
	public WebElement getItemViews() {
			return driver.findElement(By.xpath("//android.widget.TextView[@text='Views']"));
		}
		
	public List<WebElement> getItemWebView(){
			return driver.findElements(By.xpath("//android.widget.TextView[@text='WebView']"));
	}
		
	public void scrollTillWebView() throws InterruptedException {
			getItemViews().click();
			
			while(getItemWebView().size() == 0) {
				scrollDown();
			}
			
			if(getItemWebView().size() > 0) {
				getItemWebView().get(0).click();
			}
			Thread.sleep(4000);	
			
		}

	public void initialization() throws MalformedURLException, InterruptedException
	{
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

		cap.setCapability(MobileCapabilityType.APP, "G:\\Automation_Workspace\\PracticeAppium\\src\\test\\resources\\Apps\\ApiDemos-debug.apk");

		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		cap.setCapability(MobileCapabilityType.FULL_RESET, false);

		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<WebElement>(url, cap);
		
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}

}
