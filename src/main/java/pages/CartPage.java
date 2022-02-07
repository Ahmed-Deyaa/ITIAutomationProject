package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private By placeOrderButton = By.cssSelector("div[class='col-lg-1'] button[class='btn btn-success']");
    private By purchaseButton = By.xpath("//div[@id='orderModal']//button[@class='btn btn-primary']");
    private By infoPopUpFooterIndicator =By.cssSelector("div[id='orderModal'] div[class='modal-footer']");
    private By infoPopUpFormIndicator =By.cssSelector("div[id='orderModal'] label[class='form-control-label']");
    private By successfulPurchasePopUpIndicator =By.xpath("//div[@class='sweet-alert  showSweetAlert visible']/div[@class='sa-icon sa-success animate']");
    private By successfulPurchasePopUpHeader =By.cssSelector("div[class='sweet-alert  showSweetAlert visible'] h2");
    private By infoPopUpNameField =By.id("name");
    private By infoPopUpCountryField =By.id("country");
    private By infoPopUpCityField =By.id("city");
    private By infoPopUpCreditCardField =By.id("card");
    private By infoPopUpMonthField =By.id("month");
    private By infoPopUpYearField =By.id("year");
    private By buyerInfoNameField = By.id("name");
    private By successfulPurchasePopUpOkButton= By.cssSelector("div[class='sa-confirm-button-container'] button");
    private By successfulPurchasePopUpOkIndicator= By.cssSelector("div[class='sa-button-container']");

    private void handleInfoPopUpWindow(By popUpIndicator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(popUpIndicator)));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(popUpIndicator)).perform();
    }
    private void handleSucessfulPurcasePopUp(By locator){
        WebDriverWait wait=new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public CartPage(WebDriver driver){this.driver=driver;}

    public String getAlertText(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(placeOrderButton));
        driver.findElement(placeOrderButton).click();
    }

    public void clickOnPurchase(){
        handleInfoPopUpWindow(infoPopUpFooterIndicator);
        driver.findElement(purchaseButton).click();
    }

    public void startFillingForm(){
        handleInfoPopUpWindow(infoPopUpFormIndicator);
    }

    public void enterName(String name){
        driver.findElement(infoPopUpNameField).sendKeys(name);
    }

    public void enterCard(String card){
        driver.findElement(infoPopUpCreditCardField).sendKeys(card);
    }

    public String validateSuccessfulPurchase(){
        handleSucessfulPurcasePopUp(successfulPurchasePopUpHeader);
        return driver.findElement(successfulPurchasePopUpHeader).getText();
    }
    public void finalisePurchase(){
        handleSucessfulPurcasePopUp(successfulPurchasePopUpOkButton);
        driver.findElement(successfulPurchasePopUpOkButton).click();
    }








}
