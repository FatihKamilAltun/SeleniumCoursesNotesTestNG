package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class HotelPage {
    public HotelPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Log in']")
    public WebElement loginButton;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement userNameBox;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@value='Log in']")
    public WebElement loginButtonForPage;

    @FindBy(xpath = "//span[@class='username username-hide-on-mobile']")
    public WebElement loggedAsManagerLogo;
    @FindBy(xpath = "//*[text()='Try again please']")
    public WebElement logginFailed;

    @FindBy(xpath = "//*[text()='Hotel Management']")
    public WebElement hotelManagementMenu;

    @FindBy(xpath = "(//i[@class='icon-calendar'])[4]")
    public WebElement roomReservationsMenu;

    @FindBy(xpath = "//*[text()='Add Room Reservation ']")
    public WebElement addRoomReservationButton;

    @FindBy(xpath = "//select[@id='IDUser']")
    public WebElement IDUser;

    @FindBy(xpath = "//*[text()='RoomReservation was inserted successfully']")
    public WebElement successText;

    @FindBy(xpath = "(//button[@type='button'])[8]")
    public WebElement succesTextOkButton;


}
