package configuration.model;

public class Browser {
    String browserName;
    boolean attachScreenshot;
    boolean headless;
    int webElementTimeout;

    public Browser() {

    }

    public String getBrowserName() {
        return browserName;
    }

    public boolean isAttachScreenshot() {
        return attachScreenshot;
    }

    public boolean isHeadless() {
        return headless;
    }

    public int getWebElementTimeout() {
        return webElementTimeout;
    }
}
