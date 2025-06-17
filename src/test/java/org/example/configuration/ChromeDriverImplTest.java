package org.example.configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;

public class ChromeDriverImplTest {

    private final ChromeDriverImpl chromeDriverImpl = new ChromeDriverImpl();

    @AfterEach
    public void tearDown() {
//       chromeDriverImpl.getWebDriver().quit();
    }

    @Test // annotarile in java incep cu @. Ea este o interfata ce are o implementare
    @DisplayName("Cand apelez metoda openPage astept ca browserul sa se deschida la pagina dorita")
    // annotare optionala, ce ne descrie numele testului si actiunea lui.
    public void testDeschiderePagina() {
        final String urlToNavigateTo = "https://www.emag.ro/";
        chromeDriverImpl.openPage(urlToNavigateTo);
        final String currentUrl = chromeDriverImpl.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(urlToNavigateTo, currentUrl);
    }

    @Test
    @DisplayName("Cand deschid pagina si caut un produs , ma astept sa imi intoarca rezultate ")

    public void testCautareproduse() {
        final String urlToNavigateTo = "https://www.emag.ro/";
        chromeDriverImpl.openPage(urlToNavigateTo);
        final WebDriver driver = chromeDriverImpl.getWebDriver();
        final WebElement searchBox = driver.findElement(By.id("searchboxTrigger"));
        Assertions.assertNotNull(searchBox);
        final String placeholderText = searchBox.getDomAttribute("placeholder");
        Assertions.assertEquals(placeholderText, "Începe o nouă căutare");

        final String productToSearch = "ferrari";
        searchBox.sendKeys("ferrari");
        searchBox.sendKeys(Keys.RETURN);
        final String ulrDupaCautare = String.format("https://www.emag.ro/search/%s?ref=effective_search", productToSearch);
        Assertions.assertEquals(ulrDupaCautare, driver.getCurrentUrl());

        final WebElement cardGrid = driver.findElement(By.id("card_grid"));
        Assertions.assertNotNull(cardGrid);

        final List<WebElement> produse = cardGrid.findElements(By.cssSelector("div[class='card-item card-standard js-product-data js-card-clickable ']"));
        Assertions.assertTrue(produse.size() > 5);

        for (WebElement produs : produse) {
            final String descriereProdus = produs.findElement(By.tagName("h2")).getText();
            final String toClick = "Macheta Ferrari Racing F1-75 GP Italia 2022, BBurago, Metal, 1:43";
            if (descriereProdus.equals(toClick)) {
                produs.click();
                final String pageTitle = driver.findElement(By.className("page-title")).getText();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
                Assertions.assertEquals(pageTitle, toClick);
                driver.navigate().back();
                Assertions.assertEquals(ulrDupaCautare, driver.getCurrentUrl());
                driver.navigate().forward();
                Assertions.assertEquals(pageTitle, toClick);
                break;


            }
        }
    }
}

