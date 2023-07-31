package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompleteCheckout {
    private WebDriver driver;
    private By backHomeButton = By.id("back-to-product");
    private By finishText = By.className("complete-header");

    public CompleteCheckout(WebDriver driver){
        this.driver = driver;

    }
    public Home clickBackHome(){
        driver.findElement(backHomeButton).click();
        return new Home(driver);

    }
    public String getFinishShoppingText(){
        return driver.findElement(finishText).getText();

    }
}
