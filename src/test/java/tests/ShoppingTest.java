package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.DataUtil;

import java.util.HashMap;

public class ShoppingTest extends BaseTest{
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider1")
    public void shoppingTest(HashMap<String, String> hashMap){
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        Home home = login.clickLoginButton();
        home.clickAddToCartFromHomeByIndex(0);
        Cart cart = home.clickCart();
        Assert.assertEquals(cart.countItems(), 1, "Not expected number");
        Checkout checkout = cart.clickCheckoutButton();
        checkout.setFirstName(hashMap.get("firstName"));
        checkout.setLastName(hashMap.get("lastName"));
        checkout.setPostalCode(hashMap.get("postalCode"));
        Overview overview = checkout.clickContinueButton();
        Assert.assertEquals(overview.getItemTotal(), "Item total: $29.99", "Not expected price");
        CompleteCheckout completeCheckout = overview.clickFinish();
        Assert.assertEquals(completeCheckout.getFinishShoppingText(),
                "Thank you for your order!",
                "Not expected text");
    }
}
