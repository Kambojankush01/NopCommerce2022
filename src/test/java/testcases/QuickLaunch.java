package testcases;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.PIMpage;
import testbase.TestBase;
import utilities.TestUtilities;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class QuickLaunch {
	private WebDriver driver;
	private LoginPage lp;
	private PIMpage pm;
	
  @Test(description = "Quick Launch 003", enabled = true,priority=3)
  public void VerifyQuickLaunchItems_003() {
	  List<String> actual = pm.getQuickLaunchItems();
	  List<String> exp = new ArrayList<String>();
	  exp.add("Admin");
	  exp.add("PIM");
	  exp.add("Leave");
	  exp.add("Time");
	  exp.add("Recruitment");
	  exp.add("My Info");
	  exp.add("Performance");
	  exp.add("Dashboard");
	  exp.add("Directory");
	  exp.add("Maintenance");
	  exp.add("Buzz");
	  TestUtilities.addScreenshot();
	  Assert.assertEquals(exp,actual);
	  
  }
  @Test(description = "Quick Launch 002", enabled = true,priority=2)
  public void VerifyQuickLaunchItemCount_002() {
	  int actual = pm.getQuickLaunchItemCount();
	  TestUtilities.addScreenshot();
	  Assert.assertEquals(actual,11);
	  
  }
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  driver = TestBase.getInstance();
	  lp = new LoginPage(driver);
	  pm = new PIMpage(driver);
	  lp.loginToApplication("Admin","admin123");
	  
  }

  @AfterMethod
  public void afterMethod() {
	  pm.logout();
	  driver.quit();
  }

}
