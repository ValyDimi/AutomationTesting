package org.example.configuration;

import org.openqa.selenium.WebDriver;

public abstract class SeleniumConfiguration {
    private final WebDriver webDriver;
    public SeleniumConfiguration(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public abstract void openPage(String url);
    protected WebDriver getWebDriver() {
        return this.webDriver;

    }
}
