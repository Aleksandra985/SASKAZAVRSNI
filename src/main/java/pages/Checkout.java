package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkout {
    private WebDriver driver;
    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");

    public Checkout(WebDriver driver){
        this.driver = driver;

    }
    public void setFirstName(String firstName){
        driver.findElement(firstNameField).sendKeys(firstName);
    }
    public void setLastName(String lastName){
        driver.findElement(lastNameField).sendKeys(lastName);
    }
    public void setPostalCode(String postalCode){
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }
    public Overview clickContinueButton(){
        driver.findElement(continueButton).click();
        return new Overview(driver);
    }
}
