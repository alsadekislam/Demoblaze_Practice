package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Base {
    WebDriver driver;
    public Base(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }
    protected void click(WebElement element)
    {
        element.click();

    }
    protected void sendkey(WebElement element,String text)
    {
        element.sendKeys(text);
    }
    protected void clear(WebElement element)
    {
        element.clear();
    }

}
