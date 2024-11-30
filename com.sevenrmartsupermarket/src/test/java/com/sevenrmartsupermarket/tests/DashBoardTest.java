package com.sevenrmartsupermarket.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class DashBoardTest extends Base {

	DashBoardPage dashboardpage;
	LoginPage loginpage;
	AdminUserPage adminuserpage;

	@Test(groups="regression")
	public void verifyAllCategory() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		List<String> actualItemsNames = dashboardpage.allItems();
		List<String> expectedItemNames = new ArrayList<>();
		expectedItemNames.add("Admin Users");
		expectedItemNames.add("Dashboard");
		expectedItemNames.add("Category");
		expectedItemNames.add("Sub Category");
		expectedItemNames.add("Manage Contact");
		expectedItemNames.add("Manage Gift cards &vouchers");
		expectedItemNames.add("Test name");
		expectedItemNames.add("Manage Product");
		expectedItemNames.add("Manage News");
		expectedItemNames.add("Manage Footer Text");
		expectedItemNames.add("Manage Category");
		Assert.assertEquals(actualItemsNames, expectedItemNames);

	}

	@Test
	public void verifyAdminUserInfoClick() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		adminuserpage=new AdminUserPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage.adminUserMoreInfoClick();
		
}
	@Test
	public void verifyAdminHome() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		adminuserpage=new AdminUserPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage.adminUserMoreInfoClick();
		adminuserpage.homeButton();
		String expectedDashName= dashboardpage.dashNamebutton();
		String actualDashName="Dashboard";
		Assert.assertEquals(actualDashName, expectedDashName);
				
	}
	
}
