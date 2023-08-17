import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.Driver;

import static org.testng.Assert.assertTrue;
import static utilities.ReusableMethods.bekle;

public class MultipleTests {

    @Test(priority = 4)
    public void openYoutube() {
        Driver.getDriver().get("https://www.youtube.com/");
        System.out.println("Youtube sitesi acildi");
        assertTrue(true);
        bekle(5);

    }

    @Test(priority = 2)
    public void openAmazon() {
        Driver.getDriver().get("https://www.amazon.com/");
        System.out.println("Amazon sitesi acildi");
        assertTrue(true);

    }

    @Test(enabled = false) // burayi görmez
    public void openAliExpress() {
        Driver.getDriver().get("https://www.aliexpress.com/");
        System.out.println("AliExpress sitesi acildi");
        assertTrue(true);

    }

    @Test(priority = 1, dependsOnMethods = "openYoutube")
    public void openFacebook() {
        Driver.getDriver().get("https://www.facebook.com/");
        System.out.println("Facebook sitesi acildi");
        assertTrue(true);

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();

    }
}
