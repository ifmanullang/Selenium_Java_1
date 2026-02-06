import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestLogOut {

	public static void main(String[] args) {
		
		// invoke browser
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
		
		// Buat timeout untuk management error
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Buat penampung untuk memngambil nilai dari notif berhasil login
		WebElement successLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='post-title']")));
		
		// tampilkan pesan berhasil login
		String successMsg = successLogin.getText();
		System.out.println(successMsg);
		

		
		// Setelah berhasik login maka clik logout untuk kemabali kehalaman awal 
		WebElement logOut = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log out")));
		
		logOut.click();  
		
		 // Verifikasi logout (opsional: tunggu kembali ke login page)
        wait.until(ExpectedConditions.titleContains("Test Login"));
        System.out.println("Logout berhasil - kembali ke halaman login.");

        // Tutup browser
        driver.quit();
		
		
	}
}
