package websiteTests;

import configuration.ConfigurationReader;
import configuration.WebDriverSetup;
import configuration.model.Environment;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TestBase {
    private static final Logger logger = LoggerFactory.getLogger(WebPageTitleTest.class);

    protected static WebDriver driver;
    protected static ConfigurationReader configurationReader = new ConfigurationReader();
    protected static Environment activeEnvironment;

    @BeforeAll
    static void setUp() {
        activeEnvironment = configurationReader.getActiveEnvironment();
        WebDriverSetup webDriverSetup = new WebDriverSetup(configurationReader.getBrowser().getBrowserName());
        driver = webDriverSetup.getDriver();
        logger.debug("Driver initialized");
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.debug("Driver closed");
        }
    }
}
