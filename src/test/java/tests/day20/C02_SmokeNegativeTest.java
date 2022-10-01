package tests.day20;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_SmokeNegativeTest {

    @Test
    public void wrongUser() {

        //  https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        HotelPage hotelPage=new HotelPage();

        // login butonuna bas
        hotelPage.loginButton.click();

        // test data username: manager1 ,  test data password : manager1!
        hotelPage.userNameBox.sendKeys(ConfigReader.getProperty("hotelMyCampWrongUser"));
        hotelPage.passwordBox.sendKeys(ConfigReader.getProperty("password"));
        hotelPage.loginButtonForPage.click();

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelPage.logginFailed.isDisplayed());
    }




    @Test
    public void wrongPassword() {

        //  https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        HotelPage hotelPage=new HotelPage();

        // login butonuna bas
        hotelPage.loginButton.click();

        // test data username: manager1 ,  test data password : manager1!
        hotelPage.userNameBox.sendKeys(ConfigReader.getProperty("userName"));
        hotelPage.passwordBox.sendKeys(ConfigReader.getProperty("hotelMyCampWrongPassword"));
        hotelPage.loginButtonForPage.click();

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelPage.logginFailed.isDisplayed());
    }


    @Test
    public void wrongUserAndPassword() {

        //  https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        HotelPage hotelPage=new HotelPage();

        // login butonuna bas
        hotelPage.loginButton.click();

        // test data username: manager1 ,  test data password : manager1!
        hotelPage.userNameBox.sendKeys(ConfigReader.getProperty("hotelMyCampWrongUser"));
        hotelPage.passwordBox.sendKeys(ConfigReader.getProperty("hotelMyCampWrongPassword"));
        hotelPage.loginButtonForPage.click();

        // Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelPage.logginFailed.isDisplayed());
    }
}
