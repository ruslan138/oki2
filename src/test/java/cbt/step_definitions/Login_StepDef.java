package cbt.step_definitions;

import cbt.pages.Login;
import cbt.utilities.BrowserUtilities;
import cbt.utilities.ConfigurationReader;
import cbt.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Login_StepDef {

    Login login = new Login();
    @When("Authorized user logged in")
    public void authorized_user_logged_in() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        BrowserUtilities.explicitWaitClick(Driver.getDriver(),5,"//input[@id='user_login']");

        login.username.sendKeys(ConfigurationReader.getProperty("username"));
           login.password.sendKeys(ConfigurationReader.getProperty("password"));

           login.submit.click();
           BrowserUtilities.explicitWaitClick(Driver.getDriver(),3, "//button[@id='primary-button']");
           login.errorMessage.click();
    }


    @When("invalid login and password is entered error message should occur")
    public void invalid_login_and_password_is_entered_error_message_should_occur() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

        BrowserUtilities.explicitWaitClick(Driver.getDriver(),5,"//input[@id='user_login']");

        login.username.sendKeys(ConfigurationReader.getProperty("WrongUserName"));
        login.password.sendKeys(ConfigurationReader.getProperty("password"));

        login.submit.click();


        WebElement wrong = Driver.getDriver().findElement(By.xpath("//div[@class='alert alert-error']"));
        Assert.assertTrue(wrong.isDisplayed());
    }



}
