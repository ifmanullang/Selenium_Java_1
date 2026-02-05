import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestInvalidUsername {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Invoke Browser
		WebDriver driver = new ChromeDriver();
		// Baut manage timeout agar jika dalam program memerlukan waktu beberapa detik program tidak menjadii error tetapi menunggu  terlebih dahulu 
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.id("username")).sendKeys("BadName");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		
		
        // TUNGGU sampai elemen error terlihat, baru ambil teksnya
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// mengambil pesan error saat gagal login 	
		WebElement errorMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        // Simpan ke string dan print
		String pesanError = errorMsg.getText();
		System.out.println(pesanError);
		
	}

}
