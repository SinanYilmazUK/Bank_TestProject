package com.zeroBank.step_definations;

import com.zeroBank.Pages.AccountActivity_Page;
import com.zeroBank.Pages.FindTransaction;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.TreeSet;

public class FindTransaction_steps {

    FindTransaction findTransaction = new FindTransaction();

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {

        AccountActivity_Page activity_page = new AccountActivity_Page();
        BrowserUtils.waitFor(1);
        activity_page.title_accountActivity.click();
        BrowserUtils.waitFor(1);
        findTransaction.FindTransaction.click();


    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        BrowserUtils.waitFor(1);

        findTransaction.fromDate.clear();
        findTransaction.toDate.clear();

        findTransaction.fromDate.sendKeys(fromDate);
        findTransaction.toDate.sendKeys(toDate);

    }

    @When("clicks search")
    public void clicks_search() {

        BrowserUtils.waitFor(1);
        findTransaction.searchButton.click();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {

        BrowserUtils.waitFor(1);
        List<String> dates = findTransaction.find_Dates();

        for (String date : dates) {

            Assert.assertTrue("verify "+date+" order", date.compareTo(fromDate)>=0 && date.compareTo(toDate)<=0);

        }


    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        List<String> dates = findTransaction.find_Dates();

        TreeSet<String> sortedDates = new TreeSet<>();
        sortedDates.descendingSet();

        int i=0;
        for (String sortedDate : sortedDates ) {

            Assert.assertEquals("verify that "+dates.get(i)+"is not sorted",sortedDate,dates.get(i));
            i++;
        }
        

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

        List<String> dates = findTransaction.find_Dates();

        System.out.println("dates = " + dates.toString());

        Assert.assertFalse("Verify that dates are not filtered properly",dates.contains("2012-09-01"));

    }
    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {

        BrowserUtils.waitFor(1);

        findTransaction.descriptionText.clear();

        findTransaction.descriptionText.sendKeys(string);

    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {

        BrowserUtils.waitFor(1);

        List<String> descriptionList = findTransaction.Description();

        System.out.println("descriptionList.toString() = " + descriptionList.toString());

        for (String each : descriptionList) {

            Assert.assertTrue("Verify description type for "+string, each.contains(string));
        }

    }
    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {

        List<String> descriptionList = findTransaction.Description();

        for (String each : descriptionList) {

            Assert.assertFalse("Verify that description", each.contains(string));
        }
    }

    @When("user selects type {string}")
    public void user_selects_type(String typeValue) {

        Select select = new Select(findTransaction.type);
        select.selectByVisibleText(typeValue);
        BrowserUtils.waitFor(1);
        findTransaction.searchButton.click();

    }
    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String requiedType) {

        List<String> types = BrowserUtils.getElementsText(findTransaction.transactionHeadValues);

        int indexOfRequiedType = types.indexOf(requiedType)+1;

        String path = "(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td["+indexOfRequiedType+"]";

        BrowserUtils.waitFor(1);

        List<String> contents = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath(path)));

        contents.removeIf(n -> (n.length()==0));

        Assert.assertFalse("Verify content amount",contents.isEmpty());


        }
    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String requiedType) {

        List<String> types = BrowserUtils.getElementsText(findTransaction.transactionHeadValues);

        int indexOfRequiedType = types.indexOf(requiedType)+1;

        String path = "(//table[@class='table table-condensed table-hover'])[2]/tbody/tr/td["+indexOfRequiedType+"]";

        BrowserUtils.waitFor(1);

        List<String> contents = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath(path)));

        contents.removeIf(n -> (n.length()==0));

        Assert.assertTrue("Verify content amount",contents.isEmpty());



        }
    }
