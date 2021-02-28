package cbt.pages;

import cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public Login(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement username;

    @FindBy(id = "user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(id = "primary-button")
    public WebElement errorMessage;

    @FindBy(xpath = "//span[@id='account_activity_link']")
    public WebElement checkingAccount;

    @FindBy(id = "transfer_funds_link")
    public WebElement transferFunds;

    @FindBy(id = "money_map_link")
    public WebElement moneyMap;
}
