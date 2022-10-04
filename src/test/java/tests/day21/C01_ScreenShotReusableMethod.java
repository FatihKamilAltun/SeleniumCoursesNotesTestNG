package tests.day21;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {
    @Test
    public void test01() throws IOException, InterruptedException {
        // Amazon sayfasina gidelim
        Driver.getDriver().get("https://amazon.com");

        // Sayfanin ekran resmini alınız
        ReusableMethods.getScreenshot("amazon");

        // Sayfayi kapatiniz
        Driver.closeDriver();
    }
    @Test
    public void test02() throws IOException {
        //Amazon sayfasına gidiniz
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        AmazonPage amazonPage = new AmazonPage();

        //Nutella aratınız
        amazonPage.searchBox.sendKeys("Nutella", Keys.ENTER);

        //Arama sonuc yazısı Webelementinin resmini alınız
        ReusableMethods.getScreenshotWebElement("AramaSonucWE",amazonPage.resultTextWE);

        Driver.closeDriver();
    }
}
