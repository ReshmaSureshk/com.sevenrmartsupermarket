package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.ScreenshotCapture;

public class LoginTest extends Base {
	LoginPage loginpage;
	DashBoardPage dashBoardPage;
	ExcelReader excelreader = new ExcelReader();
	//ScreenshotCapture screenshotcapture =new ScreenshotCapture();
	@Test (groups={"smoke","regression"})
	public void verifyAdminUserLogin() {
		
		dashBoardPage = new DashBoardPage(driver);
		excelreader.setExcelFile("LoginDetails","LoginCredentials" );
		String userName=excelreader.getCellData(0, 1);
		String UserNamePassword=excelreader.getCellData(1,1);	
		System.out.println(userName);
		System.out.println(UserNamePassword);
		loginpage = new LoginPage(driver);
		loginpage.login("admin", "admin");
		System.out.println(GeneralUtility.getRandomName());
		System.out.println(GeneralUtility.getRandomAddress());
		String actualProfileName = dashBoardPage.getProfilrName();
		String expectedProfileName = "Admin";
		//screenshotcapture.takescreenshot(driver,"reshma");
		Assert.assertEquals(actualProfileName, expectedProfileName);
		
	}
}
