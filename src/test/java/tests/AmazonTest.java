package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

import static utilities.Driver.quitDriver;

public class AmazonTest {
    public WebDriver driver;
    AmazonPage amazon = new AmazonPage();

    @Test
    public void searchProduct() {
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("urlAmazon"));

        amazon.searchBox.sendKeys(ConfigReader.getProperty("textSearch"));

        amazon.searchButton.click();

        String pageTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Amazon.com : Samsung Note 21";

        Assert.assertEquals(expectedTitle, pageTitle);

        if (pageTitle.equals(expectedTitle)) {
            System.out.println("Baslik dogrulandi");
        } else {
            System.out.println("Baslik dogrulanamadi");
        }

        List<WebElement> productTitles = driver.findElements(By.cssSelector(".a-size-medium.a-color-base.a-text-normal"));

        for (WebElement productTitle : productTitles) {
            String title = productTitle.getText();
            System.out.println(title);
        }
        
        int actualTitleCount = productTitles.size();
        System.out.println("actualTitleCount = " + actualTitleCount);

        int expectedTitleCount = 81;

        Assert.assertEquals(actualTitleCount, expectedTitleCount, "Beklenen : " + expectedTitleCount + " Gercek : " + actualTitleCount);
        
        

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight/2)"); // sayfayi ortaya getirir


        quitDriver();

    }
}
