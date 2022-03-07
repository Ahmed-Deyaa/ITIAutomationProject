package loginTestCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testSet.TestSet;

public class ValidLogin extends TestSet {

    String username = "Fleabag";
    String password = "108208";
    String welcomeMessage = "Welcome "+username;

    @Test
    public void testValidLogin(){
        homePage.login(username,password);
        String text = homePage.getWelcomeUserMessage();
        Assert.assertEquals(text,welcomeMessage,"The  user did not login");
        
    }
}
