package com.zeroBank.Pages;

import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Loginpage extends Basepages{

    @FindBy(name = "user_login")
    public WebElement username;

    @FindBy(name = "user_password")
    public WebElement password;

    @FindBy(xpath = "//input[@name='submit']")
    public WebElement signinBtnLogin;

    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        signinBtnLogin.click();
        BrowserUtils.waitFor(2);
    }


}
