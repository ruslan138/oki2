package cbt.step_definitions;

import cbt.pages.AccountActivity;
import cbt.pages.Dashboard;
import cbt.pages.Login;
import cbt.pages.PayBills;
import cbt.utilities.BrowserUtilities;
import cbt.utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PayBills_stepDef {

    Dashboard dashboard = new Dashboard();
    Login login = new Login();
    AccountActivity accountActivity = new AccountActivity();
    PayBills payBills =new PayBills();

    @Then("click on Pay Bills")
    public void click_on_pay_bills() {


       dashboard.payBills.click();
    }

    @Then("title is should change to {string}")
    public void title_is_should_change_to(String expected) {

        System.out.println(expected);
        System.out.println(Driver.getDriver().getTitle());
        BrowserUtilities.AssertTitle(expected);
    }



    @And("fill out all form succesful notification should displayed {string}")
    public void     fillOutAllFormSuccesfulNotificationShouldDisplayed(String expected) {
        Faker faker = new Faker();
        payBills.amountInpAybillPage.sendKeys(faker.number().digits(2));
        payBills.date.click();
        payBills.chooseDate.click();
        payBills.description.sendKeys(faker.howIMetYourMother().catchPhrase());
        payBills.pay.click();

        Assert.assertEquals(payBills.succsedTransaction.getText(), expected);
    }



}
