package Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DragandDrop {

	
	static WebDriver driver;
	String url = "https://jqueryui.com/droppable/";
	//String url="https://www.google.com/";
	@BeforeClass
	public  void Base() throws InterruptedException
	{
		 System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		 
		 driver =new ChromeDriver();
		
		 driver.get(url);
		 driver.manage().window().maximize();
		 driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	//@AfterClass
	public void Close()
	{
		driver.close();
	}
	
	@Test
	public void test1() throws InterruptedException
	{
		
		//driver.findElement(By.linkText("About")).click();
		
	     System.out.println(driver.findElement(By.xpath("//*[@id=\"droppable\"]/p")).getText());
		// WebElement drag=driver.findElement(By.xpath("div//[@id='draggable' and @class='ui-widget-header ui-droppable']"));
	     WebElement drag=driver.findElement(By.id("draggable"));
		 WebElement drop=driver.findElement(By.id("droppable"));
		 
		 Actions action1=new Actions(driver);
		 Thread.sleep(2000);
		 action1.dragAndDrop(drag, drop).build().perform();
		 Thread.sleep(2000);
		 
		 
}
}
