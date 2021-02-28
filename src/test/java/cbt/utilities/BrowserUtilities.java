package cbt.utilities;

import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BrowserUtilities {

    public static void explicitWaitVisibility(WebDriver driver, int sec, String locator) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, sec);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

    }



    public static void explicitWaitClick(WebDriver driver, int sec, String locator) {

        WebDriverWait webDriverWait = new WebDriverWait(driver, sec);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

    }



    public static WebElement waitForVisibility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }






    public static void getUpload(File file) {
        StringSelection stringSelection = new StringSelection(file.getAbsolutePath());
        //Copy to clipboard
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        // Cmd + Tab is needed since it launches a Java app and the browser looses focus
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_TAB);
        robot.delay(500);
        //Open Goto window
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_SHIFT);
        robot.keyPress(KeyEvent.VK_G);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_SHIFT);
        robot.keyRelease(KeyEvent.VK_G);
        robot.delay(500);
        //Paste the clipboard value
        robot.keyPress(KeyEvent.VK_META);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_META);
        robot.keyRelease(KeyEvent.VK_V);
        robot.delay(500);
        //Press Enter key to close the Goto window and Upload window
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        robot.delay(500);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }


    public static void AssertTitle(String expected) {

        String actual = Driver.getDriver().getTitle();

        Assert.assertTrue(actual.equals(expected));
    }


    public static void AssertTitleContains(String expected) {

        String actual = Driver.getDriver().getTitle();

        Assert.assertTrue(actual.contains(expected));
    }
    public static java.util.List<String> getElementText(java.util.List<WebElement> list){
        List<String> elemText= new ArrayList<>();
        for (WebElement element : list) {
            elemText.add(element.getText());

        }
        return elemText;
    }

    public static void selectedOption (String expected){
        Select select=  new Select(Driver.getDriver().findElement(By.id("aa_accountId")));
       String actual=  select.getFirstSelectedOption().getText();
        Assert.assertEquals(expected, actual);
    }



}
