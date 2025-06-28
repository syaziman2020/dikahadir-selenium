package com.dikahadir_selenium.testCases.common;

import org.openqa.selenium.WebDriver;

import com.dikahadir_selenium.pageObjects.DashboardPage;

public class GoToShiftingTest {

	public static void navigate(WebDriver driver) {
		DashboardPage dp = new DashboardPage(driver);
		dp.clickManagementSidebar();
		dp.clickShifting();
	}
}
