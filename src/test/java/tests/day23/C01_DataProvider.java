package tests.day23;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C01_DataProvider {


    @Test (dataProvider = "aranacakKelimeler")
    public void test02(String words) {
        AmazonPage amazonPage=new AmazonPage();
        //amazona gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //java, selenium, samsung ve iphone icin arama yapalim
        amazonPage.searchBox.sendKeys(words,Keys.ENTER);

        //sonuclarin aradigimiz kelime icerdigini test edelim
        String actualKelime = amazonPage.resultTextWE.getText();
        Assert.assertTrue(actualKelime.contains(words));

        //sayfayi kapatalim

    }

    @DataProvider
    public static Object[][] aranacakKelimeler() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};
    }

    @Test(dependsOnMethods = "test02")
    public void test03() {
        Driver.closeDriver();
    }
}
