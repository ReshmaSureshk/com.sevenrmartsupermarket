package com.sevenrmartsupermarket.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUserPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class AdminUserTest extends Base {

	LoginPage loginpage;
	DashBoardPage dashboardpage;
	AdminUserPage adminuserpage;
	GeneralUtility generalutility;
	
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
	@Test
	public void deleteuser()
	{
		loginpage=new LoginPage(driver);
		dashboardpage=loginpage.login("admin", "admin");
		dashboardpage.adminUserMoreInfoClick();
		adminuserpage=new AdminUserPage(driver);
		adminuserpage.createNewUser();
		adminuserpage.enterUserDetails("re","kiara");
		adminuserpage.selectUserType().clickSaveButton();
		adminuserpage.searchUserButton();
		adminuserpage.serachEnterUserName("re");
		adminuserpage.searchUser();
		adminuserpage.userDeleteButton();
		driver.switchTo().alert().accept();
		String expectedUserDeleteAlert=adminuserpage.userDeleteSuccess();
		String actualUserDeleteAlert="Alert!User Deleted Successfully";
		Assert.assertEquals(actualUserDeleteAlert, expectedUserDeleteAlert);	
	
		
		
	}
	
				
	}

