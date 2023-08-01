package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Cart;
import pages.Home;
import utils.DataUtil;

import java.util.Base64;
import java.util.HashMap;

public class AddToCartTests extends BaseTest {
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider1")
    public void addOneItemTest(HashMap<String, String> hashMap) {
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        Home home = login.clickLoginButton();
        home.clickAddToCartFromHomeByIndex(0);
        Cart cart = home.clickCart();
        Assert.assertEquals(cart.countItems(), 1, "Not true number of items");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider1")
    public void addSixItemsTest(HashMap<String, String>hashMap) {
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
        Assert.assertEquals(cart.countItems(), 6, "Not expected number of items");
    }
}
