package org.example.configuration;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ChromeDriverImplTest {

    private final ChromeDriverImpl chromeDriverImpl = new ChromeDriverImpl();


//    @AfterEach
//    public void tearDown() {
//        chromeDriverImpl.getWebDriver().quit();
//    }

//    @BeforeAll
//    public static void init() {
//
//    }

    @Test // annotarile in java incep cu @
    @DisplayName("Cand apelez metoda openPage ") // annotare optionala, ce ne descrie numele testului si actiunea lui

    public void testDeschiderePagina() {
        final String urlToNavigateTo = "https://www.emag.ro/";
        chromeDriverImpl.openPage(urlToNavigateTo);
        final String currentUrl = chromeDriverImpl.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(urlToNavigateTo, currentUrl);

    }

    @Test
    @DisplayName("Cand deschid pagina si caut un produs, ma astept sa intoarca rezultate.")
    public void testCautareProduse() {
        final String urlToNavigateTo = "https://www.emag.ro/";
        chromeDriverImpl.openPage(urlToNavigateTo);
        final WebDriver driver = chromeDriverImpl.getWebDriver();
        driver.manage().window().maximize();
        final WebElement searchBox = driver.findElement(By.id("searchboxTrigger"));

        Assertions.assertNotNull(searchBox);
        final String placeHolderText = searchBox.getDomAttribute("placeholder");
        Assertions.assertEquals(placeHolderText, "Începe o nouă căutare");

        final String productToSearch = "ferari";
        searchBox.sendKeys(productToSearch);
        searchBox.sendKeys(Keys.RETURN);

        final String urlDupaCautare = String.format("https://www.emag.ro/search/%s?ref=effective_search", productToSearch);

//         WebElement refuzaToateClick = driver.findElement(By.cssSelector("Refuză toate "));
//         refuzaToateClick.click();

        Assertions.assertEquals(urlDupaCautare, driver.getCurrentUrl());

        final WebElement cardGrid = driver.findElement(By.id("card_grid"));
        Assertions.assertNotNull(cardGrid);

        final List<WebElement> produse = cardGrid.findElements(By.cssSelector("div[class='card-item card-standard js-product-data js-card-clickable ']"));
        Assertions.assertTrue(produse.size() > 5);

        for (WebElement produs : produse) {
            final String descriereProdus = produs.findElement(By.tagName("h2")).getText();
            String toClick = "Macheta auto Ferrari F1 SF21 Team Scuderia Ferrari N16 2021 Charles Leclerc, 1:43 Bburago";
            if (descriereProdus.equals(toClick)) {
                produs.click();
                final String pageTitle = driver.findElement(By.className("page-title")).getText();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                Assertions.assertEquals(pageTitle, toClick);
                driver.navigate().back();
                Assertions.assertEquals(urlDupaCautare, driver.getCurrentUrl());
                driver.navigate().forward();
                Assertions.assertEquals(pageTitle, toClick);
                break;
            }
        }
        for (WebElement produs : produse) {
            final String descriereProdus = produs.findElement(By.tagName("h2")).getText();
            produs.click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            final String pageTitle = driver.findElement(By.className("page-title")).getText();
            Assertions.assertEquals(pageTitle, descriereProdus);
            driver.navigate().back();
            Assertions.assertEquals(urlDupaCautare, driver.getCurrentUrl());
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                
        }

    }
}
