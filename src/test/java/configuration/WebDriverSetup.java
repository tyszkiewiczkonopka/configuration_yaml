package configuration;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;


public class WebDriverSetup {
    @Getter
    private WebDriver driver;
    private String browserName;


    public WebDriverSetup(String browserName) {
        this.browserName = browserName;
        this.driver = createDriver(browserName);
    }

    private WebDriver createDriver(String browserName) {
        if (browserName == null) {
            throw new IllegalArgumentException("Browser name cannot be null.");
        }

        return switch (browserName.toLowerCase()) {
            case "chrome" -> createChromeDriver();
            case "firefox" -> createFirefoxDriver();
            case "ie" -> createInternetExplorerDriver();
            default -> throw new IllegalArgumentException("Invalid browser specified: " + browserName);
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
