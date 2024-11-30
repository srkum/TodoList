package todo.pages.test;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TodoPageFunctionsTest {
	ChromeDriver driver;
	int timeOutSeonds = 2;
    
	@Test(priority = 1)
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
	
	@Test (priority = 2)
	public void getPageTitle() {
		
		//checking page title after page is loaded
		String actualTitle = driver.getTitle();
		String expectedTitle = "TodoMVC: React";
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	
	@Test (priority = 3)
	public void addToDoList() {
		//adding list in todo text box 
		WebElement todoList = driver.findElement(By.id("todo-input"));
		todoList.sendKeys("Open URL" + Keys.ENTER);
		todoList.sendKeys("Todo list added" + Keys.ENTER);
		todoList.sendKeys("More Todo list added" + Keys.ENTER);		
	}
	
	@Test (priority = 4)
	public void editToDoListText(){
		//text editing by double clicking 
		String textEditPath = "#root > main > ul > li:nth-child(1) > div > label";
		Actions builder = new Actions(driver);
		builder.doubleClick(driver.findElement(By.
				cssSelector(textEditPath))).
		sendKeys("--Completed--" + Keys.ENTER);
		builder.build().perform();	
	}
	
	@Test (priority = 5)
	public void makeTaskComplete(){
		String path = "//*[@id=\"root\"]/main/ul/li[1]/div/input";
		driver.findElement(By.xpath(path)).click();
		takePicture();
	
	}
	
	public void takePicture(){
		File firstScreen = driver.getScreenshotAs(OutputType.FILE);		
		File dest = new File("./snaps/img.png");	
		try {
			FileHandler.copy(firstScreen, dest);
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	
	@Test (priority = 6)
	public void closeBrowser() {
		//closing the browser
		driver.quit();
	}
}
