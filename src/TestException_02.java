import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestException_02 {

	public static void main(String[] args) {
		// Invoke Browser
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://practicetestautomation.com/");
		
		// Manage timeout agar saat proses memumgggu halaman tidak terjadi error
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement testException = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='menu-item-20']//a[contains(text(),'Practice')]")));
		testException.click();
		
		WebElement getTestException = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Test Exception')]")));
		getTestException.click();
		
		driver.findElement(By.id("add_btn")).click();
		
		// tampilkan notif berhsil munculkan rows dua
		WebElement successAddRow2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("confirmation")));
		
		// tampilkan notif
		String row2Msg =  successAddRow2.getText();
		System.out.println(row2Msg);
		
		// input niai pada row 2
		driver.findElement(By.xpath("//div[@id='row2']//input[@type=''text]")).sendKeys("Nasi Goreng");
	}
}
