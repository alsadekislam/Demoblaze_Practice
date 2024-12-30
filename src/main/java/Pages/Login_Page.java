package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login_Page extends Base {
    @FindBy(xpath = "//*[@id=\"login2\"]")
    private WebElement Login_Page;
    @FindBy(id = "loginusername")
    private WebElement Username_Field;
    @FindBy(id = "loginpassword")
    private WebElement Password_Field;
    @FindBy(xpath = "//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    private WebElement Login_Button;
    @FindBy(xpath = "//*[@id=\"logout2\"]")
    private WebElement Logout_Button;

    private By loginButton;

    public Login_Page(WebDriver driver) {
        super(driver);
    }

    public void Go_To_Login_Page() {
        click(Login_Page);
    }

    public void Enter_Username(String username) {
        sendkey(Username_Field, username);
    }

    public void Enter_Password(String Text) {
        sendkey(Password_Field, Text);
    }

    public void Enter_Login_Button() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(Login_Button));
//        click(driver.findElement(Login_Button_New));
        click(Login_Button);
    }

    public void Alert() {
        driver.switchTo().alert().accept();

    }

    public void Logout_Button() {
        click(Logout_Button);
    }

}
