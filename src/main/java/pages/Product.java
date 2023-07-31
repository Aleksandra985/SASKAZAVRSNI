package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Product {
    private WebDriver driver;
    private By addToCartButton = By.className("btn_primary");
    private By backToProducts = By.id("back-to-products");
    private By cart = By.className("inventory_details_name");
    private By productName = By.className("inventory_details_name");

    public Product(WebDriver driver){
        this.driver = driver;

    }
    public void clickAddToCart(){
        driver.findElement(addToCartButton).click();

    }
    public Home clickBackToProductsButton(){
        driver.findElement(backToProducts).click();
        return new Home(driver);

    }
    public Cart clickCart(){
        driver.findElement(cart).click();
        return new Cart(driver);

    }
    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public Home clickBackToProducts(){
        driver.findElement(By.id("back-to-products"));
        return new Home(driver);
    }


}
