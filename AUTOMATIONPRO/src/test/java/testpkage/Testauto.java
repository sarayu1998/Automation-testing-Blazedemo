package testpkage;

import org.testng.annotations.Test;

import basepakage.Baseauto;
import pagepkage.Addtocart;
import pagepkage.Loginpage;
import pagepkage.Placeorder;
import pagepkage.Signup;
import utilitypakage.Productdetails;

public class Testauto extends Baseauto {
	
	@Test(priority = 1)
	public void verifyloginwithcred() throws Exception

	{

		Loginpage lp = new Loginpage(driver);
		Addtocart ac = new Addtocart(driver);
		Signup sg = new Signup(driver);
		String xl = "D:\\Sarayu\\EclipseWS\\Project.xlsx";
		String Sheet = "Sheet1";
		int rowCount = Productdetails.getRowCount(xl, Sheet);
		System.out.println("rowcount=" + rowCount);

		for (int i = 1; i <= rowCount; i++) {

			String Username = Productdetails.getCellValue(xl, Sheet, i, 0);
			System.out.println("username---" + Username);
			String Password = Productdetails.getCellValue(xl, Sheet, i, 1);
			System.out.println("password---" + Password);
			sg.Signs();
			sg.setValues(Username, Password);
			sg.signupbutoon();
			Thread.sleep(3000);
			ac.alerthandle();
			lp.Login();
			lp.setValues(Username, Password);

			lp.loginbutton();
			Thread.sleep(3000);
			ac.phoneclick();
			Thread.sleep(2000);
			ac.addtocart();
			ac.alerthandle();

		}
	}

	@Test(enabled = true)
	public void titleverification() {
		String actualtitle = driver.getTitle();
		System.out.println(actualtitle);
		String exptitle = "STORE";
		if (actualtitle.equals(exptitle)) {
			System.out.println("pass");
		} else {
			System.out.println("fail");
		}
		System.out.println("Title = " + actualtitle);
	}

	@Test(priority = 2)
	public void placeordermethod() throws Exception {

		String expectedurl = "https://www.demoblaze.com/prod.html?idp_=1";
		String actualurl = driver.getCurrentUrl();

		if (actualurl.equals(expectedurl)) {
			System.out.println("pass");

			Placeorder po = new Placeorder(driver);
			po.cartclick();
			po.placeorderclick();
			Thread.sleep(2000);

			po.setValues("Sarayumol p mani", "India", "Kottayam", "1234566778888", "October", "2028");
			po.purchaseclick();
			Thread.sleep(2000);
			po.okayclick();
		} else {
			System.out.println("fail");
		}

	}

}
