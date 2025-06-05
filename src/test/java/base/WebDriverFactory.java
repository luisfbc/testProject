package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {


    private static final ThreadLocal<WebDriver> twebDriver = new ThreadLocal<>();

    public static WebDriver initDriver(String browser) {
        switch (browser) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64");
                chromeOptions.addArguments("--lang=en-US");
                twebDriver.set(new ChromeDriver(chromeOptions));
                break;
            case "firefox":
                FirefoxOptions ffOptions = new FirefoxOptions();
                String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:126.0) Gecko/20100101 Firefox/126.0";
                ffOptions.addPreference("general.useragent.override",userAgent);
                twebDriver.set(new FirefoxDriver(ffOptions));
                break;
            case "edge":
                EdgeOptions edgeOptions  = new EdgeOptions();
                edgeOptions.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
                twebDriver.set(new EdgeDriver(edgeOptions));
                break;
            default:
                throw new RuntimeException("Unsupported webdriver: " + twebDriver);
        }
        twebDriver.get().manage().window().maximize();
        return getDriver();
    }

    public static WebDriver getDriver() {
        return twebDriver.get();
    }

    public static void quitDriver() {
        getDriver().quit();
        twebDriver.remove();
    }
}
