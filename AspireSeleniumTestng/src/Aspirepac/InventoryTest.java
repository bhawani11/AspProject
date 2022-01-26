package Aspirepac;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class InventoryTest {
	public WebDriver driver;
  
	NewTest newTest=new NewTest();
	
  @BeforeMethod
  public void setUp() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "E:\\SAspire\\chromedriver.exe");
      driver=new ChromeDriver();
      
      driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.get("https://aspireapp.odoo.com/web/login");
      login("user@aspireapp.com","@sp1r3app");
      
  }
   
  @Test(priority=1)
  public void clickAndVerifyInventoryPage() {
    driver.findElement(By.xpath("//div[@class=\"o_apps\"]/child::*[2]")).click();
    boolean flag=driver.findElement(By.xpath("//span[text()='Receipts']")).isDisplayed();
    Assert.assertTrue(flag);
  }
  
  @Test(priority=2)
  public void verifyProduct() {
	  driver.findElement(By.xpath("//div[@class=\"o_apps\"]/child::*[2]")).click();
	  driver.findElement(By.xpath("//span[text()='Receipts']")).isDisplayed();
	  driver.findElement(By.partialLinkText("Products")).click();
	  driver.findElement(By.xpath("//a//span[text()='Products']")).isDisplayed();
	  driver.findElement(By.xpath("//a//span[text()='Products']")).click();
	  driver.findElement(By.cssSelector("button.btn.btn-primary.o-kanban-button-new")).isDisplayed();
      driver.findElement(By.cssSelector("button.btn.btn-primary.o-kanban-button-new")).click();
      driver.findElement(By.xpath("//input[@placeholder=\"Product Name\"]")).sendKeys("GoldLoan");
      }
  

  @Test(priority=3)
  public void verifyUpdateValue() {
	  driver.findElement(By.xpath("//div[@class=\"o_apps\"]/child::*[2]")).click();
	  driver.findElement(By.xpath("//span[text()='Receipts']")).isDisplayed();
	  driver.findElement(By.partialLinkText("Products")).click();
	  driver.findElement(By.xpath("//a//span[text()='Products']")).isDisplayed();
	  driver.findElement(By.xpath("//a//span[text()='Products']")).click();
	  driver.findElement(By.cssSelector("button.btn.btn-primary.o-kanban-button-new")).isDisplayed();
      driver.findElement(By.cssSelector("button.btn.btn-primary.o-kanban-button-new")).click();
      driver.findElement(By.xpath("//input[@placeholder=\"Product Name\"]")).sendKeys("GoldLoan");
      driver.findElement(By.cssSelector("button.btn.btn-primary.o_form_button_save")).click();
	  boolean flag1=driver.findElement(By.xpath("//*[contains(text(),'Update Quantity')]")).isDisplayed();
      Assert.assertTrue(flag1);
      driver.findElement(By.xpath("//*[contains(text(),'Update Quantity')]")).click();
      driver.findElement(By.cssSelector("button.btn.btn-primary.o_list_button_add")).click();
      
      webElement e=driver.findElement(By.xpath("(//input[@class=\"o_input ui-autocomplete-input\"])[1]")).click();
            Select s=new Select(e)
  }
  
  public void login(String x, String y) throws Exception
	{
		driver.findElement(By.cssSelector("input[id=login]")).sendKeys(x);
		driver.findElement(By.cssSelector("input[id=password]")).sendKeys(y);
		driver.findElement(By.cssSelector("button.btn.btn-primary.btn-block")).click();
		driver.findElement(By.xpath("//span[@class=\"oe_topbar_name\"]")).isDisplayed();

}
  @AfterMethod
  public void afterMethod() {

	  System.out.println("Browser is closing");
      driver.quit();	  
  }	
  
  
}
