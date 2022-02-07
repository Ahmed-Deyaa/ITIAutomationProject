package purchase;

import org.testng.Assert;
import org.testng.annotations.Test;
import testset.TestSet;

public class ValidPurchase extends TestSet {

    String username = "Fleabag";
    String password = "108208";
    String card = "Visa";
    String name = "Fleabag";
    String invalidPurchaseMessage="Please fill out Name and Creditcard.";
    String validPurchaseMessage="Thank you for your purchase!";

    @Test
    public void testValidPurchase(){

        homePage.login(username,password);
        homePage.browsePhones();
        var infoPage = homePage.chooseItem();
        infoPage.addItemToCart();
        var cart = infoPage.goToCart();
        cart.clickPlaceOrder();
        cart.startFillingForm();
        cart.enterName(name);
        cart.enterCard(card);
        cart.clickOnPurchase();
        String text = cart.validateSuccessfulPurchase();
        cart.finalisePurchase();
        Assert.assertEquals(text,validPurchaseMessage,"Purchase was not finalised");
        System.out.println("Purchase confirmed, Test Case 'testValidLogin' passed");

    }



}
