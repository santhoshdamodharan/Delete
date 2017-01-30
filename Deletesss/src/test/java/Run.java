import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Run {

	@Test
	public void test(){
	System.out.println("Done");	
	System.setProperty("webdriver.chrome.driver",
			"C://Users/Dell/workspace/Jini_Wiki/libraries/driver_path/Chrome_driver/chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("http://google.com");
	}
}
