package websiteTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class WebPageTitleTest extends TestBase {
    private final Logger logger = LoggerFactory.getLogger(WebPageTitleTest.class);

    @Test
    @DisplayName("Title")
    @Tag("Title")
    public void selenium_page_title() {
        logger.info(">>>>> STARTING TEST <<<<<");
        driver.get(config.getAppUrl());

        final String expectedTitle = config.getWebsiteTitle();
        String actualTitle = driver.getTitle();

        logger.info("URL {}", config.getAppUrl());
        logger.info("Actual Title {}", actualTitle);
        logger.info("Expected Title {}", expectedTitle);

        assertThat(actualTitle, equalTo(expectedTitle));
    }
}
