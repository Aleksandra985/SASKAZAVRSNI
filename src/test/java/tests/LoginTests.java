package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.Home;

public class LoginTests extends BaseTest {
    @Test
    public void standardUserLoginTest(){
        login.setUsername("standard_user");
        login.setPassword("secret_sauce");
        Home home = login.clickLoginButton();
        Assert.assertEquals(home.getTitle(), "Products", "Not expected");
    }
    @Test
    public void lockedUsedLoginTest() {
        login.setUsername("locked_out_user");
        login.setPassword("secret_sauce");
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Sorry, this user has been locked out.",
                "User is login successfully");
    }
    @Test
    public void problemUserLoginTest() {
        login.setUsername("problem_user");
        login.setPassword("secret_sauce");
        Home home = login.clickLoginButton();
        Assert.assertEquals(home.getTitle(), "Products", "Not expected");
    }
    @Test
    public void performanceGlitchUserLoginTest() {
        login.setUsername("performance_glitch_user");
        login.setPassword("secret_sauce");
        Home home = login.clickLoginButton();
        Assert.assertEquals(home.getTitle(), "Products", "Not expected");
    }
    @Test
    public void loginJustWithUsernameTest() {
        login.setUsername("standard_user");
        login.setPassword("");
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Password is required",
                "User is login successfully");
    }
    @Test
    public void loginJustWithPasswordTest() {
        login.setUsername("");
        login.setPassword("secret_sauce");
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }
    @Test
    public void loginWithWrongUsernameTest() {
        login.setUsername("Aleksandra085");
        login.setPassword("secret_sauce");
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }
    @Test
    public void LoginWithWrongPasswordTest() {
        login.setUsername("standard_user");
        login.setPassword("Aleksandra085");
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Username and password do not match any user in this service",
                "User is login successfully");
    }
    @Test
    public void loginWithoutUsernameandPasswordTest() {
        login.setUsername("");
        login.setPassword("");
        login.clickLoginButton();
        Assert.assertEquals(login.getErrorMessage(),
                "Epic sadface: Username is required",
                "User is login successfully");
    }


}
