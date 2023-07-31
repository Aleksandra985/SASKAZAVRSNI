package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartFromProductTests extends BaseTest {
    @Test
    public void addOneItemTest(){
        login.setUsername("standard_user");
        login.setPassword("secret_sauce");
        Home home = login.clickLoginButton();
        Product product = home.clickProduct("Sauce Labs Backpack");
        Assert.assertEquals(product.getProductName(), "Sauce Labs Backpack", "Not true product name");
        product.clickAddToCart();
        Cart cart = product.clickCart();
        Assert.assertEquals(cart.countItems(), 1, "Not true number of items");

    }
    @Test
    public void addSixItemsTest(){
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
        product = home.clickProduct("Sauce Labs Nessie");
        Assert.assertEquals(product.getProductName(), "Sauce Labs Nessie", "Not true product name");
        product.clickAddToCart();
        home = product.clickBackToProducts();
        product = home.clickProduct("Test.allTheThings() T-Shirt (Red)");
        Assert.assertEquals(product.getProductName(), "Test.allTheThings() T-Shirt (Red)", "Not true product name");
        product.clickAddToCart();
        Cart cart = product.clickCart();
        Assert.assertEquals(cart.countItems(), 6, "Not true number of items");
    }
}
