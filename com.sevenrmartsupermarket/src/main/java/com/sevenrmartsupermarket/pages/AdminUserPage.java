package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.PageUtility;



public class AdminUserPage {
	WebDriver driver;
	PageUtility pageutility;
	@FindBy(xpath = "//h1[@class='m-0 text-dark']")
	WebElement AdminUserTitle;
	@FindBy(xpath = "//a[@onclick='click_button(1)']")
	WebElement newUserButton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement newUserName;
	@FindBy(xpath = "//input[@id='password']")
	WebElement newUserPassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement userType;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement save;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")
	WebElement searchUser;
	@FindBy(xpath="//input[@id='un']")
	WebElement searchUserName;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger']")
	WebElement searchButton;
	@FindBy(xpath="//span[text()='Active']")
	WebElement status;
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	public AdminUserPage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver,this);
		pageutility=new PageUtility(driver);
	}
	public String getAdminUserTitle()
	{
		return AdminUserTitle.getText();
	}
	public void createNewUser()
	{
		newUserButton.click();
	}
	public void enterNewUserName(String newName) {
		newUserName.sendKeys(newName);
	}

	public void enterNewPassword(String newPassword) {
		newUserPassword.sendKeys(newPassword);
	}

	public void enterUserDetails(String uname, String password) {
		enterNewUserName(uname);
		enterNewPassword(password);
	}

	public AdminUserPage selectUserType() {

		pageutility.selectDropDownByIndex(userType, 3);
		return this;
	}

	public void clickSaveButton() {
		save.click();

	}
	public void searchUserButton()
	{
		searchUser.click();	
	}
	public void serachEnterUserName(String uname)
	{
		searchUserName.sendKeys(uname);	
	}
	public void searchUser() {
		searchButton.click();
	}
	public String statusUser() {
		return status.getText();
		
	}
	public void homeButton()
	{
		home.click();
	}
		
	}

	

	

