package tests.day18;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_ConfigReader {
    @Test(groups = "gp2")
    public void test01() {
        // https://www.hotelmycamp.com/ adresine git  login butonuna bas
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        HotelPage hotelPage=new HotelPage();
        // Page class'indaki locate'lerimize ulasabilmek icin
        // Page class'imizdan bir obje olusturararak, olusturmus oldugumuz obje ile
        // Page class'imizdaki locate'lere ulasabiliriz

        hotelPage.loginButton.click();

        // test data username: manager ,  test data password : Manager1!
        hotelPage.userNameBox.sendKeys(ConfigReader.getProperty("userName"));
        hotelPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        hotelPage.loginButtonForPage.click();

        // Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        Assert.assertTrue(hotelPage.loggedAsManagerLogo.isDisplayed());


    }



}
