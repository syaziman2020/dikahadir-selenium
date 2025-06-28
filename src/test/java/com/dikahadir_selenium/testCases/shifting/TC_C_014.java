package com.dikahadir_selenium.testCases.shifting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_C_014 extends BaseClass{
	@Test(description = "TC_C_014")
	void cancelEdit() throws InterruptedException {
		ShiftingPage sp = new ShiftingPage(driver);
		driver.navigate().refresh();
		Thread.sleep(1000);
		
		sp.clickActionFirst();
		sp.clickEdit();
		String name=sp.getElementName().getDomProperty("value");
		String code = sp.getCodeUnit().getDomProperty("value");
		sp.clearName(name.length());
		sp.clearCode(code.length());
		String newName = randomAlpha(6);
		sp.setName(newName);
		sp.setCodeUnit(randomNumeric(6));

		sp.clickCancel();
		driver.navigate().refresh();
		Thread.sleep(500);
		sp.setSearch(newName);
		sp.clickSearch();
		Thread.sleep(500);
		Assert.assertEquals(sp.getPageDisplay(), "0-0 of 0");
	}

}
