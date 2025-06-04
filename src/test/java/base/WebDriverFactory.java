package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class WebDriverFactory {


    private static final ThreadLocal<WebDriver> twebDriver = new ThreadLocal<>();

    public static WebDriver initDriver() {
        String webdriver = System.getProperty("browser", "chrome");
        switch (webdriver) {
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                //String proxy = "44.195.247.145:80";
                options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64)");
                //options.addArguments("--proxy-server=http://" + proxy);
                twebDriver.set(new ChromeDriver(options));
                break;
            case "firefox":
                twebDriver.set(new FirefoxDriver());
                break;
            case "edge":
                twebDriver.set(new EdgeDriver());
                break;
            default:
                throw new RuntimeException("Unsupported webdriver: " + webdriver);
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
