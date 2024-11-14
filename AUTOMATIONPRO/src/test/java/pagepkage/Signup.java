package pagepkage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Signup {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"signin2\"]")
	WebElement signup;
	@FindBy(xpath="//*[@id=\"sign-username\"]")
	WebElement username;
	@FindBy(xpath="//*[@id=\"sign-password\"]")
	WebElement passw;
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
	WebElement submitsign;
	@FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")
	WebDriver signs;
	public Signup(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		public void Signs()
		{
		signup.click();
		}
		public void setValues(String name, String Pass) throws Exception {
			System.out.println("setvalues");
			Thread.sleep(500);
			username.clear();
			username.sendKeys(name);
			passw.clear();
			passw.sendKeys(Pass);

}
		public void signupbutoon() {
			submitsign.click();
		}
	
}
