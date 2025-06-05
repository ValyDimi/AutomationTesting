package org.example.configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverImpl extends SeleniumConfiguration {
    private final WebDriver driver;

    public ChromeDriverImpl() {
        super(new ChromeDriver());
        final ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        this.driver = super.getWebDriver();
    }

    @Override

    public void openPage(String url) {
        driver.navigate()
                .to(url);
    }
}
