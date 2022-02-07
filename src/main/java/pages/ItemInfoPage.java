package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ItemInfoPage {

    private WebDriver driver;
    private By addToCartButton = By.xpath("//a[@onclick='addToCart(1)']");
    private By cartButton = By.id("cartur");

    public ItemInfoPage(WebDriver driver){this.driver=driver;}

    public void acceptAlert(){
        driver.switchTo().alert().accept();

    }

    public String getAlertText(){
        return driver.switchTo().alert().getText();
    }

    public void ignoreAlert(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ESCAPE).build().perform();
    }

    public void addItemToCart(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(addToCartButton)).perform();
        driver.findElement(addToCartButton).click();
        wait.until(ExpectedConditions.alertIsPresent());
        acceptAlert();
    }
    public CartPage goToCart(){
        driver.findElement(cartButton).click();
        return new CartPage(driver);
    }
}
