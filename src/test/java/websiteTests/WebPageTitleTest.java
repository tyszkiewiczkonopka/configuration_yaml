package websiteTests;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
@Slf4j
public class WebPageTitleTest extends TestBase {

    @Test
    @DisplayName("Title")
    @Tag("Title")
    public void website_title_should_be_as_in_configuration_file() {
        log.info(">>>>> STARTING TEST <<<<<");
        String appUrl = System.getProperty("appUrl");
        driver.get(appUrl);

        final String expectedTitle = System.getProperty("websiteTitle");
        String actualTitle = driver.getTitle();

        log.info("URL: {}", appUrl);
        log.info("Actual Title: {}", actualTitle);
        log.info("Expected Title: {}", expectedTitle);
        log.info("yetAnotherParam: {}", System.getProperty("yetAnotherParam"));
        log.info("isItTheBestBrowser: {}", System.getProperty("browser.isItTheBestBrowser"));

        assertThat(actualTitle, equalTo(expectedTitle));
    }
}
