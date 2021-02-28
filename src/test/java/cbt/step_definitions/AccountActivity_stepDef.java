package cbt.step_definitions;

import cbt.pages.*;
import cbt.utilities.BrowserUtilities;
import cbt.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.NoSuchElementException;

public class AccountActivity_stepDef {

    Dashboard dashboard = new Dashboard();
    Login login = new Login();
    AccountActivity accountActivity = new AccountActivity();
    PayBills payBills =new PayBills();
    @Then("user click on checking account Summary")
    public void user_click_on_checking_account_summary(){
        login.checkingAccount.click();
    }

    @Then("title is changes to {string}")
    public void title_is_changes_to(String expected) {

        System.out.println(expected);
        System.out.println(Driver.getDriver().getTitle());
        BrowserUtilities.AssertTitle(expected);
    }



    @Then("default options on Account column Should be {string}")
    public void defaultOptionsOnAccountColumnShouldBe(String expected) {
     BrowserUtilities.explicitWaitVisibility(Driver.getDriver(),3,"//select[@id='aa_accountId']");
        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='aa_accountId']")));


     String actual=select.getFirstSelectedOption().getText();

        Assert.assertTrue(actual.equals(expected));



    }

    @Then("accountDropdown should have following options")
    public void account_dropdown_should_have_following_options(List<String> expectedColumnt) {

        Select select = new Select(Driver.getDriver().findElement(By.xpath("//select[@id='aa_accountId']")));
        List<WebElement> actualAll =  select.getOptions();

       List<String> actual= BrowserUtilities.getElementText(actualAll);

        System.out.println(actual);
        System.out.println(expectedColumnt);
        Assert.assertEquals(actual, expectedColumnt);
    }


    @And("Transactions table should have column names")
    public void transactionsTableShouldHaveColumnNames(List<String> expected) {

        BrowserUtilities.explicitWaitVisibility(Driver.getDriver(),3,"//thead//th");
      List<WebElement> actualColumns= Driver.getDriver().findElements(By.xpath("//thead//th"));
     List<String> actual= BrowserUtilities.getElementText(actualColumns);

        Assert.assertEquals(actual, expected);
    }





    @When("user Click on findTransaction")
    public void user_click_on_find_transaction() {
        accountActivity.findTranscation.click();
        BrowserUtilities.explicitWaitVisibility(Driver.getDriver(),3,"//input[@id='aa_description']");
    }

    @Then("results table should only show descriptions containing {string} and click search")
    public void results_table_should_only_show_descriptions_containing_and_click_search(String string) {
 accountActivity.descriptin.sendKeys(string);
 accountActivity.findButton.click();

 BrowserUtilities.explicitWaitVisibility(Driver.getDriver(),3,"(//tbody)[2]//tr//td[2]");
 AccountActivity.containsTransactin(string);

    }




    @Then("results table should only show descriptions containing {string} and click, search description should contain given word")
    public void resultsTableShouldOnlyShowDescriptionsContainingAndClickSearchDescriptionShouldContainGivenWord(String string) {
        accountActivity.descriptin.sendKeys(string);
        accountActivity.findButton.click();

        BrowserUtilities.explicitWaitVisibility(Driver.getDriver(),3,"(//tbody)[2]//tr//td[2]");
        AccountActivity.containsTransactin(string);
    }

    @Then("results table should only show descriptions containing {string} search description should contain given word")
    public void resultsTableShouldOnlyShowDescriptionsContainingSearchDescriptionShouldContainGivenWord(String string) {
       accountActivity.descriptin.clear();
        accountActivity.descriptin.sendKeys(string);
        accountActivity.findButton.click();

        BrowserUtilities.explicitWaitVisibility(Driver.getDriver(),3,"(//tbody)[2]//tr//td[2]");
        AccountActivity.containsTransactin(string);
    }

    @When("the user enters description {string} and confrims that given word not displayed")
    public void theUserEntersDescriptionAndConfrimsThatGivenWordNotDisplayed(String string) {
        accountActivity.descriptin.clear();
        accountActivity.descriptin.sendKeys(string);
        accountActivity.findButton.click();

        BrowserUtilities.explicitWaitVisibility(Driver.getDriver(),3,"//div[@class='well']");
       try {
           AccountActivity.doesntcontainsTransactin(string);
       }catch (NoSuchElementException e){

       }
    }




    @Then("then under Type module he  selecting type {string} and results table should show at least one result under Deposit")
    public void thenUnderTypeModuleHeSelectingTypeAndResultsTableShouldShowAtLeastOneResultUnderDeposit(String arg0) {
        AccountActivity.selectTypeinFindTransaction(arg0);
        accountActivity.findButton.click();
        //AccountActivity.containsTransactin(arg0);
        AccountActivity.transactionExcsitst();
    }


    @Then("then under Type module he  selecting typee {string} and results table should show at least one result under Widhrawal")
    public void thenUnderTypeModuleHeSelectingTypeeAndResultsTableShouldShowAtLeastOneResultUnderWidhrawal(String arg0) {
        AccountActivity.selectTypeinFindTransaction(arg0);
        accountActivity.findButton.click();
        //AccountActivity.containsTransactin(arg0);
        AccountActivity.transactionExcsitst();
    }

    @Then("click on Pay Bills and go to new payee")
    public void clickOnPayBillsAndGoToNewPayee() throws InterruptedException {
        Thread.sleep(3000);
        dashboard.payBills.click();
        payBills.newPayee.click();
    }





    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String arg0) {
        WebElement ok = Driver.getDriver().findElement(By.id("alert_container"));
        String dd = ok.getText();
        System.out.println(dd);
        Assert.assertTrue(dd.contains(arg0));
    }


    @And("creates new payee using following information {string} ,{string} , {string} , {string}")
    public void createsNewPayeeUsingFollowingInformation(String name, String adress, String account, String details) throws InterruptedException {
        BrowserUtilities.explicitWaitVisibility(Driver.getDriver(),3,"//input[@id='np_new_payee_name']");
        payBills.payerrNAme.sendKeys(name);
        payBills.payerAdress.sendKeys(adress);
        payBills.payeeAccount.sendKeys(account);
        payBills.payeeeDetails.sendKeys(details,Keys.ENTER);
        alertTexT(name);



    }

    public static void alertTexT(String given){
       WebElement actualT= Driver.getDriver().findElement(By.id("alert_content"));
       String actual =actualT.getText();
        Assert.assertTrue(actual.contains(given));
    }

    @Then("click on Pay Bills and go purchuase new currency")
    public void click_on_pay_bills_and_go_purchuase_new_currency() {
     dashboard.payBills.click();
        BrowserUtilities.explicitWaitVisibility(Driver.getDriver(),3,"//a[.='Purchase Foreign Currency']");
       payBills.purchaseForeign.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expected){

        Select select = new Select(Driver.getDriver().findElement(By.id("pc_currency")));

        List<WebElement> all = select.getOptions();

        List<String> actual= BrowserUtilities.getElementText(all);


        actual.remove(0);


        System.out.println(actual);

        Assert.assertTrue(expected.equals(actual));

    }


    @When("user tries to calculate cost without selecting a currency eror message should be displayed")
    public void userTriesToCalculateCostWithoutSelectingACurrencyErorMessageShouldBeDisplayed() {

        payBills.amount.sendKeys("333");
        payBills.calculateCost.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }

    @Then("user tries to calculate cost without entering a value , error message should be displayed")
    public void userTriesToCalculateCostWithoutEnteringAValueErrorMessageShouldBeDisplayed() {
        payBills.calculateCost.click();
        Alert alert =Driver.getDriver().switchTo().alert();
        alert.accept();
    }



    @When("the user enters date range from {string} to {string} click search")
    public void the_user_enters_date_range_from_to_click_search(String from, String to) throws InterruptedException {
       AccountActivity.fromTo(from,to);
       accountActivity.findButton.click();
       WebElement actual = Driver.getDriver().findElement(By.xpath("(//tbody//tr//td)[5]"));
        System.out.println(actual.getText());
        System.out.println(actual.getAttribute("(//tbody//tr//td)[5]"));

       Thread.sleep(3000);


    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
