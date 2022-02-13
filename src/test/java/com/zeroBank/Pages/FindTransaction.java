package com.zeroBank.Pages;

import com.zeroBank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.logging.XMLFormatter;

public class FindTransaction extends Basepages {

    @FindBy(linkText = "Find Transactions")
    public WebElement FindTransaction;

    @FindBy(css = "#aa_description")
    public WebElement descriptionText;

    @FindBy(css = "#aa_fromDate")
    public WebElement fromDate;

    @FindBy(css = "#aa_toDate")
    public WebElement toDate;

    @FindBy(css = "#aa_fromAmount")
    public WebElement fromAmount;

    @FindBy(css = "#aa_toAmount")
    public WebElement toAmount;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "(//table[@class='table table-condensed table-hover'])[2]/tbody/tr")
    public List<WebElement> transactionTables;

    @FindBy(id = "aa_type")
    public WebElement type;

    @FindBy(xpath ="//table[@class='table table-condensed table-hover']/thead//th")
    public List<WebElement> transactionHeadValues;


    public List<String> find_Dates() {

        int iter = transactionTables.size();

        List<String> dates = new ArrayList<>();

        for (int i = 1; i <= iter; i++) {

            String path = "//div[starts-with(@id,'filtered')]//tbody/tr[" + i + "]/td[1]";

            WebElement datefromtable = Driver.get().findElement(By.xpath(path));

            dates.add(datefromtable.getText());

        }

        return dates;

    }

    public List<String> Description() {

        int iter = transactionTables.size();

        List<String> descriptions = new ArrayList<>();

        for (int i = 1; i <= iter; i++) {

            String path = "//div[starts-with(@id,'filtered')]//tbody/tr[" + i + "]/td[2]";

            WebElement type = Driver.get().findElement(By.xpath(path));

            descriptions.add(type.getText());

        }

        return descriptions;
    }

}
