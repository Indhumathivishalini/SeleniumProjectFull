package methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switchboard {
public static void main(String args[]) {
		
	System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
		
	String URL = "http://alpha-sb.appspot.com/InitialAccountAction/getAccountInfo.do?accountNumber=0001211294";
	
    String emailID = "indhumathi.rajavel@anywhere.co";
	}

}
