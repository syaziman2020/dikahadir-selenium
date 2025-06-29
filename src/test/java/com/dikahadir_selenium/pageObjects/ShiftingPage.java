package com.dikahadir_selenium.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ShiftingPage extends BasePage{
	public ShiftingPage(WebDriver driver) {
		super(driver);
	};
	
	@FindBy(xpath="//input[@id='search']")
	WebElement searchField;
	
	@FindBy(xpath = "//button[normalize-space()='Reset']")
	WebElement resetBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Search']")
	WebElement searchBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Tambahkan']")
	WebElement addBtn;
	
	@FindBy(xpath = "//tbody/tr")
	List<WebElement> rowData;
	
	@FindBy(xpath = "//tbody/tr/td[1]/h6")
	List<WebElement> firstColumnDatas;
	
	@FindBy(xpath = "//tbody/tr/td[7]/h6")
	List<WebElement> codeColumnDatas;
	
	@FindBy(xpath = "(//li[@role='menuitem'][normalize-space()='Edit'])[1]")
	WebElement editFirstBtn;
	
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
	
	@FindBy(xpath = "(//li[@role='menuitem'][normalize-space()='Delete'])[1]")
	WebElement deleteFirstBtn;
	
	@FindBy(xpath = "(//button[@aria-label='action'])[1]")
	WebElement actionFirstBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Tidak']")
	WebElement cancelDeleteBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Ya']")
	WebElement confirmDeleteBtn;
	
	@FindBy(xpath="//div[contains(@class,'MuiSnackbarContent-message')]")
	WebElement snackBarMessage;
	
	By snackBarMessageLocator = By.xpath("//div[contains(@class,'MuiSnackbarContent')]");
	
	@FindBy(xpath = "//input[@id='name']")
	WebElement nameShiftField;
	
	@FindBy(xpath = "//button[@title='Open']")
	WebElement openUnit;
	
	@FindBy(xpath = "//li[@id='job_departement-option-3']")
	WebElement unitThirdOption;
	
	@FindBy(xpath = "//label[normalize-space()='Jam Masuk']/following-sibling::*//button[contains(@aria-label,'Choose time')][1]")
	WebElement timeInShow;
	
	@FindBy(xpath = "//label[normalize-space()='Jam Keluar']/following-sibling::*//button[contains(@aria-label,'Choose time')][1]")
	WebElement timeOutShow;
	
	@FindBy(xpath = "//label[normalize-space()='Break Start']/following-sibling::*//button[contains(@aria-label,'Choose time')][1]")
	WebElement breakStartBtn;
	
	@FindBy(xpath = "//label[normalize-space()='Break End']/following-sibling::*//button[contains(@aria-label,'Choose time')][1]")
	WebElement breakEndBtn;
	
	@FindBy(xpath = "//input[@id='code']")
	WebElement codeUnitField;
	
	@FindBy(xpath = "//button[normalize-space()='Batal']")
	WebElement cancelBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Tambah']")
	WebElement addConfirmBtn;
	
	@FindBy(xpath = "//button[normalize-space()='Simpan']")
	WebElement editConfirmBtn;
	
	@FindBy(xpath = "//div[@role='dialog']")
	WebElement dialogContainer;
	
	@FindBy(xpath = "//tbody/tr/td[1]/h6")
	List<WebElement> listShiftName;
	
	@FindBy(xpath = "//p[@id='name-helper-text']")
	WebElement messageMandatoryName;
	
	@FindBy(xpath = "//p[contains(@id,'helper-text')]")
	List<WebElement> messageMandatoryList;
	
	By timeDialog = By.xpath("//div[contains(@class,'MuiCalendarOrClockPicker-root')]");
	
	
	public void setSearch(String search) {
		searchField.sendKeys(search);
	}
	
	public void clickReset() {
		resetBtn.click();
	}
	
	public void clickSearch() {
		searchBtn.click();
	}
	
	public void clickAdd() {
		addBtn.click();
	}
	
	public void clickEdit() {
		editFirstBtn.click();
	}
	
	public void clickDropdownTotalRows() {
		rowsPerPageBtn.click();
	}
	
	public void selectVal25TotalRows() {
		dropdown25Btn.click();
	}
	
	public void clickNext() {
		nextBtn.click();
	}
	
	public void clicklast() {
		lastBtn.click();
	}
	public WebElement getElementlast() {
		return lastBtn;
	}
	
	public void clickPrevious() {
		previousBtn.click();
	}
	
	public void clickFirst() {
		firstBtn.click();
	}
	
	public WebElement getElementFirst() {
		return firstBtn;
	}
	
	public void openDeleteDialog() {
		deleteFirstBtn.click();
	}
	
	
	public void clickActionFirst() {
		actionFirstBtn.click();
	}
	
	public void cancelDelete() {
		cancelDeleteBtn.click();
	}
	
	public void confirmDelete() {
		clickJs(confirmDeleteBtn);
	}
	
	public String getSnackbarMessage() {
		return snackBarMessage.getText();
	}
	public WebElement getSnackbarMessageElement() {
		return snackBarMessage;
	}
	public By getSnackbarMessageLocator() {
		return snackBarMessageLocator;
	}
	
	public void setName(String name) {
		nameShiftField.sendKeys(name);
	}
	public WebElement getElementName() {
		return nameShiftField;
	}
	
	public void clickUnit() {
		clickJs(openUnit);
	}
	
	public void clickThirdUnitOption() {
		unitThirdOption.click();
	}
	
	public void clickShowTimeIn() {
		timeInShow.click();
	}
	
	public void clickShowTimeOut() {
		timeOutShow.click();
	}
	
	public void clickBreakStart() {
		breakStartBtn.click();
	}
	
	public void clickBreakEnd() {
		breakEndBtn.click();
	}
	
	public void chooseTime(String timeChoose) {

		WebElement thickEl = driver.findElement(By.xpath("//div[contains(@class,'MuiClock-pin')]"));
	    WebElement chooseTime = driver.findElement(By.xpath("//div[contains(@class, 'MuiClockPicker-root')]//span[text()='"+timeChoose+"']"));
	    
	    Actions acs = new Actions(driver);
	    acs.clickAndHold(thickEl) 
	       .moveToElement(chooseTime) 
	       .release() 
	       .build() 
	       .perform(); 
	}
	
	public void setCodeUnit(String codeUnit) {
		codeUnitField.sendKeys(codeUnit);
	}
	public WebElement getCodeUnit() {
		return codeUnitField;
	}
	
	public void clickConfirmAdd() {
		addConfirmBtn.click();
	}
	
	public void editConfirmButton() {
		editConfirmBtn.click();
	}
	
	
	public void clickCancel() {
		cancelBtn.click();
	}
	
	int getSizeData() {
		return rowData.size();
	}
	
	public int shiftNameSize() {
		return listShiftName.size();
	}
	
	public List<WebElement> datasFirstColumn(){
		return firstColumnDatas;
	}
	public List<WebElement> datasCodeColumn(){
		return codeColumnDatas;
	}
	
	public WebElement getMessageMandatoryName() {
		return messageMandatoryName;
	}
	
	public By getLocatorTimeDialog() {
		return timeDialog;
	}
	
	public String getPageDisplay() {
		return pageDisplay.getText();
	}
	
	public List<WebElement> getMessageMandatoryList(){
		return messageMandatoryList;
	}
	
	public void clearName(int length) {
		clearUsingKeyboard(nameShiftField,length);
		
	}
	public void clearCode(int length) {
		clearUsingKeyboard(codeUnitField, length);

	}

}
