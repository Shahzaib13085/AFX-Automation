package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

public class DOMMethods {
    WebDriver Idriver;
    WebDriverWait wait;


    public String getURL() throws IOException {
        FileReader fr = new FileReader("config.properties");
        Properties obj = new Properties();
        obj.load(fr);
        String URL = obj.getProperty("AFXTesting");
        return URL;
    }

    public String getemailandpassword() throws IOException {
        FileReader fr = new FileReader("config.properties");
        Properties obj = new Properties();
        obj.load(fr);
        String URL = obj.getProperty("AFXTesting");
        return URL;
    }

    public void enterText(String text, String elemName, String pageName) throws InterruptedException {
        wait = new WebDriverWait(Idriver, 50);
        String elementXpath = DOMElements.getXpath(elemName, pageName);
        System.out.println(elementXpath);
        if (elementXpath.length() > 0) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
            WebElement element = Idriver.findElement(By.xpath(elementXpath));
            element.sendKeys(text);
        }
    }
}
