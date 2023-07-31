import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Home {

    private WebDriver driver;
    private By title = By.className("title");
    private By cart = By.className("shopping_cart_badge");
    private By cartLogoNumber = By.className("shopping_cart_badge");

    public Home(WebDriver driver){
        this.driver = driver;

    }
    public Product clickProduct(String product){
        driver.findElement(By.linkText(product)).click();
        return new Product(driver);

    }
    public String getTitle(){
        return driver.findElement(title).getText();

    }
    public Cart clickCart(){
        driver.findElement(cart).click();
        return new Cart(driver);
    }
    public void clickAddToCartFromHomeByIndex(int index){
        List<WebElement> buttons = driver.findElements(By.className("btn_small"));
        buttons.get(index).click();

    }
    public void clickRemoveFromHomeByIndex(int index){
        List<WebElement> buttons = driver.findElements((By.className("btn_small"));
        buttons.get(index).click();
    }
    public int countRemoveButtons(){
        List<WebElement> remove = driver.findElements(By.className("btn_secondary"));
        return remove.size();

    }
    public String getCartLogoNumber(){
        return driver.findElement(cartLogoNumber).getText();
    }
}
