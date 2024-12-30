package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class CategoriesPage extends Base {
    private final By categoriesHeader = By.linkText("CATEGORIES");
    private final By phonesCategory = By.linkText("Phones");
    private final By laptopsCategory = By.linkText("Laptops");
    private final By monitorsCategory = By.linkText("Monitors");
    private final By itemsContainer = By.id("tbodyid");
    private final By itemTitle = By.className("hrefch");

    // Constructor
    public CategoriesPage(WebDriver driver) {
        super(driver);
        //this.driver = driver;
    }

    // Methods
    public boolean isCategoriesHeaderDisplayed() {
        return driver.findElement(categoriesHeader).isDisplayed();
    }

    public void clickCategory(String category) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        switch (category) {
            case "Phones":
                wait.until(ExpectedConditions.elementToBeClickable(phonesCategory)).click();
                break;
            case "Laptops":
                wait.until(ExpectedConditions.elementToBeClickable(laptopsCategory)).click();
                break;
            case "Monitors":
                wait.until(ExpectedConditions.elementToBeClickable(monitorsCategory)).click();
                break;
        }
    }

    public List<WebElement> getCategoryItems() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(itemsContainer));
        return driver.findElement(itemsContainer).findElements(By.tagName("div"));
    }

    public List<String> getItemsTitle() {
        List<String> items = new ArrayList<>();
        List<WebElement> elements = driver.findElements(itemTitle);
        for(int i=0 ; i<elements.size() ; i++) {
            items.add(elements.get(i).getText());
        }

        return items;
    }

    public List<WebElement> getItemsElements() {
        return driver.findElements(itemTitle);
    }
}
