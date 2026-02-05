import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TestInvalidPassword {
	public static void main(String[] args) {
		
		// Invoke Browser 
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("wornPass");
		driver.findElement(By.id("submit")).click();
		
		
		// Set timeout agar program tidak langsung error saat menunggu notif
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// ambil oesan erro yang ditamppilkan 
		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));
		
		// tampung pean error untuk diprint
		String errorNotif = errorMsg.getText();
		System.out.println(errorNotif);
	}
}
