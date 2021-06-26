package bukaLapakSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SearchFunction {

	WebDriver driver;

	@BeforeTest
	public void openURL(){

		System.setProperty("webdriver.chrome.driver","C:\\Eclipse\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.bukalapak.com/");
	}

	@Test
	public void performSearch() {

		//Find search bar
		driver.findElement(By.name("search[keywords]")).click();

		//Enter items
		driver.findElement(By.name("search[keywords]")).sendKeys("tas sepeda lipat");

		//Click search icon
		driver.findElement(By.xpath("//*[@id=\"v-omnisearch\"]/button")).click();

		//Expected result-will show section total of items
		driver.findElement(By.xpath("//p[@class=\"te-total-products bl-text bl-text--body-small bl-text--subdued\"]"));

	}

	@AfterTest
	public void tearDown(){
		if (driver != null){
			driver.quit();
		}
	}

}

