package Tests;

import Pages.Register_Page;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Register extends TestBase {
    Register_Page Register;
    @Test
    public void registerWithValidData() throws InterruptedException {
        Register=new Register_Page(driver);
        String email = "Isi@" + System.currentTimeMillis();
        Register.signUpButton();
        Register.enterUsername(email);
        Register.enterPassword("10111010"+System.currentTimeMillis());
        Register.enterToSignupButton();
        Thread.sleep(3000);
        String alertText = driver.switchTo().alert().getText();
        Register.acceptAlert();
        Assert.assertEquals(alertText, "Sign up successful.");

    }


    @Test
    public void registerWithEmptyFiled() throws InterruptedException {
        Register=new Register_Page(driver);
        Register.signUpButton();
        Register.enterUsername("");
        Register.enterPassword("");
        Register.enterToSignupButton();
       Thread.sleep(3000);
        String alertText = driver.switchTo().alert().getText();
        Register.acceptAlert();
        Assert.assertEquals(alertText, "Please fill out Username and Password.");
        Thread.sleep(2000);

    }
    @Test
    public void registerWithExistUser() throws InterruptedException {

        Register= new Register_Page(driver);

        Register.signUpButton();
        Register.enterUsername("Ismail456");
        Register.enterPassword("101010");
        Register.enterToSignupButton();
        Thread.sleep(3000);
        String alertText=driver.switchTo().alert().getText();
        Register.acceptAlert();
        Assert.assertEquals(alertText, "This user already exist.");

    }

}
