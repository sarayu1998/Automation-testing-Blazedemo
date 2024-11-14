package basepakage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Baseauto {

	public static WebDriver driver;

	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}

	@Test
	public void test() {
		driver.get("https://www.demoblaze.com/");
		driver.manage().window().maximize();
	}

}
