package selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick {

	public static void main (String args[]) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe" );
		WebDriver driver = new ChromeDriver();
		driver.get("http://artoftesting.com/sampleSiteForSelenium.html");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.xpath("//button[@id='dblClkBtn']"));
		
		
		Actions builder = new Actions(driver);
		builder.doubleClick(element).build().perform();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
}
