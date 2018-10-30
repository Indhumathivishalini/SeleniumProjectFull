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

public class DragAndDrop {


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

		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@id='formList_tab']/em"))).click();


		//Actions action = new Actions(driver);

		/*WebElement sourceElement = driver.findElement(By.xpath("//li[@id='fullName_pannel']"));
		Action drag = action.clickAndHold(sourceElement).build();
		drag.perform();

		WebElement targetElement = driver.findElement(By.xpath("//div[@id='formcontent']/ul"));
		Point coordinates = targetElement.getLocation();
		Robot robot = new Robot(); //Robot for controlling mouse actions
		robot.mouseMove(coordinates.getX(),coordinates.getY());
		Thread.sleep(5000);*/

		/*WebElement fromWebElement = driver.findElement(By.xpath("//li[@id='fullName_pannel']"));

		WebElement toWebElement = driver.findElement(By.xpath("//div[@id='formcontent']/ul"));

		Point coordinates1 = fromWebElement.getLocation();
		Point coordinates2 = toWebElement.getLocation();

		Robot robot = new Robot();

		robot.mouseMove(coordinates1.getX(), coordinates1.getY());
		robot.mousePress(InputEvent.BUTTON1_MASK);
		robot.mouseMove(coordinates2.getX(), coordinates2.getY());
		robot.mouseRelease(InputEvent.BUTTON1_MASK);
		Thread.sleep(2000);*/
		//    WebElement fromWebElement = driver.findElement(By.xpath("//li[@id='fullName_pannel']"));

		//	WebElement toWebElement = driver.findElement(By.xpath("//div[@id='formcontent']/ul"));
		Robot robot = new Robot();

		//The element I want to drag and move
		robot.mouseMove(220,330);    
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

		// middle point
		Thread.sleep(2000);
		robot.mouseMove(500,300);
		Thread.sleep(2000);

		// the new location I want to move the element to  
		robot.mouseMove(730,320);  
		Thread.sleep(2000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);  

		Thread.sleep(2000);
		// source
		robot.mouseMove(150,380);
		Thread.sleep(2000);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);


		// middle point
		
		robot.mouseMove(700,680);
		Thread.sleep(2000);

		//destination
		robot.mouseMove(730,400);
		Thread.sleep(2000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

     driver.findElement(By.xpath("//div[@id='save_button']")).click();
     driver.findElement(By.xpath("//button[@class='yes btnHighlight']")).click();
  
     // publish button
     //   driver.findElement(By.xpath("(//div[@class='btn_cst'])[5]")).click();
	}
}















