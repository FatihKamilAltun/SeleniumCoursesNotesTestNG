package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.time.Duration;

public class CrossDriver {

    private CrossDriver() {

    }

    static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        // Eger browser'a bir deger atanmamissa ConfigReader'daki browser calissin
        browser = browser == null ? ConfigReader.getProperty("browser") : browser;


        /*
        Testlerimizi .xml file'dan farkli browserlar ile calisirabilmek icin
        getDriver() methoduna parametre atamamiz gerekir.
         */
        if (driver == null) {
            switch (browser) {
                /*
                CrossBrowser icin bizim gonderdigimiz browser uzerinden calismasi icin
                buraya parametre olarak girdigimiz degeri yazdik
                 */
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "opera":
                    WebDriverManager.operadriver().setup();
                    driver = new OperaDriver();
                    break;

                case "headless-chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) { // driver'a degere atanmissa
            driver.close();
            driver = null; // kapattıktan sonraki açmalari garanti altına almak için driver'i null yaptık
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
