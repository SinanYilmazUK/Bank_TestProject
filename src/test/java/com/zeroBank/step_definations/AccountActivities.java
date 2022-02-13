package com.zeroBank.step_definations;
import com.zeroBank.Pages.AccountActivity_Page;
import com.zeroBank.Pages.AccountSummary_Page;
import com.zeroBank.Pages.Loginpage;
import com.zeroBank.utilities.BrowserUtils;
import com.zeroBank.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;


public class AccountActivities {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {

        Loginpage login = new Loginpage();

        login.signingButton.click();

        BrowserUtils.waitForVisibility(login.username,2);

        login.login(ConfigurationReader.get("username"),ConfigurationReader.get("password"));

        BrowserUtils.waitFor(2);

    }

    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String type) {

        AccountSummary_Page summary_page = new AccountSummary_Page();

        (summary_page.setElement_on_AccountSummary_Page(type)).click();

        BrowserUtils.waitFor(2);
    }

    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {

        AccountActivity_Page activity_page = new AccountActivity_Page();

        String actualTitle_accountActivity = activity_page.title_accountActivity.getText();

        String expectedTitle_accountActivity = "Account Activity";

        Assert.assertEquals("verify that user is not on Account Activity page", actualTitle_accountActivity,expectedTitle_accountActivity);

        BrowserUtils.waitFor(1);
    }



    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String ExpectedSelect) {

        AccountActivity_Page activity_page = new AccountActivity_Page();

        BrowserUtils.waitForVisibility(activity_page.dropDown,3);

        Select dropDown_ActivityPage = new Select(activity_page.dropDown);

        String ActualSelected = dropDown_ActivityPage.getFirstSelectedOption().getText();

        Assert.assertEquals("Verify that Selected type is not correct", ExpectedSelect,ActualSelected);

    }



}