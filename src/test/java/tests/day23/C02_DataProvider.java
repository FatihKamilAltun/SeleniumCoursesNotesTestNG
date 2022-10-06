package tests.day23;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BlueRentalPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {

    @DataProvider
    public static Object[][] users() {
        return new Object[][]{{"kamil@gmail.com","123456"},{"fatih@gmail.com","1234545"},{"altun@gmail.com","25132151"}};
    }

    @Test (dataProvider = "users")
    public void test01(String userEmail,String password) {
        //https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));

        //login butonuna bas
        BlueRentalPage blueRentalPage=new BlueRentalPage();
        blueRentalPage.loginButtonHomePage.click();

        //Data provider ile 3 farklı userEmail ve 3 farklı password girelim
        blueRentalPage.emailBox.sendKeys(userEmail);
        blueRentalPage.passwordBox.sendKeys(password);


        //login butonuna tiklayin
        blueRentalPage.loginButton.click();

        //Degerleri girildiginde sayfaya basarili sekilde girilemedigini test et
        Assert.assertTrue(blueRentalPage.loginButton.isDisplayed());

        Driver.closeDriver();

    }

}
