package utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public abstract class TestBaseBeforeClassAfterClass {
    protected WebDriver driver;
    protected Actions actions;
    protected Faker faker;

    // @BeforeClass ve @AfterClass notasyonlarını TestNG'de kullanırken
    // JUnit'deki gibi static yapmaya gerek yoktur

    @BeforeClass(groups = "gp1")
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        actions=new Actions(driver);
        faker=new Faker();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass(groups = "gp1")
    public void tearDown(){

        driver.close();
    }
}
