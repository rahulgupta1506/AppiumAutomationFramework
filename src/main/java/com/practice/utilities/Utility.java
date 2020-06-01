package com.practice.utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import com.readerassignapp.base.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Utility extends TestBase {

	public Utility(AppiumDriver<WebElement> driver) throws IOException {
		super(driver);
		
	}

	public void ScrollDown()
	{
		Dimension dim = driver.manage().window().getSize();
		Double scrollHeightStart  = dim.getHeight() * 0.5;
		int scrollStart  = scrollHeightStart.intValue();
		
		Double scrollHeightEnd  = dim.getHeight() * 0.2;
		int scrollEnd = scrollHeightEnd.intValue();
		
		TouchAction action = new TouchAction((PerformsTouchActions) driver);
	
		action.press(PointOption.point(0, scrollStart))
		.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		.moveTo(PointOption.point(0, scrollEnd))
		.release().perform();
		
	}
	
}
