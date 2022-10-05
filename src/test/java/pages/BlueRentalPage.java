package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BlueRentalPage {
    public BlueRentalPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//a[@class='btn btn-primary btn-sm']")
    public WebElement loginButtonHomePage;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//button[@id='dropdown-basic-button']")
    public WebElement loggedAsAUserName;
}
