package selenium;





import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailSignin {
	
	public static void main (String args[]) throws InterruptedException  {
		
		// set the driver path
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		
		// driver object is created
		WebDriver driver = new ChromeDriver();
	
		
		WebDriverWait dynamicelement = new WebDriverWait(driver,10);
		
		// implicitly wait for each element to load in a page
		//driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		// launch browser and loads the URL
		driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");
	
	    // get the title of the page
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		
		// enter email address
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("indhumathi.rajavel@anywhere.co");
		
		//click on next
		driver.findElement(By.xpath("//span[text()='Next']")).click(); 
		
		//enter the password
		dynamicelement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("Indhu@123");
		//driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Indhu@123");
		
		
		WebElement nextuntil = dynamicelement.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//span[@class='RveJvd snByac']"))));
		nextuntil.click();

		//click on next
		//driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
		
		dynamicelement.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='gb_9a gbii']"))).click();
		//click on Gmail account icon
		//driver.findElement(By.xpath("//span[@class='gb_9a gbii']")).click();
		
		// click on signout button
		WebElement signout = driver.findElement(By.linkText("Sign out"));
		signout.click();
		System.out.println("logged out");
		
		// close the browser window
		driver.close();
	
	}

}
