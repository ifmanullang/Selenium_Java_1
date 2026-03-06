package UdemySelenium;

import java.time.Duration;

import javax.print.attribute.standard.JobHoldUntil;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Introduction {
	public static void main(String[] args) throws InterruptedException {
	
		// Pilih browser yang akan digunakan untuk melakukan testing
		ChromeDriverService service = new ChromeDriverService.Builder().build();
		// invoke browser
		WebDriver driver = new ChromeDriver(service);
		
		/*
		Gunaka implicit wait untuk melakukan manage time secara global pada halaman web yang sedang diuji 
		Implicit wait hanya handle masalah / melakukan cek pada DOM 
		Implicit wait hanya tunggu sampai:
		- Melakukan cek Element ADA di DOM (HTML)
		- Tidak cek apakah element VISIBLE
		- Tidak cek apakah element CLICKABLE
		- Tidak cek apakah ada overlay di atasnya
		*/
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.xpath("//input[@placeholder='Username' and @id='inputUsername']")).sendKeys("zackk");
		driver.findElement(By.xpath("//input[@placeholder='Password' and @name='inputPassword']")).sendKeys("Passw0rd123");
		driver.findElement(By.xpath("//button[@class='submit signInBtn' and normalize-space()='Sign In']")).click();
		
		// tammpilkan notig gagal melakukan login
		System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());
		
		// masuk ke forgot password untuk reset password
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		// Gunakan thread untuk melakukan delay saat proses perpindahan agar button terlihat dan dapat diclick
		// handle button overly (tersembunyi dalam div) diutmakan gunakan explicit wait daripada thread. 
		// karena pada thread tidak stabil dan tidak tahu kondisi apakah button sudah terlihat hanya melakukan delay saat perpindahan
		// pada kasus ini tidak dapat menggunakan implicit wait dan explicit wait secara bersamaan 
		
		Thread.sleep(1000);
		
		// isi data utnuk lakukan reset password
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Juann");
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Jhon@email.com");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
		driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Jhn@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("0813001112244");
		
		
		// tekan tombol reset dan ambil pesan dari pop up
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		
		// tampilkan notif
		System.out.println(driver.findElement(By.xpath("//p[@class='infoMsg']")).getText());
		
		// kembali kehalaman login 
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		// saat berpindah kembali membutuhkan waktu delay agar dapat ambil element 
		Thread.sleep(1000);
		// isi kembali data denga data yang benar agar berhasil login 
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class, 'submit')]")).click();
		
	}
}
