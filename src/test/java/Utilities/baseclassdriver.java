package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class baseclassdriver {
    private static WebDriver driver;

    private baseclassdriver(){};

    public static WebDriver getDriver(){
        WebDriverManager.chromedriver().setup();
        if (driver == null){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");

            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }
        return driver;

    }
}
