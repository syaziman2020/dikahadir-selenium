package com.dikahadir_selenium.testCases.shifting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_C_017 extends BaseClass{
	@Test(description = "TC_C_017")
	void checkLastAndFirstPageDisplay() throws InterruptedException {
		ShiftingPage sp = new ShiftingPage(driver);
		driver.navigate().to("https://magang.dikahadir.com/management/shifting");
		Thread.sleep(1000);
		
		sp.clicklast();
		Thread.sleep(500);
		Assert.assertFalse(sp.getElementlast().isEnabled());
		
		sp.clickFirst();
		Thread.sleep(500);
		Assert.assertFalse(sp.getElementFirst().isEnabled());
	}
	

}
