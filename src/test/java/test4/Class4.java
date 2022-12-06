package test4;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Class4 {
public static WebDriver driver;
public static Properties prop;
public static FileInputStream ip;

@Test
public void PropertyFile() throws Exception {
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	
	
	String path = System.getProperty("user.dir")+ "\\src\\test\\java\\My.properties";
	prop = new Properties();
	ip = new FileInputStream(path);
	prop.load(ip);
	
	driver.get(prop.getProperty("url"));
	driver.findElement(By.cssSelector(prop.getProperty("signinlinklocator"))).click();
	driver.findElement(By.id(prop.getProperty("usernamelocator"))).sendKeys(prop.getProperty("username"));
    driver.findElement(By.id(prop.getProperty("passwordlocator"))).sendKeys(prop.getProperty("password"));
    driver.quit();
}
}
