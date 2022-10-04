package tests.day16;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C01_BeforeMethodAfterMethod extends TestBaseBeforeMethodAfterMethod {
    // TestNG framework'unde @Before ve @After notasyonları yerine @BeforeMethod ve @AfterMethod kullanılır
    // Çalışma prensibi JUnit deki Before,After ile aynıdır

    @Test
    public void amazonTesti() {
        driver.get("https://amazon.com");
    }

    @Test(groups = "gp1")
    public void bestbuyTest() {
        driver.get("https://bestbuy.com");
    }

    @Test
    public void trendyolTesti() {
        driver.get("https://trendyol.com");
    }
}
