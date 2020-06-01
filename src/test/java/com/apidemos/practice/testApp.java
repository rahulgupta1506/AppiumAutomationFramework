package com.apidemos.practice;

import java.net.MalformedURLException;

import org.testng.annotations.AfterTest;

public class testApp {
	
	@org.testng.annotations.Test
	public void Test() throws MalformedURLException, InterruptedException {
		DriverFactory.Android_LaunchApp();
		VerticalScrollMain scroll = new VerticalScrollMain();
		scroll.scrollTillWebView();
	}
	
	@AfterTest
	public void TearDown() {
		//DriverFactory.CloseApp();
	}
}
