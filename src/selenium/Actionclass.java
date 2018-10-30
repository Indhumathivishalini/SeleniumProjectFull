package selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actionclass {

	public static void main (String args[]) throws InterruptedException, AWTException {


		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver ;
		driver = new ChromeDriver(options);
		WebDriverWait wait = new WebDriverWait(driver,10);


		driver.get("https://formcreator.full.io/index.jsp?playGroundAccountNumber=0001211294");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//input[@class='input-default']")).sendKeys("indhumathi.rajavel@anywhere.co");
		driver.findElement(By.xpath("//input[@class='input-default input-pwd']")).sendKeys("Indhu@123");

		driver.findElement(By.xpath("//span[@class='show-pwd']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-blue login-btn']")).click();
		driver.navigate().refresh();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='right_content']/button[1]"))).click();



		// 1

		//Alert alert = driver.switchTo().alert().accept();
		//alert.dismiss();*/
		/*Actions builder = new Actions(driver);


		builder.sendKeys(Keys.ESCAPE).perform();*/


		//ChromeDriver driver1 = new ChromeDriver(options);

		// 2 
		/*
		Alert alert1 = wait.until(ExpectedConditions.alertIsPresent());
		String alertmsg = alert1.getText();
		System.out.println(alertmsg);
		alert1.accept();*/

		// open new form

		Robot robot = new Robot();
	//	Actions action = new Actions(driver);
		
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='formList_tab']/em"))).click();


		//WebElement on which drag and drop operation needs to be performed
	//	WebElement fromWebElement = driver.findElement(By.xpath("//li[@id='fullName_pannel']"));

		//WebElement to which the above object is dropped
	//	WebElement toWebElement = driver.findElement(By.xpath("//div[@id='formcontent']/ul"));
	//	Point axis = toWebElement.getLocation();
		/*int x = axis.getX(); 
		int y = axis.getY();
		System.out.println("x axis" + x);
		System.out.println("y axis" + y);*/
		
		// action.moveToElement(toWebElement).click().build().perform();
//		 robot.mouseMove(toWebElement.getLocation().getX(), toWebElement.getLocation().getY());
 
  robot.mouseMove(220, 330);
  robot.mousePress(InputEvent.BUTTON1_MASK);
  robot.mouseMove(700, 300);
  robot.mouseRelease(InputEvent.BUTTON1_MASK);
		
		//Building a drag and drop action
		//Action dragAndDrop = builder.clickAndHold(fromWebElement).moveToElement(toWebElement).release(toWebElement).build();
		// builder.dragAndDrop(fromWebElement, toWebElement).build().perform();
		
		//action.dragAndDropBy(fromWebElement,431,167).build().perform();
		

		//Performing the drag and drop action
		//dragAndDrop.perform();

		//driver.close();










	}
}
