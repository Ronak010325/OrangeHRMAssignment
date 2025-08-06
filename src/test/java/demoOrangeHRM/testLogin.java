package demoOrangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class testLogin {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		
//		Opening the OrangeHRM Website on Chrome browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//		Entering Valid Username and password ("Admin", "admin123")
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		
//		Clicking on Login Button
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
		
//		Getting the Current URL after login to validate it with expected URL 
		String currentURL = driver.getCurrentUrl();
		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		
//		Validation Point also know as Assertion point
		if(currentURL.equals(expectedURL)) {
			System.out.println("Test Pass !!");
		} else {
			System.out.println("Test Fail !!");
		}
		
		driver.quit();	
	}
}
