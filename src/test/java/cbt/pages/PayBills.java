package cbt.pages;

import cbt.utilities.BrowserUtilities;
import cbt.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBills {
    public PayBills(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "pc_amount")
    public WebElement amount;

    @FindBy(id = "sp_amount")
    public WebElement amountInpAybillPage;

    @FindBy(id = "sp_date")
    public WebElement date;

    @FindBy(xpath = "//td[.='6']")
    public WebElement chooseDate;

    @FindBy(id = "sp_description")
    public WebElement description;

    @FindBy(xpath ="//input[@type='submit']")
    public WebElement pay;

    @FindBy(id = "alert_content")
    public WebElement succsedTransaction;

    @FindBy(xpath = "//a[.='Pay Saved Payee']")
    public WebElement paySavedPayee;

    @FindBy(xpath = "//a[.='Add New Payee']")
    public WebElement newPayee;

    @FindBy(xpath = "//a[.='Purchase Foreign Currency']")
    public WebElement purchaseForeign;

    @FindBy(id = "np_new_payee_name")
    public WebElement payerrNAme;

    @FindBy(id = "np_new_payee_address")
    public WebElement payerAdress;

    @FindBy(id = "np_new_payee_account")
    public WebElement payeeAccount;

    @FindBy(id = "np_new_payee_details")
    public WebElement payeeeDetails;

    @FindBy(id = "add_new_payee")
    public WebElement addnewPayee;

    @FindBy(id = "pc_currency")
    public WebElement currency;

    @FindBy(id = "pc_amount")
    public WebElement currencyAmmount;

    @FindBy(id = "pc_inDollars_true")
    public WebElement dollars;

    @FindBy(id = "pc_inDollars_false")
    public WebElement selectedCurrency;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCost;

    @FindBy(id = "purchase_cash")
    public WebElement purchaseButton;

    @FindBy(id = "alert_content")
    public WebElement succesAlertForeign;

    @FindBy(id = "pc_conversion_amount")
    public WebElement convertedAmountDisplay;


    public static void allCurency(List<String> expected){

        Select select = new Select(Driver.getDriver().findElement(By.id("pc_currency")));

        List<WebElement> all = select.getOptions();

       List<String> actual= BrowserUtilities.getElementText(all);
        actual.remove(0);

        Assert.assertTrue(actual.contains(expected));
    }





}
