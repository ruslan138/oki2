package cbt.pages;

import cbt.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummary {
    public AccountSummary() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//h2")
    public List<WebElement> accSumModules;

    @FindBy(xpath = "(//thead)[3]//th")
    public List<WebElement> creditAccounModules;

    @FindBy(xpath = "//a[.='Brokerage']")
    public WebElement brokerage;

    @FindBy(xpath = "//a[.='Checking']")
    public WebElement checking;

    @FindBy(xpath = "//a[.='Credit Card']")
    public WebElement creditCard;

    @FindBy(xpath = "//a[.='Loan']")
    public WebElement loan;




}
