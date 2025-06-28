package com.dikahadir_selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CalenderPage extends BasePage{
	public CalenderPage(WebDriver driver){
		super(driver);
	}
	
	
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchField;
	
	@FindBy(xpath = "//button[normalize-space()='Reset']")
	WebElement resetBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Tambahkan Kalender']")
	WebElement addCalenderBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Batal']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Tambah']")
	WebElement addConfirmBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Simpan']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement calenderUnitField;
	
	@FindBy(xpath = "//p[@id='name-helper-text']")
	WebElement textUnitEmpty;
	
	@FindBy(xpath = "//div[contains(@class,'MuiSnackbarContent-message')]")
	WebElement messageSnackbar;
	
	@FindBy(xpath = "(//li[@role='menuitem'][normalize-space()='Delete'])[1]")
	WebElement deleteFirstBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Tidak']")
	WebElement cancelDeleteBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Ya']")
	WebElement confirmDeleteBtn;
	
	@FindBy(xpath = "(//li[@role='menuitem'][normalize-space()='View'])[1]")
	WebElement viewBtn;
	
	@FindBy(xpath = "//p[text()='Rows per page:']/following-sibling::div[contains(@class,'MuiInputBase-root')]")
	WebElement rowsPerPageBtn;
	
	@FindBy(xpath = "//li[normalize-space()='25']")
	WebElement dropdown25Btn;
	
	@FindBy(xpath = "//p[contains(@class,'MuiTablePagination-displayedRows')]")
	WebElement pageDisplay;
	
	@FindBy(xpath = "//button[@title='Go to next page']")
	WebElement nextBtn;
	
	@FindBy(xpath = "//button[@title='Go to last page']")
	WebElement lastBtn;
	
	@FindBy(xpath = "//button[@title='Go to previous page']")
	WebElement previousBtn;
	
	@FindBy(xpath = "//button[@title='Go to first page']")
	WebElement firstBtn;
	
	@FindBy(xpath = "//tr/td[1]/h6")
	List<WebElement> listDataFirstColumn;
	
	@FindBy(xpath = "//tbody/tr/td[2]//button")
	List<WebElement> listActionBtn;
	
	@FindBy(xpath = "(//li[@role='menuitem'][normalize-space()='Edit'])[1]")
	WebElement editFirstBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Simpan']")
	WebElement confirmEditBtn;
	
	By dialogLocator = By.xpath("//div[@role='dialog']");
	
	public void clickConfirmEdit() {
		confirmEditBtn.click();
	}
	
	public String getPageDisplay() {
		return pageDisplay.getText();
	}
	
	public By getDialogLocator() {
		return dialogLocator;
	}
	
	public List<WebElement> getListActionBtn(){
		return listActionBtn;
	};
	
	public List<WebElement> getListDataFirstColumn(){
		return listDataFirstColumn;
	}
	
	public void clickReset() {
		resetBtn.click();
	}
	
	public void clearCalenderUnit(int length) {
		clearUsingKeyboard(calenderUnitField, length);
	}
	
	public WebElement getCalenderUnitElement() {
		return calenderUnitField;
	}
	
	
	public void clickAdd() {
		addCalenderBtn.click();
	}
	
	public void clickCancel() {
		cancelBtn.click();
	}
	
	public void clickAddConfirm() {
		addConfirmBtn.click();
	}
	
	public void setCalenderUnit(String unit) {
		calenderUnitField.sendKeys(unit);
	}
	
	public void clickViewFirst() {
		clickJs(viewBtn);
	}
	
	
	public WebElement messageUnitEmptyElement() {
		return textUnitEmpty;
	}
	
	public String snackbarMessage() {
		return messageSnackbar.getText();
	}
	
	public void saveEditData() {
		saveBtn.click();
	}
	
	public void clickEditFirst() {
		clickJs(editFirstBtn);
	}
	
	public void deleteFirstData() {
		clickJs(deleteFirstBtn);
	}
	
	public void clickCancelDelete() {
		cancelDeleteBtn.click();
	}
	
	public void clickConfirmDelete() {
		confirmDeleteBtn.click();
	}
	
	public void clickDropdownTotalRows() {
		rowsPerPageBtn.click();
	}
	
	public void selectValTotalRows() {
		dropdown25Btn.click();
	}
	
	public void clickNext() {
		nextBtn.click();
	}
	
	public void clicklast() {
		lastBtn.click();
	}
	
	public void clickPrevious() {
		previousBtn.click();
	}
	
	public void clickFirst() {
		firstBtn.click();
	}
	
	
	public void setSearch(String name) {
		searchField.sendKeys(name);
		
	}
	
	public void clickSearch() {
		searchBtn.click();
	}

}
