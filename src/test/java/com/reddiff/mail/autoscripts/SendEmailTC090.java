package com.reddiff.mail.autoscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.reddiff.mail.elementrepository.DashboardPage;
import com.reddiff.mail.elementrepository.HomePage;
import com.reddiff.mail.elementrepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SendEmailTC090 {
	@Test
	public static void sendMail() throws InterruptedException {
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.get("https://www.rediff.com");
		
		String emailId = "daya.dmn@rediffmail.com";
		String subject = "Daya143@dmn";
				
		
		
		
		HomePage hp = ((LoginPage) new DashboardPage(driver)
										.clickOnMenuIcon("Rediffmail"))
											.login("daya.dmn@rediffmail.com", "Daya143@dmn");
		hp.sendEmail(emailId, subject, "Studying Automation in Qspiders!!");
		
		if(hp.isEmailSent(emailId, subject)) {
			System.out.println("PASS");
		} else {
			System.out.println("FAIL");
		}
		
		Thread.sleep(5000);
		
		hp.getLogoutLink().click();
		System.out .println("hi   ");
		
		driver.quit();		
	}
}
