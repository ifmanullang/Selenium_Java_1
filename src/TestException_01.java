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
		
		WebElement pagePractic = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='menu-item-20']//a[contains(text(),'Practice')]")));
		pagePractic.click();
		
		WebElement getTes = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Test Exception')]")));
		getTes.click();
		
		driver.findElement(By.id("add_btn")).click();
		
		// ambil notif berhasil menambahkan rows dua 
		WebElement successAddRow2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation")));
		
		// tampilkamn notif
		String row2Msg = successAddRow2.getText();
		System.out.println(row2Msg);
		
	}
}
