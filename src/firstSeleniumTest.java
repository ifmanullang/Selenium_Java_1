import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class firstSeleniumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Invoking Browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		System.out.println( driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}

}
