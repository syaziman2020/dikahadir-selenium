package com.dikahadir_selenium.testCases.shifting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_C_010 extends BaseClass{
	
	@Test(description = "TC_C_010")
	void validateFormEdit() {
		ShiftingPage sp = new ShiftingPage(driver);
		driver.navigate().to("https://magang.dikahadir.com/management/shifting");
		String expectedNameFirst = sp.datasFirstColumn().getFirst().getText();
		sp.clickActionFirst();
		sp.clickEdit();
		
		String actualName=sp.getElementName().getDomProperty("value");
		Assert.assertEquals(actualName, expectedNameFirst);
	}

}
