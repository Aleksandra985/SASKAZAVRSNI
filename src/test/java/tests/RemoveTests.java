package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import utils.DataUtil;

import java.util.HashMap;

public class RemoveTests  extends BaseTest {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void removeFromHomeTest(HashMap<String, String> hashMap){
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        Home home = login.clickLoginButton();
        home.clickAddToCartFromHomeByIndex(0);
        Cart cart = home.clickCart();
        cart.clickRemoveByIndex(0);
        Assert.assertEquals(cart.countItems(), 0, "Not expected number");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider")
    public void removeSixItemsFromHomeTest(HashMap<String, String> hashMap){
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        Home home = login.clickLoginButton();
        home.clickAddToCartFromHomeByIndex(0);
        home.clickAddToCartFromHomeByIndex(1);
        home.clickAddToCartFromHomeByIndex(2);
        home.clickAddToCartFromHomeByIndex(3);
        home.clickAddToCartFromHomeByIndex(4);
        home.clickAddToCartFromHomeByIndex(5);
        Cart cart = home.clickCart();
        cart.clickRemoveByIndex(5);
        cart.clickRemoveByIndex(4);
        cart.clickRemoveByIndex(3);
        cart.clickRemoveByIndex(2);
        cart.clickRemoveByIndex(1);
        cart.clickRemoveByIndex(0);
        Assert.assertEquals(cart.countItems(), 0, "Not expected number");
    }
}
