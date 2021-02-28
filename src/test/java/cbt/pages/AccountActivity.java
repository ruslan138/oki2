package cbt.pages;

import cbt.utilities.Driver;
import io.cucumber.java.en_old.Ac;
import io.cucumber.java.sl.In;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class AccountActivity {
    public AccountActivity(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement accountDropdown;

    @FindBy(id = "aa_accountId")
    public List<WebElement> allAccountDropdown;

    @FindBy(xpath = "(//thead)//th")
    public List<WebElement> accountColumns;

    @FindBy(xpath = "//a[.='Find Transactions']")
    public WebElement findTranscation;

    @FindBy(xpath = "//a[.='Show Transactions']")
    public WebElement showTranscations;
    @FindBy(id = "aa_description")
    public WebElement descriptin;

    @FindBy(id = "aa_fromDate")
    public WebElement fromDate;

    @FindBy(id = "aa_toDate")
    public WebElement toDate;

    @FindBy(xpath = "//button[.='Find']")
    public WebElement findButton;

    @FindBy(xpath = "(//tbody)[2]//tr//td[2]")
    public static List<WebElement> transactionDetails;



    public static void fromTo(String from , String to){
        AccountActivity accountActivity = new AccountActivity();
        accountActivity.fromDate.sendKeys(from, Keys.ENTER);
        accountActivity.toDate.sendKeys(to,Keys.ENTER);
        accountActivity.findButton.click();
    }


    public  static void rangeOfTransaction(String from,String to,String actual) {
        from= from.replaceAll("-","");
     int year= Integer.parseInt(from.substring(0,4));
     int months = Integer.parseInt(from.substring(4,6));
     int day = Integer.parseInt(from.substring(6,8));

        LocalDate fromDate = LocalDate.of(year,months,day);


        to= to.replaceAll("-","");
        int year2= Integer.parseInt(to.substring(0,4));
        int months2 = Integer.parseInt(to.substring(4,6));
        int day2 = Integer.parseInt(to.substring(6,8));

        LocalDate toDate = LocalDate.of(year2,months2,day2);



        to= to.replaceAll("-","");
        int year3= Integer.parseInt(actual.substring(0,4));
        int months3 = Integer.parseInt(actual.substring(4,6));
        int day3 = Integer.parseInt(actual.substring(6,8));

        LocalDate actualDate = LocalDate.of(year3,months3,day3);
        Assert.assertTrue(actualDate.isAfter(fromDate));
        Assert.assertTrue(toDate.isAfter(actualDate));


    }

    public static void containsTransactin(String str){

        String ok="";
        for (WebElement eachDetail : transactionDetails) {
            System.out.println(eachDetail);

          ok=eachDetail.getText();


        }

        Assert.assertTrue(ok.startsWith(str));
    }

    public static void doesntcontainsTransactin(String str){

        String ok="";
        for (WebElement eachDetail : transactionDetails) {
            System.out.println(eachDetail);

            ok=eachDetail.getText();


        }

        Assert.assertTrue(!ok.contains(str));
    }

    public static void selectTypeinFindTransaction(String type){
        Select select = new Select(Driver.getDriver().findElement(By.id("aa_type")));
        select.selectByVisibleText(type);

    }

    public static  void transactionExcsitst(){
        AccountActivity accountActivity = new AccountActivity();
      List<WebElement> ok= Driver.getDriver().findElements(By.xpath("(//tbody)[2]//tr//td[2]"));
      Assert.assertTrue(!ok.isEmpty());
    }
}
