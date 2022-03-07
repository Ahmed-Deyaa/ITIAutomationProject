package purchaseTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testSet.TestSet;

public class InvalidPurchase extends TestSet {

    String username = "Fleabag";
    String password = "108208";
    String card = "Visa";
    String name = "Fleabag";
    String invalidPurchaseMessage="Please fill out Name and Creditcard.";
    String validPurchaseMessage="Thank you for your purchase!";

    @Test
    public void testInvalidPurchase(){

        homePage.login(username,password);
        homePage.browsePhones();
        var infoPage = homePage.chooseItem();
        infoPage.addItemToCart();
        var cart = infoPage.goToCart();
        cart.clickPlaceOrder();
        cart.clickOnPurchase();
        String text = cart.getAlertText();
        Assert.assertEquals(text,invalidPurchaseMessage,"Order did not go through");
        //System.out.println("Purchase did not happen, Test Case 'testInvalidLogin' passed");
    }

}
