package tests.day22;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlueRentalPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseReport;

public class C01_ReportTest extends TestBaseReport {
    @Test
    public void test01() {

        extentTest=extentReports.createTest("Positive Test","Gecerli kullanici adi ve password ile giris yapilabilme testi");
        // -https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        extentTest.info("BlueRentACar sitesine gidildi");

        // -login butonuna bas
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        blueRentalPage.loginButtonHomePage.click();
        extentTest.info("Login butonuna basildi");

        // -test data user email: customer@bluerentalcars.com
        blueRentalPage.emailBox.sendKeys(ConfigReader.getProperty("blueEmail"));
        extentTest.info("Verilen dogru email girildi");

        // -test data password : 12345 dataları girip login e basın
        blueRentalPage.passwordBox.sendKeys(ConfigReader.getProperty("bluePassword"));
        extentTest.info("Verilen dogru password girilidi");
        // -login butonuna tiklayin
        blueRentalPage.loginButton.click();
        extentTest.info("Login butonuna basildi");

        // -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String expectedLogged="ohn Walker";
        String actualLogged=blueRentalPage.loggedAsAUserName.getText();
        Assert.assertEquals(actualLogged,expectedLogged);
        extentTest.info("Verilen datalar ile sisteme basarili olara giris yapilabildigi dogrulandi");


    }
}
