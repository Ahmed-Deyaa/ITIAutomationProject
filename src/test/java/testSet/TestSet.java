package testSet;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utilities.WindowManager;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

public class TestSet {

    private WebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.demoblaze.com/");
        driver.manage().window().maximize();
        homePage =new HomePage(driver);
    }
    @BeforeMethod
    public void goHome(){
        driver.get("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var photo = ((TakesScreenshot) driver);
            File screenshot = photo.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshot/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        options.setHeadless(true);
        return options;
    }


    /*public static void  main(String []args){
        String quantity="2";
        double listPrice = 18.5;
        int quantityInt = Integer.parseInt(quantity);
        double totalPrice = quantityInt*listPrice;
        String totalString = Double.toString(totalPrice);
        String assertValue= "$"+totalString;
        System.out.println(assertValue);
    }*/
}
