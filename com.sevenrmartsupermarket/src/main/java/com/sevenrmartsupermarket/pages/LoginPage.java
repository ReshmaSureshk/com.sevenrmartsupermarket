package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passwordField;
	@FindBy(xpath = "//button[contains(text(),'Sign')]")
	private WebElement submitField;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		try {
			FileInputStream ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
			properties.load(ip);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickOnSignInBtn() {
		submitField.click();
	}
	public DashBoardPage login(String UserName,String password)
	{
		enterUserName(UserName);
		enterPassword(password);
		clickOnSignInBtn();
		return new DashBoardPage(driver);
	}
	
	public DashBoardPage login()
	{
		String userName=properties.getProperty("username");
		String password =properties.getProperty("password");
		enterUserName(userName);
		enterPassword(password);
		clickOnSignInBtn();
		return new DashBoardPage(driver);
	}

}
