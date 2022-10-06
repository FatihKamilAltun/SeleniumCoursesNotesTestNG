package tests.day22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;
import utilities.TestBaseCross;

public class C03_SoftAssert extends TestBaseCross {
    @Test
    public void test01() {
        // softassert baslangic ve bitis satirlari arasindaki tum assertionlari yapip
        // bitis olarak belirtmemiz gereken assertAll methoduyla test methodumuzdaki butun assertionlari kontrol eder
        // failed olan olursa assertion yaptigimiz metodun sonuna yazilan mesaji
        // konsolda verir

        SoftAssert softAssert=new SoftAssert();

        //1-amazon anasayfaya gidin
        driver.get("https://amazon.com");

        //2-title in Amazon içerdigini test edin
        softAssert.assertTrue(driver.getTitle().contains("Amazon"),"Girilen kelime string icermiyor");

        //3-arama kutusnun erişilebilir oldugunu tets edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        softAssert.assertTrue(aramaKutusu.isDisplayed(),"webelemente erisilemedi");

        //4-arama kutusuna Nutella yazıp aratın
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);

        //5-arama yapıldıgını test edin
        WebElement sonuc = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(sonuc.isDisplayed(),"sonuc elementi goruntulenemedi");

        //6-arama sonucunun Nutella içerdigini test edin
        softAssert.assertTrue(sonuc.getText().contains("Nutella"),"nutella icermiyor");
        softAssert.assertAll();
        System.out.println("hata olursa burasi calismaz");
    }
}
