package pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;
    private By loginButtonHomePage = By.id("login2");
    private By loginPopUpIndicator = By.cssSelector("div[id='logInModal'] div[class='modal-body']");
    private By usernameField = By.id("loginusername");
    private By passwordField = By.id("loginpassword");
    private By loginButtonSubmit = By.cssSelector("button[onclick='logIn()']");
    private By phonesButton = By.xpath("//a[@onclick=\"byCat('phone')\"]");
    private By labtopsButton = By.xpath("//a[@onclick=\"byCat('notebook')\"]");
    private By monitorsButton = By.xpath("//a[@onclick=\"byCat('monitor')\"]");
    private By purchaseItem = By.xpath("(//div[@class='card-block']//a)[1]");



    private void handleFormPopUpWindow(By popUpIndicator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(popUpIndicator)));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(popUpIndicator)).click();
    }

    private void handlePageStaleness(By locator){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(locator))));
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(locator)).perform();
    }

    private void clickOnLogin() {
        driver.findElement(loginButtonHomePage).click();
        handleFormPopUpWindow(loginPopUpIndicator);
    }

    private void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    private void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    private void submitLoginIngo() {
        driver.findElement(loginButtonSubmit).click();
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        clickOnLogin();
        enterUsername(username);
        enterPassword(password);
        submitLoginIngo();
    }

    public void browsePhones(){
        handlePageStaleness(phonesButton);
        driver.findElement(phonesButton).click();
    }

    public void browseLabtops() {
        handlePageStaleness(labtopsButton);
        driver.findElement(labtopsButton).click();
    }

    public void browseMonitors(){

        handlePageStaleness(monitorsButton);
        driver.findElement(monitorsButton).click();
    }

    public ItemInfoPage chooseItem(){
        handlePageStaleness(purchaseItem);
        driver.findElement(purchaseItem).click();
        return new ItemInfoPage(driver);
    }
}
