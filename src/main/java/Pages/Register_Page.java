package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register_Page extends Base{
    @FindBy(id="signin2")
    private WebElement signUpButton;
    @FindBy(id="sign-username")
    private WebElement enterUsername;
    @FindBy(id="sign-password")
    private WebElement enterPassword;
    @FindBy(xpath = "//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")
    private WebElement enterToSignupButton;
    public Register_Page(WebDriver driver)
    {
        super(driver);
    }
    public void signUpButton()
    {
        click(signUpButton);

    }
    public void enterUsername(String UserName)
    {
        sendkey(enterUsername,UserName);
    }
    public void enterPassword(String Password)
    {
        sendkey(enterPassword,Password);
    }
    public void enterToSignupButton()
    {
        click(enterToSignupButton);
    }
    public void acceptAlert()
    {
        driver.switchTo().alert().accept();

    }
    public void clearFields() {
        enterUsername.clear();
        enterPassword.clear();
    }




}

