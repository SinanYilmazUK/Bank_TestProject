package com.zeroBank.step_definations;

import com.zeroBank.Pages.AccountActivity_Page;
import com.zeroBank.Pages.FindTransaction;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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

}
