package com.dikahadir_selenium.testCases.shifting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_C_011 extends BaseClass{

	@Test(description = "TC_C_011")
	void validateNameAndCodeEdit() throws InterruptedException {
		ShiftingPage sp = new ShiftingPage(driver);
		driver.navigate().refresh();
		Thread.sleep(1000);
		sp.clickActionFirst();
		sp.clickEdit();
		String name=sp.getElementName().getDomProperty("value");
		String code = sp.getCodeUnit().getDomProperty("value");
		sp.clearName(name.length());
		sp.clearCode(code.length());

		sp.editConfirmButton();
		
		Assert.assertTrue(sp.getMessageMandatoryList().size() > 0);
	}
}
