package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.Home;
import pages.Login;

public class BaseTest {
    protected WebDriver driver;
    protected Home home;
    public Login login;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
        System.setProperty("web-driver.chrome.driver","src\\main\\resources\\chromedriver.exe");
        this.backToLogin();
        driver.manage().window().maximize();
    }


    @BeforeMethod
    public void backToLogin(){
        driver.get("https://www.saucedemo.com/");
        login = new Login(driver);
    }
    @AfterClass
    public void turnOff(){
        driver.quit();
    }


    }

