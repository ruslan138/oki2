package cbt.pages;

import cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

    public Dashboard(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//li[@id='homeMenu']")
    public WebElement homeButton;

    @FindBy(xpath = "//li[@id='onlineBankingMenu']")
    public WebElement onlineBanking;

    @FindBy(xpath = "//li[@id='feedback']")
    public WebElement feedbackButton;

    @FindBy(xpath = "//a[.='Account Summary']")
    public WebElement accountSummary;

    @FindBy(xpath = "//a[.='Account Activity']")
    public WebElement accountActivity;

    @FindBy(xpath = "//a[.='Transfer Funds']")
    public WebElement transferFunds;

    @FindBy(xpath = "//a[.='Pay Bills']")
    public WebElement payBills;

    @FindBy(xpath = "//a[.='My Money Map']")
    public WebElement myMoneyMap;

    @FindBy(xpath = "//a[.='Online Statements']")
    public WebElement onlineStatement;



}
