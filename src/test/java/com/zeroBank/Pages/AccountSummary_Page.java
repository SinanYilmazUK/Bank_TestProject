package com.zeroBank.Pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountSummary_Page extends Basepages{



    public WebElement setElement_on_AccountSummary_Page(String nameOfElement){

        String path = "//a[text()='"+nameOfElement+"']";

        WebElement Element = Driver.get().findElement(By.xpath(path));

        return Element;
    }


}
