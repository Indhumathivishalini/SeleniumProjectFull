package selenium;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowHandling{
	public static void main(String args[]) throws InterruptedException, AWTException {
		 
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// create instance for chromediver

		WebDriver driver = new ChromeDriver();
		Robot robot = new Robot();
		WebDriverWait wait = new WebDriverWait(driver,10);
		// implicitly wait for each element to load in a page
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();

		// loads the url
		driver.get("http://alpha-sb.appspot.com/InitialAccountAction/getAccountInfo.do?accountNumber=0001211294");
		// sign in 
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("indhumathi.rajavel@anywhere.co");
		driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("Indhu@123");
		driver.findElement(By.xpath("//button[@id='login-btn']")).click();

		String text = driver.findElement(By.xpath("//div[@class='greeting']/h3")).getText();
		System.out.println(text);

		// click on close button
		driver.findElement(By.xpath("//div[@class='greeting']/i")).click();
		
		String window1 = driver.getTitle();
		System.out.println(window1);
		System.out.println("************");

		//click on message history
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='Details-Tab-Content']//a[contains(text(),'MESSAGE')]")).click();

		// click on message 
		driver.findElement(By.xpath("//li[@class='msg-icon ']/label[1]")).click();
		System.out.println(driver.getWindowHandle());
		
		// click on copy link option

		driver.findElement(By.xpath("//i[@class='dropdown-toggle']/b")).click();

		driver.findElement(By.xpath("//li[@id='copyEmailViewLink']")).click();
        

		// copy the link
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		ArrayList<String> listofwin = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(listofwin.size());
		
		driver.switchTo().window(listofwin.get(1));
		System.out.println(driver.getWindowHandle());
		driver.navigate().refresh();
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		WebElement untilElementLoad = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@src='http://images.sb.a-cti.com/images/smile.png']")));
		untilElementLoad.click();
		
		
		String title = driver.getTitle();
		System.out.println(title);
		String window2 = driver.getCurrentUrl();
		System.out.println(window2);	
		System.out.println(driver.getWindowHandle());
		System.out.println("************");
		
		ArrayList<String> listofwin1 = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(listofwin1.get(2));
		String title2 = driver.getTitle();
		System.out.println(title2);
		String window3 = driver.getCurrentUrl();
		System.out.println(window3);
		System.out.println(listofwin1.size());
		driver.close();
		
		driver.switchTo().window(listofwin1.get(0));
	
		
	 //  driver.quit();

	}	
}
