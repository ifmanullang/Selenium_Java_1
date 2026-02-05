import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestCorrectLogin {

	public static void main(String[] args) {
		
		// Invoke Browser
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
		
		// Set Timeout agar tidak error saat progma menunggu notif / Tunggu samapai notif muncul dengan set time 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// tampung notif dalam variable yang akan di printout
		WebElement successLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='post-title']")));
		
		// mengambil text
		String successMsg = successLogin.getText();
		System.out.println(successMsg);
		
	}
}
