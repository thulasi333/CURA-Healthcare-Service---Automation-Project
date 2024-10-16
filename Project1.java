package com.selenium;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Project1 {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://katalon-demo-cura.herokuapp.com/");
		driver.manage().window().maximize();
//Home page		
		WebElement home = driver.findElement(By.xpath("//a[text()='Make Appointment']"));
		home.click();
//Login page		
		WebElement demousername = driver.findElement(By.xpath("//input[@value=\"John Doe\"]"));
		String text = demousername.getAttribute("value");
		System.out.println(text);
		WebElement username = driver.findElement(By.id("txt-username"));
		username.sendKeys(text);
		WebElement demopassword = driver.findElement(By.xpath("//input[@value=\"ThisIsNotAPassword\"]"));
		String text1 = demopassword.getAttribute("value");
		System.out.println(text1);
		WebElement password = driver.findElement(By.id("txt-password"));
		password.sendKeys(text1);
		WebElement login = driver.findElement(By.id("btn-login"));
		login.click();
//Appointment page		
		WebElement Facility = driver.findElement(By.id("combo_facility"));
		Select opt = new Select(Facility);
		opt.selectByValue("Seoul CURA Healthcare Center");
		WebElement active = driver.findElement(By.id("chk_hospotal_readmission"));
		active.click();
		WebElement program = driver.findElement(By.xpath("//input[@value=\"Medicaid\"]"));
		program.click();
		WebElement cal = driver.findElement(By.id("txt_visit_date"));
		cal.sendKeys("19/10/2024");
		WebElement comment = driver.findElement(By.id("txt_comment"));
		comment.sendKeys("fever");
		WebElement bookingbutton = driver.findElement(By.id("btn-book-appointment"));
		bookingbutton.click();
//Screenshot
		 Screenshot take = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		 ImageIO.write(take.getImage(),"PNG",new File(System.getProperty("user.dir") + "\\Screenshots\\Project1.png"));
		
		 
		 driver.quit();

	}

}
