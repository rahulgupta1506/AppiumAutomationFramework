package com.practice.examples;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;


public class VerticalScrol {

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
		 * cap.setCapability(MobileCapabilityType.BROWSER_VERSION, "80.0.3987.162");
		 */
		
		
		  cap.setCapability(MobileCapabilityType.DEVICE_NAME, "VIVO 1726");
		  cap.setCapability(MobileCapabilityType.UDID, "C6J7IZG6AAAADAMV");
		  cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1.0");
		  cap.setCapability(MobileCapabilityType.BROWSER_VERSION, "78.0.3904.62");
		  
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Appium");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		
		cap.setCapability("chromedriverExecutable", "G:\\Selenium\\chromedriver.exe");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, cap);
		driver.get("https://staging-pc.turnoutnow.com/Account/Login/peerconnect-sandbox-ton-342/9565be8c-5574-4f5c-9c03-e958acd44277");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void manageVerticalScroll() throws InterruptedException
	{
		
		driver.findElementById("UserName").sendKeys("342x131020");
		driver.findElementByXPath("//*[@class = 'submitField']/input").click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(10000);
		
		//-----Scroll By pixel
		/*
		 js.executeScript("window.scrollBy(0,250)");
		 */
		
		//-----Scroll By visibility of the element
		
		  WebElement Element = driver.findElement(By.xpath("//*[contains(text(),'similar profiles')]"));
		  js.executeScript("arguments[0].scrollIntoView();", Element);
		 
		  Thread.sleep(10000);
		
		//-----This will scroll the web page till end.	
		//js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		  
		  
		
		//driver.findElement(By.xpath("//*[@id='Match_342x163442']")).click();
		
		
		WebElement parentElement = driver.findElement(By.xpath("//*[@id = 'pcSimiliarDemographic']/ul/li"));
		List<WebElement> childElements = parentElement.findElements(By.xpath("//*[@id = 'pcSimiliarDemographic']/ul/li"));
		int count = childElements.size();
		System.out.println("Total Attendees under Similar profile: " + count);
		
		  for(int i =1; i<count;i++)
		  {
			  String attendeeName = childElements.get(i).getText();
			 System.out.println(attendeeName);
			//String expt = "Alan Allardice";
			 
			/*
			 * if(attendeeName.equalsIgnoreCase("Alan")) { //
			 * System.out.println(childElements.get(i).getText());
			 * childElements.get(i).click(); break; }
			 */
			 
			 
		  }	 
	}	
}