package com.zeroBank.Pages;

import com.zeroBank.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class AccountActivity_Page extends Basepages{

    @FindBy(xpath = "//*[@name='accountId']")
    public WebElement dropDown;

    @FindBy(xpath = "//div//a[text()='Account Activity']")
    public WebElement title_accountActivity;








}
