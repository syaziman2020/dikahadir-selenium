package com.dikahadir_selenium.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage {
	
	@FindBy(xpath = "(//div[contains(@class,'sidebar__item MuiBox-root')])[4]")
	WebElement managementSideBar;
	
	@FindBy(xpath = "//div[contains(@class,'MuiBox-root')]/p[normalize-space()='Absen Point']")
	WebElement absentPointBtn;
	
	@FindBy(xpath = "//div[contains(@class,'MuiBox-root')]/p[normalize-space()='Jabatan']")
	WebElement jabatanBtn;
	
	@FindBy(xpath = "//div[contains(@class,'MuiBox-root')]/p[normalize-space()='Shifting']")
	WebElement shiftingBtn;
	
	@FindBy(xpath = "//div[contains(@class,'MuiBox-root')]/p[normalize-space()='Jadwal']")
	WebElement jadwalBtn;
	
	@FindBy(xpath="//div[contains(@class,'MuiBox-root')]/p[normalize-space()='Kalender']")
	WebElement kalenderBtn;
	
	@FindBy(xpath = "//div[contains(@class,'MuiBox-root')]/p[normalize-space()='Aturan Cuti']")
	WebElement aturanCutiBtn;
	
	@FindBy(xpath = "//div[contains(@class,'MuiBox-root')]/p[normalize-space()='Day Off']")
	WebElement dayOffBtn;
	
	public void clickManagementSidebar() {
		managementSideBar.click();
	}
	
	public void clickAbsentPoint() {
		absentPointBtn.click();
	}
	
	public void clickJabatan() {
		jabatanBtn.click();
	}
	
	public void clickShifting() {
		shiftingBtn.click();
	}
	
	public void clickJadwal() {
		jadwalBtn.click();
	}
	
	public void clickKalender() {
		kalenderBtn.click();
	}
	
	public void clickAturanCuti() {
		aturanCutiBtn.click();
	}
	
	public void clickDayOff() {
		dayOffBtn.click();
	}
}
