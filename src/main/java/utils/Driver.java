package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {
    public static WebDriver driver;

    public Driver() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = setUpWebDriver();
        }

        return driver;
    }

    private static WebDriver setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", Directory.DRIVER_DIR + "/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"start-maximized"});
        options.addArguments(new String[]{"enable-automation"});
        options.addArguments(new String[]{"--allow-running-insecure-content"});
        options.addArguments(new String[]{"--ignore-ssl-errors=yes"});
        options.addArguments(new String[]{"--ignore-certificate-errors"});
        options.addArguments(new String[]{"--no-sandbox"});
        options.addArguments(new String[]{"--disable-infobars"});
        options.addArguments(new String[]{"--disable-dev-shm-usage"});
        options.addArguments(new String[]{"--disable-browser-side-navigation"});
        options.addArguments(new String[]{"--disable-gpu"});
        driver = new ChromeDriver(options);
        return driver;
    }
}
