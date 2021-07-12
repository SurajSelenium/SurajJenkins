package com.actitime.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestActiTimeVerifyPageTitle {
	WebDriver driver;

	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://laptop-smc8hiai/login.do");

	}



	@Test
	public void verifyLoginPageTitle()
	{
		String loginPageTitle = driver.getTitle();
		Assert.assertEquals(loginPageTitle, "actiTIME - Login");
		Reporter.log("The login page Title is matching",true);
	}



	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
