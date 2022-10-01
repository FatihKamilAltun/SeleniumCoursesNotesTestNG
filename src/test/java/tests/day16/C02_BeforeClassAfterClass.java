package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C02_BeforeClassAfterClass extends TestBaseBeforeClassAfterClass {
    @Test
    public void amazonTesti() {
        driver.get("https://amazon.com");
    }

    @Test
    public void bestbuyTesti() {
        driver.get("https://bestbuy.com");
    }

    @Test
    public void trendyolTesti() {
        driver.get("https://trendyol.com");
    }


}
