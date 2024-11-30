package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class DashBoardPage {
	WebDriver driver;
	GeneralUtility generalutility= new GeneralUtility();
	@FindBy(xpath = "//a[@class='d-block']")
	private WebElement profileName;
	@FindBy(xpath = "//h3//following-sibling::p")
	List<WebElement> allDashboardItems;
	@FindBy(xpath = "//p[text()='Admin Users']/../../div/following-sibling::a")
	private WebElement adminUserMoreInfoButton;
	@FindBy(xpath="//li[contains(text(),'Dashboard')]")
	WebElement dashName;

	public DashBoardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getProfilrName() {
		return profileName.getText();
	}
	public List<String>allItems () {
		List<String> actualItemNames = new ArrayList<String>();
		actualItemNames = generalutility.getTextOfElements(allDashboardItems);
		System.out.println(actualItemNames);

		return actualItemNames;

	}
public void adminUserMoreInfoClick()
{
	adminUserMoreInfoButton.click();
}
public String dashNamebutton()
{
	return dashName.getText();
	
}
}
