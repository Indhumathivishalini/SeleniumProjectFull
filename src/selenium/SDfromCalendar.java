package selenium;

import java.awt.AWTException;



import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;


public class SDfromCalendar {
	public static void main(String args[]) throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

		// create instance for chromediver

		WebDriver driver = new ChromeDriver();
	//	Robot robot = new Robot();
	//	WebDriverWait wait = new WebDriverWait(driver,10);
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

		//click on message history
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='Details-Tab-Content']//a[contains(text(),'MESSAGE')]")).click();

		driver.findElement(By.xpath("//button[@class='date-pick fa fa-calendar']")).click();
		
	/*WebElement tablebody = driver.findElement(By.xpath("(//div[@class='datepicker-days'])[2]/table/tbody"));
		
		 List<WebElement> datalist = tablebody.findElements(By.tagName("td"));
	*/
		String todaydate = new SimpleDateFormat("MM/dd/yyyy").format(SDfromCalendar.getInstance().getTime());
		System.out.println(todaydate);
		
		driver.findElement(By.xpath("//input[@class='from-date']")).sendKeys("10/01/2018");
		driver.findElement(By.xpath("//input[@class='to-date']")).sendKeys(todaydate);
		
		driver.findElement(By.xpath("//button[@class='date-go']")).click();
	
	}

	private static Calendar getInstance() {
		// TODO Auto-generated method stub
		return null;
	}

}
