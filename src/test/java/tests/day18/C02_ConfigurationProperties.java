package tests.day18;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_ConfigurationProperties {

    @Test
    public void test01() {
        // Amazon sayfasina ve facebook'a gidelim
        String urlAmazon=ConfigReader.getProperty("amazonUrl");
        String urlFb=ConfigReader.getProperty("fbUrl");

        Driver.getDriver().get(urlAmazon);
        Driver.getDriver().get(urlFb);
        Driver.closeDriver();
    }
}
