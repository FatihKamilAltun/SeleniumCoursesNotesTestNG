package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverIlkTest {
    @Test
    public void test01() {
        // TestBase classina extends ederek kullandigimiz driver yerine artık Driver class'indan kullanacagimiz
        // getDriver() static method'unu kullanabiliriz
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().get("https://bestbuy.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://hepsiburada.com");
    }
}
