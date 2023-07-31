import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Overview {
    private WebDriver driver;
    private By itemTotal = By.className("summary_subtotal_label");
    private By finishButton = By.id("finish");

    public Overview(WebDriver driver){
        this.driver = driver;

    }
    public String getItemTotal() {
        return driver.findElement(itemTotal).getText();

    }
    public CompleteCheckout clickFinish(){
        driver.findElement(finishButton).click();
        return new CompleteCheckout(driver);
    }
}
