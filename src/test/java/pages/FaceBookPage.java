package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class FaceBookPage {
    public FaceBookPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement email;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='_9ay7']")
    public WebElement loginFailText;


}
