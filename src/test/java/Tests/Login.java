package Tests;

import Pages.Login_Page;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase{
    Login_Page Login;
    @Test
    public void Login_With_Valid_Data() throws InterruptedException {
        Login=new Login_Page(driver);
        Login.Go_To_Login_Page();
        Login.Enter_Username("Isi@ggmail.autlook");
        Login.Enter_Password("10111010");
        Login.Enter_Login_Button();
        Thread.sleep(3000);
        String actual=driver.findElement(By.xpath("//*[@id=\"nameofuser\"]")).getText();
        Assert.assertEquals(actual,"Welcome Isi@ggmail.autlook" );

    }
    @Test
    public void Login_With_Invalid_Data() throws InterruptedException {
        Login=new Login_Page(driver);
        Login.Go_To_Login_Page();
        Login.Enter_Username("Ahmed###");
        Login.Enter_Password("51548");
        Login.Enter_Login_Button();
        Thread.sleep(3000);
        String alertText=driver.switchTo().alert().getText();
        Assert.assertEquals(alertText,"User does not exist.");
    }
    @Test
    public void Login_With_Empty_Field() throws InterruptedException {
        Login=new Login_Page(driver);
        Login.Go_To_Login_Page();
        Login.Enter_Username("");
        Login.Enter_Password("");
        Login.Enter_Login_Button();
        Thread.sleep(3000);
        String alert=driver.switchTo().alert().getText();
        Assert.assertEquals(alert,"Please fill out Username and Password.");
    }
    @Test
    public void LoginWithEmptyUSer() throws InterruptedException {
        Login=new Login_Page(driver);
        Login.Go_To_Login_Page();
        Login.Enter_Username("");
        Login.Enter_Password("4555665");
        Login.Enter_Login_Button();
        Thread.sleep(3000);
        String alert=driver.switchTo().alert().getText();
        Assert.assertEquals(alert,"Please fill out Username and Password.");
    }
    @Test
    public void LoginWithWrongPassword() throws InterruptedException {
        Login=new Login_Page(driver);
        Login.Go_To_Login_Page();
        Login.Enter_Username("Isi@ggmail.autlook");
        Login.Enter_Password("4555665");
        Login.Enter_Login_Button();
        Thread.sleep(3000);
        String alert=driver.switchTo().alert().getText();
        Assert.assertEquals(alert,"Wrong password.");

    }
    @Test(priority = 6)
    public void LoginWithNotExistUser() throws InterruptedException {
        Login=new Login_Page(driver);
        Login.Go_To_Login_Page();
        Login.Enter_Username("Hamada");
        Login.Enter_Password("4555665");
        Login.Enter_Login_Button();
        Thread.sleep(3000);
        String alert=driver.switchTo().alert().getText();
        Assert.assertEquals(alert,"User does not exist.");

    }

}
