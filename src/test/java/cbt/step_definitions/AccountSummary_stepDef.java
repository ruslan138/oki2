package cbt.step_definitions;

import cbt.pages.AccountSummary;
import cbt.pages.Dashboard;
import cbt.pages.Login;
import cbt.utilities.BrowserUtilities;
import cbt.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountSummary_stepDef {

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    Dashboard dashboard = new Dashboard();
    Login login = new Login();
    AccountSummary accountSummary = new AccountSummary();

    @Then("user click on account Summary")
    public void user_click_on_account_summary()  {

        login.checkingAccount.click();


        dashboard.accountSummary.click();


    }

    @And("title should has {string}")
    public void titleShouldHas(String title) {


        BrowserUtilities.waitForVisibility(By.xpath("//h2[.='Cash Accounts']"),3);
        BrowserUtilities.AssertTitle(title);

    }

    @Then("following modules should be displayed")
    public void following_modules_should_be_displayed(List<String> modules) {

       List<String> actual=BrowserUtilities.getElementText(accountSummary.accSumModules);

        System.out.println(modules);
        System.out.println(actual);

        Assert.assertEquals(modules, actual);


    }


    @Then("Credit Accounts table must have columns")
    public void credit_accounts_table_must_have_columns(List<String> creditModule) {

      List<String> actual= BrowserUtilities.getElementText(accountSummary.creditAccounModules);
        System.out.println(creditModule);
        System.out.println(actual);
      Assert.assertEquals(actual, creditModule);
    }


    @Then("user click on brokerage and should be redirected")
    public void userClickOnBrokerageAndShouldBeRedirected() {
        accountSummary.brokerage.click();

    }

    @And("account droupdown should change to {string}")
    public void accountDroupdownShouldChangeTo(String expected)  {
        BrowserUtilities.selectedOption(expected);

    }


    @Then("user click on checking and should be redirected")
    public void userClickOnCheckingAndShouldBeRedirected() {
        accountSummary.checking.click();
    }

    @And("account dropdown should change to {string}")
    public void accountDropdownShouldChangeTo(String expected) {
        BrowserUtilities.selectedOption(expected);
    }


    @Then("user click on creditCard and should be redirected")
    public void userClickOnCreditCardAndShouldBeRedirected() {
        accountSummary.creditCard.click();
    }

    @Then("user click on loan and should be redirected")
    public void userClickOnLoanAndShouldBeRedirected() {
        accountSummary.loan.click();
    }
}