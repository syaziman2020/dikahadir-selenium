package com.dikahadir_selenium.testCases.shifting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_C_003 extends BaseClass{
	
	@Test(description = "TC_C_003")
	void validateEmptyFieldConfirm() throws InterruptedException {
		ShiftingPage sp = new ShiftingPage(driver);
		
		sp.clickAdd();
		Thread.sleep(200);
		
		sp.clickConfirmAdd();
		Assert.assertTrue(sp.getMessageMandatoryName().isDisplayed());
		
	}

}
