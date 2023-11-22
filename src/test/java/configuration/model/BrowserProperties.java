package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserConfig {
    private final String browserName;

    public BrowserConfig(String browserName) {
        this.browserName = browserName;
        WebDriver driver = createDriver();
    }

    private WebDriver createDriver() {
        return switch (this.browserName.toLowerCase()) {
            case "chrome" -> createChromeDriver();
            case "firefox" -> createFirefoxDriver();
            case "ie" -> createInternetExplorerDriver();
            default -> throw new IllegalArgumentException("Invalid browser specified: " + this.browserName);
        };
    }

    private WebDriver createChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        return new ChromeDriver(chromeOptions);
    }

    private WebDriver createFirefoxDriver() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("start-maximized");
        return new FirefoxDriver(firefoxOptions);
    }

    private WebDriver createInternetExplorerDriver() {
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        return new InternetExplorerDriver(ieOptions);
    }
}
