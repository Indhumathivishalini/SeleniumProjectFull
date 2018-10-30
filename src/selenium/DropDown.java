package selenium;

import java.awt.AWTException;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DropDown {
	public static void main (String args[]) throws AWTException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// create instance for chromediver

		WebDriver driver = new ChromeDriver();
	//	Robot robot = new Robot();
		WebDriverWait wait = new WebDriverWait(driver,20);
		// implicitly wait for each element to load in a page
		//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
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

		//click on message history
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='Details-Tab-Content']//a[contains(text(),'MESSAGE')]")).click();

		// click on message 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='msg-icon ']/label[1]"))).click();
		
		//click on resend button
		driver.findElement(By.xpath("//i[@class='fa fa-paper-plane-o']")).click();
		
	// click on delivery method
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Choose Delivery Method ']"))).click();
	// choose delivery method
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='sample'])[2]"))).click();
	// click on send 	
	   driver.findElement(By.xpath("//button[@class='send']")).click();
	   System.out.println("Mail has been Resended");
	   driver.close();
	    
	
	}

}
