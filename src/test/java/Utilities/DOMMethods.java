package Utilities;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class DOMMethods {
    baseclassdriver sgp;
    public WebDriver driver = sgp.getDriver();
    String text,text2,text3;
    WebDriverWait wait;
    String valueconfig;
    public DOMMethods(WebDriver driver) {
        this.driver = driver;
    }

    public void getvaluesfromconfigfile(String value) throws IOException {
        FileReader fr = new FileReader("config.properties");
        Properties obj = new Properties();
        obj.load(fr);
        valueconfig = obj.getProperty(value);
    }

    public String getemailandpassword() throws IOException {
        FileReader fr = new FileReader("config.properties");
        Properties obj = new Properties();
        obj.load(fr);
        String URL = obj.getProperty("AFXTesting");
        return URL;
    }

    public void openURL()
    {
        driver.navigate().to(valueconfig);
    }

    public void enterText(String text, String elemName, String pageName) throws InterruptedException {
        wait = new WebDriverWait(driver, 50);
        String elementXpath = DOMElements.getXpath(elemName, pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        WebElement element = driver.findElement(By.xpath(elementXpath));
        try{
            Thread.sleep(1500);
            element.sendKeys(valueconfig);
        }catch (ElementClickInterceptedException r)
        {
            Thread.sleep(1500);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("document.getElementById('"+element+"').value='"+valueconfig+"';");
        }

    }

    public void clickbuttonDOM(String elemName,String pageName)
    {
        wait = new WebDriverWait(driver, 50);
        String elementXpath = DOMElements.getXpath(elemName, pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
        WebElement element = driver.findElement(By.xpath(elementXpath));
        try{
            element.click();
        }catch (ElementClickInterceptedException r)
        {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click()", element);
        }
    }

    public void clickondropdown(String elemName,String pageName, String firstoption)
    {
        wait = new WebDriverWait(driver, 50);
        String elementXpath = DOMElements.getXpath(elemName, pageName);
        String optionxpath = DOMElements.getXpath(firstoption, pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementXpath)));
        WebElement element = driver.findElement(By.xpath(elementXpath));
        try{
            element.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionxpath)));

        }catch (ElementClickInterceptedException r)
        {
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("arguments[0].click()", element);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(optionxpath)));
        }
    }
    public String getdatafromlocator(String elemName, String pageName)
    {
        wait = new WebDriverWait(driver, 50);
        String elementXpath = DOMElements.getXpath(elemName, pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        text = driver.findElement(By.xpath(elementXpath)).getText();
        return text;
    }
    public void sendtext(String elemName,String assertrow ,String pageName) throws InterruptedException {
        wait = new WebDriverWait(driver, 50);
        String elementXpath = DOMElements.getXpath(elemName, pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        WebElement element = driver.findElement(By.xpath(elementXpath));
        try{
            Thread.sleep(2000);
            element.sendKeys(text);
            Thread.sleep(2000);
            element.sendKeys(Keys.ENTER);
            wait = new WebDriverWait(driver, 50);
            elementXpath = DOMElements.getXpath(assertrow, pageName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            text3 = driver.findElement(By.xpath(elementXpath)).getText();
            assertTrue(text3.contains(text));

        }catch (ElementClickInterceptedException | InterruptedException r)
        {
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor)driver;
            js.executeScript("document.getElementById('"+element+"').value='"+text+"';");
            Thread.sleep(2000);
            element.sendKeys(Keys.ENTER);
            wait = new WebDriverWait(driver, 50);
            elementXpath = DOMElements.getXpath(assertrow, pageName);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            text3 = driver.findElement(By.xpath(elementXpath)).getText();
            assertTrue(text3.contains(text));
        }
    }
    public void assertanymessage(String message,String elemName, String pageName)
    {
        wait = new WebDriverWait(driver, 50);
        String elementXpath = DOMElements.getXpath(elemName, pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        text2 = driver.findElement(By.xpath(elementXpath)).getText();
        assertTrue(text2.contains(message));
//        try {
//            assertTrue(text.contains(message));
//            System.out.println("Asserted");
//        } catch (AssertionError e) {
//            System.out.println("Not Asserted");
//        }
    }
}
