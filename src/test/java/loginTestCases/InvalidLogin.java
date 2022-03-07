package loginTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testSet.TestSet;

public class InvalidLogin extends TestSet {



    @Test(priority = 1)
    public void testInvalidPasswordLogin(){
        String username = "Fleabag";
        String password = "10820";
        String errorLoginMessage = "Wrong password.";
        homePage.login(username,password);
        String text = homePage.getInvalidLoginMessage();
        homePage.clickOnCancel();
        Assert.assertEquals(text,errorLoginMessage,"Something went Wrong");
    }

    @Test (priority = 2)
    public void testInvalidUsernameLogin(){
        String username = "fleabag";
        String password = "108208";
        String errorLoginMessage = "User does not exist.";
        homePage.login(username,password);
        String text = homePage.getInvalidLoginMessage();
        homePage.clickOnCancel();
        Assert.assertEquals(text,errorLoginMessage,"Something went Wrong");
    }
    @Test (priority = 3)
    public void testEmptyFieldLogin(){
        String username = "";
        String password = "";
        String errorLoginMessage = "Please fill out Username and Password.";
        homePage.login(username,password);
        String text = homePage.getInvalidLoginMessage();
        Assert.assertEquals(text,errorLoginMessage,"Something went Wrong");
    }

}
