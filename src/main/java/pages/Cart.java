package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart {
    private WebDriver driver;
    private By remove = By.className("btn_small");
    private By checkout = By.id("checkout");
    private By pageName = By.className("title");

    public Cart(WebDriver driver){
        this.driver = driver;

    }
    public int countItems(){
        return  driver.findElements(remove).size();

    }
    public void clickRemoveByIndex(int index){
        List<WebElement> button = driver.findElements(remove);
        button.get(index).click();

    }
    public Checkout clickCheckoutButton(){
        driver.findElement(checkout).click();
        return new Checkout(driver);

    }
}
