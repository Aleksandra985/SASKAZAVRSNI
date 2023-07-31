package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Checkout;
import pages.Home;
import pages.Overview;
import utils.DataUtil;

import java.util.HashMap;

public class FinalePriceTests extends BaseTest {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider1")
    public void getItemTotalTest(HashMap<String, String> hashMap) {
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        Home home = login.clickLoginButton();
        home.clickAddToCartFromHomeByIndex(0);
        Cart cart = home.clickCart();
        Assert.assertEquals(cart.countItems(), 1, "Not expected number");
        Checkout checkout = cart.clickCheckoutButton();
        checkout.setFirstName("Aleksandra");
        checkout.setLastName("Zivadinovic");
        checkout.setPostalCode("11000");
        Overview overview = checkout.clickContinueButton();
        Assert.assertEquals(overview.getItemTotal(), "Item total: $29.99", "Not expected price");

    }
}
