package Aspirepac;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;







import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class NewTest {
	
	public WebDriver driver;

	
	@Test(priority=0)
	  public void launch() {
		  System.setProperty("webdriver.chrome.driver", "E:\\SAspire\\chromedriver.exe");
	      driver=new ChromeDriver();
	     driver.get("https://aspireapp.odoo.com/web/login");
	     WebDriverWait w=new WebDriverWait(driver,30);
	     w.until(ExpectedConditions.visibilityOfElementLocated(By.name("login")));
	     String expectedTitle="Odoo";
	     String actualTitle=driver.getTitle();
	     Assert.assertEquals(actualTitle, expectedTitle);
	  }
	
	@Test(priority=1)
	public void validateTitle() throws IOException
	{
		//String expectedTitle="Odoo";
	String pagetitle=driver.getTitle();
	
	if(pagetitle.contains("Odoo"))
	{
		Assert.assertTrue(true, "title test was passed");
	}
	else
	{
	File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    File dest=new File("\ss1.png");
    FileUtils.copyFile(src,dest);
    Reporter.log("\ss1.png");
    Assert.assertTrue(false,"title test was failed");
    
	}
	}
	@Test(dependsOnMethods= {"validateTitle"})
	@Parameters({"userName","password"})
	public void login(String x, String y) throws Exception
	{
		driver.findElement(By.cssSelector("input[id=login]")).sendKeys(x);
		driver.findElement(By.cssSelector("input[id=password]")).sendKeys(y);
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-block")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class=\"oe_topbar_name\"]")).isDisplayed();
		if(driver.findElement(By.xpath("//span[@class=\"oe_topbar_name\"]")).isDisplayed())
		{
			 System.out.println("element is displayed");
		}
		else
		{
			 System.out.println("element is not displayed");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    File dest=new File("\ss2.png");
	    FileUtils.copyFile(src,dest);
	    Reporter.log("\ss2.png");
//	    Assert.assertTrue(false,"user test was failed");
	    
		}
		}

	
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.out.println("Starting the browser session");
  }

  @AfterMethod 
  public void afterMethod() {

	  System.out.println("method has been run");
//      driver.quit();	  
  }
  
  @AfterClass
  public void afterClass() {

	  System.out.println("Closing the browser session");
      driver.quit();	  
  }


}