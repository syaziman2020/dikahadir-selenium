package com.dikahadir_selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalenderDetailPage extends BasePage{
	public CalenderDetailPage(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='search']")
	WebElement searchField;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "(//h4[contains(@class,'MuiTypography-root')])[1]")
	WebElement headerTitle;
	
	@FindBy(xpath = "//button[normalize-space()='Tambahkan Kalender']")
	WebElement addCalenderDetailBtn;
	
	By headerTitleLocator = By.xpath("(//h4[contains(@class,'MuiTypography-root')])[1]");
	
	@FindBy(xpath = "//label[normalize-space()='Pilih Tanggal']/following-sibling::*//button[contains(@aria-label,'Choose date')]")
	WebElement dateBtn;
	
	@FindBy(xpath = "//input[@placeholder='mm/dd/yyyy']")
	WebElement dateField;
	
	@FindBy(xpath = "//button[@title='Next month']")
	WebElement nextMonthBtn;
	
	@FindBy(xpath = "//button[normalize-space()='10']")
	WebElement chooseDateBtn;
	
	@FindBy(xpath = "//p[contains(@id,'helper-text')]")
	WebElement textUnitEmpty;
	
	@FindBy(css  = "#type")
	WebElement typeCuti;
	
	@FindBy(css = "div[id='menu-type'] li:nth-child(2)")
	WebElement chooseFirstTypeCutiOption;
	
	@FindBy(xpath = "//input[@id='description']")
	WebElement descriptionField;
	
	@FindBy(xpath = "//p[contains(@class,'MuiFormHelperText-root Mui-error')]")
	List<WebElement> messageDateEmptyElements;
	
	@FindBy(xpath = "//tbody/tr/td[3]/h6")
	List<WebElement> dataDescColumns;
	
	@FindBy(xpath = "//button[normalize-space()='Tambah']")
	WebElement addConfirmBtn;
	
	@FindBy(xpath = "//p[contains(@class,'MuiTablePagination-displayedRows')]")
	WebElement pageDisplay;
	
	@FindBy(xpath = "//button[normalize-space()='Batal']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "(//button[@aria-label='action'])[1]")
	WebElement firstActBtn;
	
	@FindBy(xpath = "(//li[@role='menuitem'][normalize-space()='Edit'])[1]")
	WebElement firstEditBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Simpan']")
	WebElement confirmEdit;
	
	By dialogLocator = By.xpath("//div[@role='dialog']");
	
	
	public By getDialogLocator() {
		return dialogLocator;
	}
	
	public List<WebElement> getDataDescColums(){
		return dataDescColumns;
	}
	
	public void clickFirstAction() {
		firstActBtn.click();
	}
	public void clickFirstEdit() {
		firstEditBtn.click();
	}
	
	public void setDateInput(String date) {
		dateField.sendKeys(date);
	}
	
	public List<WebElement> getMessageEmptyElements(){
		return messageDateEmptyElements;
	}
	
	public String getPageDisplay() {
		return pageDisplay.getText();
	}
	
	public void confirmAdd() {
		addConfirmBtn.click();
	}
	
	public void clickDate() {
		clickJs(dateBtn);
	}
	
	public void chooseNextMonth() {
		nextMonthBtn.click();
	}
	
	public void chooseDate() {
		clickJs(chooseDateBtn);
	}
	
	public void clickTypeCuti() {
		typeCuti.click();
	}
	
	public void clickFirstTypeCuti() {
		chooseFirstTypeCutiOption.click();
	}
	
	public void setDescription(String desc) {
		descriptionField.sendKeys(desc);
	}
	
	public void clearDate(int length) {
		clearUsingKeyboard(dateField, length);
	}
	
	public WebElement getDateField() {
		return dateField;
	}
	
	public void clearDescription(int length) {
		clearUsingKeyboard(descriptionField, length);
	}
	
	public WebElement getDescriptionField() {
		return descriptionField;
	}
	
	public void setSearch(String name) {
		searchField.sendKeys(name);
		
	}
	
	public void clickSearch() {
		searchBtn.click();
	}
	
	public WebElement getHeaderTitle() {
		return headerTitle;
	}
	
	public By getHeaderTitleLocator() {
		return headerTitleLocator;
	}
	
	public void addCalenderDetail() {
		addCalenderDetailBtn.click();
	}
	
	public void clickCancel() {
		cancelBtn.click();
	}
	public void clickConfirmEdit() {
		confirmEdit.click();
	}
	
}
