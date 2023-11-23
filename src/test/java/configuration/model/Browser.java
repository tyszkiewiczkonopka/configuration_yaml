package configuration.model;

import lombok.Getter;

@Getter
public class Browser {
    String browserName;
    boolean attachScreenshot;
    boolean headless;
    int webElementTimeout;

    public Browser() {

    }

}
