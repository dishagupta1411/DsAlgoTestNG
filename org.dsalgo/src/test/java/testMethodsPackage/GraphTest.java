package testMethodsPackage;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import driverFactory.DriverFactory;
import pageObjects.BasePage;
import pageObjects.GraphPage;
import utils.ExcelReaderTestNg;

//why extend base class, dont need to init driverand quit driver. If I dont extend I have initial the driver in all class
public class GraphTest extends BaseTest{
	GraphPage graphPg;
	BasePage basePg;
	BaseTest baseTest;
	DriverFactory driverfact;
	
	@BeforeMethod
	public void graphPage() throws InterruptedException, IOException {
		graphPg = new GraphPage();
		basePg = new BasePage();
		
	}
	
	 
	  
	//@Test(priority=1)
	 public void getClick_Graph() throws InterruptedException, IOException {
		// graphPg = new GraphPage();
		 graphPg.getTograph();
		 graphPg.click_Graph_link();
	 }
	 
	 
	 //@Test(priority=2)
	 public void getClick_GraphRepre() throws InterruptedException, IOException {
		 graphPg.getTograph();
		 graphPg.click_GraphRepre();
	 }
	
	 
	// @Test(priority=3)
	 public void getTitleGraph() throws InterruptedException, IOException {	
		 graphPg.getTograph();
		 graphPg.click_Graph_link();
		 String currentTitle = graphPg.checkNavigation();
		 System.out.println("The page naviagated to - " + currentTitle);
	 }
	
	// @Test(priority=4)
	 public void getTitleGraphRepre() throws InterruptedException, IOException {	
		 graphPg.getTograph();
		 graphPg.click_GraphRepre();
		 String currentTitle = graphPg.checkNavigation();
		 System.out.println("The page naviagated to - " + currentTitle);
	 }
	 
	 
	 @Test(priority=5 ,dataProvider="dataPro", dataProviderClass=ExcelReaderTestNg.class)
	 public void validCode(String validCode) throws InterruptedException, IOException {
		 graphPg.getTograph();
		 graphPg.click_Graph_link();
		 basePg.clickTryHere();
		 basePg.validCode(validCode);
		 String checkOuputMsg = basePg.checkOuputMsg();
		 System.out.println("The Ouput is " + checkOuputMsg);
	 }
	 
	 //@Test(priority=6)
	 public void invalidCode() throws InterruptedException, IOException {
		 graphPg.getTograph();
		 graphPg.click_Graph_link();
		 basePg.clickTryHere();
		 basePg.invalidCode();
		 String alert_message = basePg.alert_message();
		 System.out.println("The alert msg is : " + alert_message);
		 basePg.handleAlert();
	 }

}
