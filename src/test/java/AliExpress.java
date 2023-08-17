import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AliExpress {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.aliexpress.com");
    }

    @Test
    public void testProductSearches() throws InterruptedException {
        String searchKeyword = "phone";

        WebElement searchBox = driver.findElement(By.xpath("//input[@name=\"SearchText\"]"));
        searchBox.sendKeys(searchKeyword);

        WebElement searchButton = driver.findElement(By.className("search-button"));
        searchButton.click();

        Thread.sleep(2000);

        String mainWindowHandle = driver.getWindowHandle();
        for(String windowhandle : driver.getWindowHandles()) {
            if (!windowhandle.equals(mainWindowHandle)) {
                driver.switchTo().window(windowhandle);
                break;
            }
        }

        WebElement btnCookies = driver.findElement(By.className("btn-accept"));
        btnCookies.click();

        driver.switchTo().window(mainWindowHandle);

        WebElement btnStar = driver.findElement(By.xpath("(//span[@class=\"comet-checkbox-circle\"])[4]"));
        btnStar.click();
    }

}
