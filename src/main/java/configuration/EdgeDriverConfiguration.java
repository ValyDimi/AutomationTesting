package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeDriverConfiguration {
    private final WebDriver webDriver;


    public EdgeDriverConfiguration() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        this.webDriver = new EdgeDriver(edgeOptions);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}

