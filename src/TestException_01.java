import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestException_01 {

	public static void main(String[] args) {
		// invoke browser
		WebDriver driver = new  ChromeDriver();
		driver.get("https://practicetestautomation.com/");
		
		
		// Tambahkan timeout handle untuk menghindari error ketika element belum muncul
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement pagePractic = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Practice")));
		pagePractic.click();
	}
}
