package com.dikahadir_selenium.testCases.common;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.dikahadir_selenium.pageObjects.LoginPage;

public class LoginTest{

	public static void login(WebDriver driver, Properties property) {
		LoginPage lp = new LoginPage(driver);

		lp.setEmail(property.getProperty("email"));
		lp.setPassword(property.getProperty("password"));
		lp.clickLogin();
	}
}
