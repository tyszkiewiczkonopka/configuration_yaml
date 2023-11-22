package configuration.model;


public class Environment {

    private String envName;
    private boolean active;
    private String appUrl;
    private String websiteTitle;

    public Environment() {
    }

    public String getEnvName() {
        return envName;
    }

    public boolean isActive() {
        return active;
    }

    public String getAppUrl() {
        return appUrl;
    }

    public String getWebsiteTitle() {
        return websiteTitle;
    }
}
