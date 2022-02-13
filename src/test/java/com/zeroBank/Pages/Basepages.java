package com.zeroBank.Pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Basepages {

    public Basepages(){

        PageFactory.initElements(Driver.get(),this);

    }

    @FindBy(css = "#signin_button.signin")
    public WebElement signingButton;




}
