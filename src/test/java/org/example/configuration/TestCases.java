package org.example.configuration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TestCases {
    //    public EdgeDriverConfiguration edgeDriverConfiguration = new EdgeDriverConfiguration();
//    private final ChromeDriverImpl chromeDriverImpl = new ChromeDriverImpl();
    WebDriver driver = new EdgeDriver();
    WebDriver chromeDriver = new ChromeDriver();

//    @AfterEach
//    public void tearDown() {
//        driver.quit();
//    }

//    public void openPage(String url){
//        driver.navigate()
//                .to(url);
//    }


    @Test
    @DisplayName("Ma astept sa deschida pagina de autentificare")

    public void testDeschiderePaginaAutentificare() {
        String urlToNav = "https://the-internet.herokuapp.com/login";
        driver.get(urlToNav);
        driver.manage().window().maximize();
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(urlToNav, actualUrl);
    }

    @Test
    @DisplayName("Ma astept sa introduca datele de logare si sa se logheze")
    public void testLogare() {
        String urlToNav = "https://the-internet.herokuapp.com/login";
        driver.get(urlToNav);
        driver.manage().window().maximize();

        final String userNameToEnter = "tomsmith";
//        WebElement username = driver.findElement(By.xpath("//a[@href='/login']"));
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(userNameToEnter);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        final String passwordToEnter = "SuperSecretPassword!";
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passwordToEnter);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.tagName("button")).sendKeys(Keys.RETURN);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    @DisplayName("Nu ar trebui sa se logheze si ar trebui sa arate mesaj de eroare logare")
    public void testLogareWrongCredentials() {
        String urlToNav = "https://the-internet.herokuapp.com/login";
        driver.get(urlToNav);
        driver.manage().window().maximize();

        final String userNameToEnter = "testingname";
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys(userNameToEnter);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        final String passwordToEnter = "UltraSecretPassword!";
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys(passwordToEnter);

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.tagName("button")).sendKeys(Keys.RETURN);

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://the-internet.herokuapp.com/secure";
        Assertions.assertEquals(expectedUrl, actualUrl);
    }

    @Test
    @DisplayName("Ma astept sa deschida pagina 'Formy'")

    public void testDeschiderePaginaFormy() {
        String urlToNav = "https://formy-project.herokuapp.com/";
        driver.get(urlToNav);
        driver.manage().window().maximize();
        String actualUrl = driver.getCurrentUrl();
        Assertions.assertEquals(urlToNav, actualUrl);
    }

    @Test
    @DisplayName("Ma astept sa deschida pagina 'Formy', sa dea click si sa deschida pagina 'Buttons'")

    public void testDeschiderePaginaButtons() {
        String urlToNav = "https://formy-project.herokuapp.com/";
        chromeDriver.get(urlToNav);
        chromeDriver.manage().window().maximize();
        List<WebElement> buttonsList = chromeDriver.findElements(By.cssSelector("a[class='btn btn-lg']"));
        for (WebElement buttonsPage : buttonsList) {
            if (buttonsPage.getText().equals("Buttons"))
                Assertions.assertNotNull(buttonsPage);
                buttonsPage.click();
            break;
//            Assertions.assertEquals(buttonsList, buttonsPage);
        }


//        String actualUrl = chromeDriver.getCurrentUrl();
//
    }


}
