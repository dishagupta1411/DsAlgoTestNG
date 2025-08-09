package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;

public class GraphPage  {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private Actions action;
	private JavascriptExecutor js;
	
	@FindBy(xpath = "//a[text()='Get Started' and @href='graph']")
	WebElement graphGetStarted;
	@FindBy(xpath = "//a[@href='graph' and text()='Graph']")
	WebElement graph;
	@FindBy(xpath = "//a[contains(text(),'Graph Representations')]")
	WebElement graphRepr;
	@FindBy(tagName = "a")
	List<WebElement> graphLinks;
	@FindBy(xpath = "//a[@href='/tryEditor' and contains(text(),'Try here')]")
	WebElement tryHereButton;
	@FindBy(xpath = "//button[contains(text(),'Run')]")
	WebElement runButton;
	@FindBy(xpath = "//div[@class='CodeMirror-measure']//span")
	WebElement textEditor;
	@FindBy(id = "output")
	WebElement outputTxt;
	@FindBy(xpath = "//*[text()='Practice Questions']")
	WebElement practQuestGraph;
	// background
	@FindBy(xpath = "//a[text()='Sign in']")
	private WebElement signin;
	@FindBy(id = "id_username")
	private WebElement usernameField;
	@FindBy(id = "id_password")
	private WebElement passwordField;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement loginButton;
	@FindBy(xpath = "//button[text()='Get Started']")
	WebElement loginGetStarted;
	@FindBy(id = "content")
	WebElement practicePage;


//constructor 
	public GraphPage() {
		this.driver = DriverFactory.getdriver();
		PageFactory.initElements(driver, this);
		this.action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
//Login to Graph 
	public void getTograph() throws InterruptedException, IOException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", graphGetStarted);
		wait.until(ExpectedConditions.visibilityOf(graphGetStarted));
		action.moveToElement(graphGetStarted).click().perform();
	}
	
	public void click_Graph_link() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(graph));
		action.moveToElement(graph).click().perform();
	}

	public void click_GraphRepre() {
		action.moveToElement(graphRepr).click().perform();
	}
	
	public void click_practQuest() {
		action.moveToElement(practQuestGraph).click().perform();
	}
	
	public String checkNavigation() {
		@Nullable
		String title = driver.getTitle();
		return title;
	}
	

}
