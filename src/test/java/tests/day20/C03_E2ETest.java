package tests.day20;

import com.github.javafaker.Faker;
import org.bouncycastle.jcajce.provider.symmetric.Serpent;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HotelPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_E2ETest {
    @Test
    public void E2ETest() {
        // Tests packagenin altına class olusturun: CreateHotel
        // Bir metod olusturun: createHotel
        // https://www.hotelmycamp.com adresine git.
        Driver.getDriver().get(ConfigReader.getProperty("hotelUrl"));
        HotelPage hotelPage=new HotelPage();
        Faker faker=new Faker();
        SoftAssert softAssert=new SoftAssert();

        // Login butonuna tıklayın.
        hotelPage.loginButton.click();

        // Username textbox ve password metin kutularını locate edin ve asagidaki verileri
        // Username : manager
        // Password  : Manager1!
        hotelPage.userNameBox.sendKeys(ConfigReader.getProperty("userName"));
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("password"))
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();

        // Hotel Management/Room reservation menusunden ADD ROOM RESERVATION butonuna tiklayin
        hotelPage.hotelManagementMenu.click();
        hotelPage.roomReservationsMenu.click();
        hotelPage.addRoomReservationButton.click();

        // Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        // Save butonuna tıklayın.
        hotelPage.IDUser.sendKeys("manager");
        actions.sendKeys(Keys.TAB)
                .sendKeys("Pirlanta",Keys.TAB)
                .sendKeys("125.00",Keys.TAB)
                .sendKeys("12/01/2022",Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("12/04/2022",Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("4",Keys.TAB)
                .sendKeys("1",Keys.TAB)
                .sendKeys(faker.name().fullName(),Keys.TAB)
                .sendKeys(faker.phoneNumber().cellPhone(),Keys.TAB)
                .sendKeys(faker.internet().emailAddress(),Keys.TAB)
                .sendKeys(faker.address().city(),Keys.TAB)
                .sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
                .sendKeys(Keys.SPACE).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();


        // “RoomReservation was inserted successfully” textinin göründüğünü test edin.
        softAssert.assertTrue(hotelPage.successText.isDisplayed());

        // OK butonuna tıklayın.
        hotelPage.succesTextOkButton.click();


    }
}
