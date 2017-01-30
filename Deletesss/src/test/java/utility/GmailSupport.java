package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class GmailSupport {

	
	WebDriver driver;
    WebDriverWait wait;

    @Test
    public void name() throws InterruptedException, AWTException {
        System.setProperty(Constants.DRIVER_CHROME, Constants.DRIVER_LAUNCHER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Constants.JINI_URL);
        wait = new WebDriverWait(driver, 30);

        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_T);
        r.keyRelease(KeyEvent.VK_CONTROL);
        r.keyRelease(KeyEvent.VK_T);

        String parentWindowHandler = driver.getWindowHandle();
        // Store your parent window
        String subWindowHandler = null;
        Set<String> handles = driver.getWindowHandles();
        // get all window handles
        Iterator<String> iterator = handles.iterator();
        while (iterator.hasNext()) {
            subWindowHandler = iterator.next();
        }
        driver.switchTo().window(subWindowHandler);
        Thread.sleep(5000);
        driver.get(
                "https://accounts.google.com/ServiceLogin?service=mail&continue=https://mail.google.com/mail/#identifier");
        Thread.sleep(2000);
        String sUsername = "tringapps001@gmail.com";
        String sPassword = "Tringapps@123";
        driver.findElement(By.id("Email")).sendKeys(sUsername);
        System.out.println("ID entered successfully");
        driver.findElement(By.id("next")).click();
        System.out.println("Entered NEXT successfully");
        Thread.sleep(2000);
        driver.findElement(By.id("Passwd")).sendKeys(sPassword);
        Thread.sleep(1000);
        driver.findElement(By.id("signIn")).click();
        System.out.println(" signin successfull");
        Thread.sleep(3000);
        driver.findElement(By
                .xpath("//*[@class='y6']//*[text()='jinigram-Welcome to jinigram-Click here to confirm your registration']"))
                .click();
        System.out.println(" Opened the mail");
        driver.findElement(By.linkText("Confirm my account")).click();
        System.out.println("Tapped on the click");
        driver.close();
        driver.switchTo().window(parentWindowHandler);

    }	
    
}

