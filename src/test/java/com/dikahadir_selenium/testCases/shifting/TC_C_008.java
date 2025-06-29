package com.dikahadir_selenium.testCases.shifting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.dikahadir_selenium.pageObjects.ShiftingPage;
import com.dikahadir_selenium.testBase.BaseClass;

public class TC_C_008 extends BaseClass {

	@Test(description = "TC_C_008")
	void cancelDelete() throws InterruptedException {
		ShiftingPage sp = new ShiftingPage(driver);
		driver.navigate().to("https://magang.dikahadir.com/management/shifting");
		String firstData = sp.datasFirstColumn().getFirst().getText();
		sp.clickActionFirst();
		sp.openDeleteDialog();
		Thread.sleep(500);
		sp.cancelDelete();
		driver.navigate().refresh();
		Thread.sleep(1500);
		sp.setSearch(firstData);
		sp.clickSearch();
		Thread.sleep(1000);
		Assert.assertEquals(sp.datasFirstColumn().getFirst().getText(),firstData);
	}

}
