package com.dikahadir_selenium.testCases.shifting;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_C_013 extends BaseClass{
	@Test(description = "TC_C_013")
	void validateDuplicatCode() throws InterruptedException {
		ShiftingPage sp = new ShiftingPage(driver);
		driver.navigate().to("https://magang.dikahadir.com/management/shifting");
		Thread.sleep(1000);
		String secondDataCode = sp.datasCodeColumn().get(2).getText();
		sp.clickActionFirst();
		sp.clickEdit();
		String name=sp.getElementName().getDomProperty("value");
		String code = sp.getCodeUnit().getDomProperty("value");
		sp.clearName(name.length());
		sp.clearCode(code.length());
		String newName = randomAlpha(6);
		sp.setName(newName);
		sp.setCodeUnit(secondDataCode);

		sp.editConfirmButton();
		Thread.sleep(100);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		WebElement snackbar = wait.until(ExpectedConditions.presenceOfElementLocated(sp.getSnackbarMessageLocator()));
		
		Assert.assertTrue(snackbar.isDisplayed());
	}
}
