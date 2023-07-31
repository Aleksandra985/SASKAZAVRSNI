package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductFromAddedProductTests extends BaseTest {
    @Test
    public void removeOneItemTest(){
        login.setUsername("standard_user");
        login.setPassword("secret_sauce");
        Home home = login.clickLoginButton();
        Product product = home.clickProduct("Sauce Labs Backpack");
        Assert.assertEquals(product.getProductName(), "Sauce Labs Backpack", "Not true product name");
        product.clickAddToCart();
        Cart cart = product.clickCart();
        cart.clickRemoveByIndex(0);
        Assert.assertEquals(cart.countItems(), 0, "Not expected number of items");
    }
    @Test
    public void removeSixItemsTest() {
        login.setUsername("standard_user");
        login.setPassword("secret_sauce");
        Home home = login.clickLoginButton();
        Product product = home.clickProduct("Sauce Labs Backpack");
        Assert.assertEquals(product.getProductName(), "Sauce Labs Backpack", "Not true product name");
        product.clickAddToCart();
        home = product.clickBackToProducts();
        product = home.clickProduct("Sauce Labs Bike Light");
        Assert.assertEquals(product.getProductName(), "Sauce Labs Bike Light", "Not true product name");
        product.clickAddToCart();
        home = product.clickBackToProducts();
        product = home.clickProduct("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(product.getProductName(), "Sauce Labs Bolt T-Shirt", "Not true product name");
        product.clickAddToCart();
        home = product.clickBackToProducts();
        product = home.clickProduct("Sauce Labs Fleece Jacket");
        Assert.assertEquals(product.getProductName(), "Sauce Labs Fleece Jacket", "Not true product name");
        product.clickAddToCart();
        home = product.clickBackToProducts();
        product = home.clickProduct("Sauce Labs Onesie");
        Assert.assertEquals(product.getProductName(), "Sauce Labs Onesie", "Not true product name");
        product.clickAddToCart();
        home = product.clickBackToProducts();
        product = home.clickProduct("Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(product.getProductName(), "Test.allTheThings() T-Shirt (Red)", "Not true product name");
        product.clickAddToCart();
        Cart cart = product.clickCart();
        cart.clickRemoveByIndex(5);
        cart.clickRemoveByIndex(4);
        cart.clickRemoveByIndex(3);
        cart.clickRemoveByIndex(2);
        cart.clickRemoveByIndex(1);
        cart.clickRemoveByIndex(0);
        Assert.assertEquals(cart.countItems(), 0, "Not true number of items");
    }
}
