package testMethodsPackage;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;

import driverFactory.DriverFactory;
import pageObjects.BasePage;


@Listeners(ChainTestListener.class)
public class BaseTest {
	
	@BeforeMethod
	@Parameters("browser")
	public void setup(@Optional("chrome") String browser) throws IOException, InterruptedException {
		DriverFactory driverFact = new DriverFactory();
		driverFact.initDriver(browser);//initialize the driver
		BasePage basePg = new BasePage();
	     basePg.loadurl();
	     basePg.clickGetStart();
	     basePg.clickSignIn();
		 basePg.setUserName();
		 basePg.setPassword();
		 basePg.clickLogin();
	}
	
	
	
	
	   @AfterMethod
	    public void tearDown() {
	        DriverFactory.quitDriver();
	    }

}
