package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.RaporluTeknosaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class RaporluTeknosaTest extends TestBaseRapor {

    public WebDriver driver;
    RaporluTeknosaPage teknosa = new RaporluTeknosaPage();

    @Test
    public void test01() {
        extentTest = extentReports.createTest("Teknosa arama testi");
        // ExtentReports kütüphanesinde bir testi olusturmak icin kullanilir. Bir testin adini veaciklöamasini belirtmemizi saglar.
        Driver.getDriver().get(ConfigReader.getProperty("urlTeknosa"));
        extentTest.info("Kullanici Teknosa anasayfasina gider");

        teknosa.search.sendKeys("Monster");
        extentTest.info("Kullanici 'Monster' yazar");

        teknosa.search.submit();
        extentTest.info("submit yapilir");


    }

}
