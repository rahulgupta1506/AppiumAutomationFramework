package com.apidemos.practice;

import java.io.IOException;
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

import com.practice.utilities.Utility;
import com.readerassignapp.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class VerticalScrollDown extends TestBase{

	Utility util;
	
	public VerticalScrollDown(AppiumDriver<WebElement> driver) throws IOException 
	{
		super(driver);
	}

//AppiumDriver<WebElement> driver;
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initialization();
		util = new Utility(driver);
	}
	
	@Test
	public void VerticalScrollDownfn()
	{
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		
		List<WebElement> list = driver.findElements(By.xpath("//android.widget.TextView[@text='WebView']"));		
		
		while(list.size() == 0)
		{
		   util.ScrollDown();
		}
		
		if(list.size() > 0)
		{
			list.get(0).click();
		}
		
	}
}
