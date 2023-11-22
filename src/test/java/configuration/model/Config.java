package configuration.model;


import java.util.Map;


public class Config {
    private Map<String, Environment> environments;
    private Browser browser;

    public Config() {
    }

    public Map<String, Environment> getEnvironments() {
        return environments;
    }

    public Browser getBrowser() {
        return browser;
    }
}
