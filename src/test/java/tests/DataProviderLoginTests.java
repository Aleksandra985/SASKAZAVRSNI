package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home;
import utils.DataUtil;

import java.util.HashMap;

public class DataProviderLoginTests extends BaseTest {
    @Test(dataProviderClass = DataUtil.class, dataProvider =  "dataProvider1")
    public void standardUserLogInTest(HashMap<String, String>hashMap) {
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        Home home = login.clickLoginButton();
        Assert.assertEquals(home.getTitle(), "Products", "Not expected");

    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider2")
    public void lockedUsedLoginTest(HashMap<String, String> hashMap) {
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "pages.Login is successfully");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider3")
    public void problemUserLoginTest(HashMap<String, String> hashMap) {
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        Home home = login.clickLoginButton();
        Assert.assertEquals(home.getTitle(), "Products", "Not expected");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider4")
    public void performanceGlitchUserLoginTest(HashMap<String, String> hashMap) {
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        Home home = login.clickLoginButton();
        Assert.assertEquals(home.getTitle(), "Products", "Not expected");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider5")
    public void loginJustWithUsernameTest(HashMap<String, String > hashMap) {
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Password is required",
                "User is login successfully");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider6")
    public void loginJustWithPasswordTest(HashMap<String, String > hashMap) {
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider7")
    public void loginWithWrongUsernameTest(HashMap<String, String> hashMap){
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "Not expected message");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider8")
    public void LoginWithWrongPasswordTest(HashMap<String, String > hashMap) {
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }
    @Test(dataProviderClass = DataUtil.class, dataProvider = "dataProvider9")
    public void loginWithoutUsernameandPasswordTest(HashMap<String, String > hashMap) {
        login.setUsername(hashMap.get("username"));
        login.setPassword(hashMap.get("password"));
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }


}
