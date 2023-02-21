package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import stepDefinitions.Steps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class DOMMethods {
    baseclassdriver sgp;
    public WebDriver driver = sgp.getDriver();

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
        element.sendKeys(text);
        System.out.println(elementXpath);
    }

    public void clickbuttonDOM(String elemName,String pageName)
    {
        wait = new WebDriverWait(driver, 50);
        String elementXpath = DOMElements.getXpath(elemName, pageName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
        WebElement element = driver.findElement(By.xpath(elementXpath));
        element.click();
    }
}
