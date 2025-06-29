package com.dikahadir_selenium.testCases.shifting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_C_009 extends BaseClass {

	@Test(description = "TC_C_009")
	void confirmDelete() throws InterruptedException {
		ShiftingPage sp = new ShiftingPage(driver);
		driver.navigate().to("https://magang.dikahadir.com/management/shifting");
		String firstData = sp.datasFirstColumn().getFirst().getText();
		sp.clickActionFirst();
		sp.openDeleteDialog();
		
		sp.confirmDelete();
		Thread.sleep(700);
		sp.setSearch(firstData);
		sp.clickSearch();
		Thread.sleep(1000);
		Assert.assertEquals(sp.getPageDisplay(), "0-0 of 0");
	}

}
