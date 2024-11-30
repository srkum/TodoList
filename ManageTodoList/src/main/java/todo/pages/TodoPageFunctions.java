package todo.pages;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TodoPageFunctions {
	
	ChromeDriver driver;
	int timeOutSeonds = 2;
	
	@SuppressWarnings("deprecation")
	public void chromeOpenUrl() {
		//setting the driver executable
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		//Initiating your chrome driver
		driver=new ChromeDriver(); 
		//maximize window
		driver.manage().window().maximize();
		//open browser with desired URL
		driver.get("https://todomvc.com/examples/react/dist/");
		//Applied wait time
		driver.manage().timeouts().implicitlyWait(timeOutSeonds, TimeUnit.SECONDS);
	}
	
	public void otherBrowserOpenUrl() {
		
	}
	
	public void getPageTitle() {
		//checking page title after page is loaded
		String actualTitle = driver.getTitle();
		String expectedTitle = "TodoMVC: React";
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	public void getPageText() {
		//checking page text after page is loaded
		String actualText = driver.findElement(By.tagName("h1")).getText();
		String expectedText = "todos";
		System.out.println(actualText);
		Assert.assertEquals(actualText,expectedText);
	}
	
	public void addToDoList() {
		//adding list in todo text box 
		WebElement todoList = driver.findElement(By.id("todo-input"));
		todoList.sendKeys("Open URL" + Keys.ENTER);
		todoList.sendKeys("Todo list added" + Keys.ENTER);
		todoList.sendKeys("More Todo list added" + Keys.ENTER);		
	}
	
	public void editToDoListText(){
		//text editing by double clicking 
		String textEditPath = "#root > main > ul > li:nth-child(1) > div > label";
		Actions builder = new Actions(driver);
		builder.doubleClick(driver.findElement(By.
				cssSelector(textEditPath))).
		sendKeys("--Completed--" + Keys.ENTER);
		builder.build().perform();	
	}
	
	public void makeTaskComplete(){
		String path = "//*[@id=\"root\"]/main/ul/li[1]/div/input";
		driver.findElement(By.xpath(path)).click();
		takePicture();	
	}
	
	public void viewAllToDoList() {
		
	}
	
	public void viewActiveToDoList() {
		
	}
	
	public void viewCompletedToDoList() {
		
	}
	
	public void clearCompletedToDoList() {
		
	}
	
	public void checkMaxToDoList() {
		
	}
	
	public void navigateToDoMVCPage() {
		String pathMvcPage = "body > footer > p:nth-child(3) > a";
		driver.findElement(By.cssSelector(pathMvcPage)).click();
		
	}
	
	public void backToMainPage() {
		
	}
	
	public void takePicture(){
		File tmpFile = driver.getScreenshotAs(OutputType.FILE);		
		File imgFile = new File("./snaps/img.png");		
		try {
			FileUtils.copyFile(tmpFile, imgFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public void extendedReport() {
		
	}
	
	public void closeBrowser() {
		//closing the browser
		driver.quit();
	}


}
