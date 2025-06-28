package com.dikahadir_selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='email']")
	WebElement emailField;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement passwordField;
	
	@FindBy(xpath = "//button[contains(@class, 'MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium')]")
	WebElement passVisibilityBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Masuk']")
	WebElement loginBtn;
	
	
	public void setEmail(String email) {
		emailField.sendKeys(email);
	}
	
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public void clickPassVisibility() {
		passVisibilityBtn.click();
	}
	
	public void clickLogin() {
		loginBtn.click();
	}

}
