package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class AdminUserTest extends Base {

	LoginPage loginpage;
	DashBoardPage dashboardpage;
	AdminUserPage adminuserpage;
	
	@Test(groups="regression")
	public void verifyNewUser()
	{
		loginpage=new LoginPage(driver);
		dashboardpage=loginpage.login("admin", "admin");
		dashboardpage.adminUserMoreInfoClick();
		adminuserpage=new AdminUserPage(driver);
		adminuserpage.createNewUser();
		adminuserpage.enterUserDetails("KIKI","kiara");
		adminuserpage.selectUserType().clickSaveButton();
	}
	@Test
	public void verifySearchUser()
	{
		loginpage=new LoginPage(driver);
		dashboardpage=loginpage.login("admin", "admin");
		dashboardpage.adminUserMoreInfoClick();
		adminuserpage=new AdminUserPage(driver);
		adminuserpage.createNewUser();
		adminuserpage.enterUserDetails("ReshmaSuresh","kiara");
		adminuserpage.selectUserType().clickSaveButton();
		adminuserpage.searchUserButton();
		adminuserpage.serachEnterUserName("ReshmaSuresh");
		adminuserpage.searchUser();
		String actualStatus = adminuserpage.statusUser();
		String expectedStatus="Active";
		Assert.assertEquals(actualStatus, expectedStatus);
		}
				
	}

