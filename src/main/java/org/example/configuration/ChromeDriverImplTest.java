//package org.example.configuration;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.Arguments;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.openqa.selenium.*;
//import org.openqa.selenium.interactions.Actions;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//import static org.assertj.core.api.Assertions.*;
//
//public class ChromeDriverImplTest {
//    private final ChromeDriverImpl chromeDriverImpl = new ChromeDriverImpl();
//
//    public static Stream<Arguments> produse() {
//    }
//
//    @AfterEach
//    public void tearDown() {
//        chromeDriverImpl.getWebDriver().quit();
//    }
//
//    @Test  //Annotarile in java incep cu @
//    @DisplayName("Cand apelez metoda open page, ma astept ca browserul sa se deschida la pagina dorita")
//// annotare optionala, ce ne descrie numele testului si actiunea lui.
//
//    public void testDeschiderePagina() {
//        final String urlToNavigateTo = "https://www.emag.ro/";
//        chromeDriverImpl.openPage(urlToNavigateTo);
//        final String currentUrl = chromeDriverImpl.getWebDriver().getCurrentUrl();
//        Assertions.assertEquals(urlToNavigateTo, currentUrl);
//    }
//
//    @ParameterizedTest
//    @MethodSource("produse")
//    @DisplayName("Cand deschid pagina pentru a cauta un produs, ma astept sa imi intoarca mai multe rezultate," +
//            "iar pe baza parametrilor definiti sa dea click pe produse.")
//
//
////    public void testCautareProduse() throws InterruptedException {
//
//    public void testCautareProduse(String productToSearch, String produseDeDatClick)
//            throws InterruptedException {
//
//        final String urlToNavigateTo = "https://www.emag.ro/";
//        chromeDriverImpl.openPage(urlToNavigateTo);
//        final WebDriver driver = chromeDriverImpl.getWebDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//
//        final WebElement searchBox = driver.findElement(By.id("searchboxTrigger"));
//        Assertions.assertNotNull(searchBox);
//
//        final String placeholderText = searchBox.getDomAttribute("placeholder");
////        Assertions.assertEquals(placeholderText, "Începe o nouă căutare");
//        assertThat(placeholderText).isEqualTo("Incepe o noua cautare");
//
//        final WebElement cardGrid = driver.findElement(By.id("card_grid"));
//        Assertions.assertNotNull(cardGrid);
//
//        final List<WebElement> produse =
//                cardGrid.findElements(By.cssSelector("div[class='card-item card-standard js-product-data js-card-clickable ']"));
//        assert produse.size() > 5;
//        assertThat(produse).hasSizeGreaterThan(5);
//
//        /*
//         * O asertiune este o constructie folosita pentru a testa presupuneri in timpul executiei programului.
//         * Asserts sunt folosite in special pt testare, dar si pentru depanare(debugging), insa ele nu trebuie sa inlocuiasca verificarile de eroare in codul de productie.
//         *
//         * Implicit, intr-un program java nu sunt activate asserts. Le putem activa trimitand comanda -ea (enable asserts)
//         *
//         * Limbajul java are o librarie proprie de asserts.
//         *
//         * int x = 0;
//         * assert x > 0; // false, va arunca o eroare
//         * assert x == 0; // true, programul va continua
//         */
//
//// JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//// javascriptExecutor.executeScript("window.scrollBy(0, document.body.scrollHeight);");
////driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
//
//        for (WebElement produs : produse) {
//            final String descriereProdus = produs.findElement(By.tagName("h2")).getText();
//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
//
//            assertThat(pageTitle).isEqualTo(produseDeDatClick);
//            driver.navigate().back();
//
//            assertThat(urlDupaCautare).isEqualTo(driver.getCurrentUrl());
//            driver.navigate().forward();
//
//            assertThat(pageTitle).isEqualTo(produseDeDatClick);
//            break;
//        }
//    }
//}
//
//static Stream<Arguments> produse() {
//// ex: citire produse din baza de date, dintr-un fisier, etc ...
//    return Stream.of(Arguments.of("ferari", "Macheta Ferrari Racing F1-75 GP Italia 2022, BBurago, Metal, 1:43"),
//            Arguments.of("ferari", "Macheta auto Ferrari F1 SF21 Team Scuderia Ferrari N16 2021 Charles Leclerc, 1:43 Bburago"),
//            Arguments.of("ferari", "Set 4 machete Formula 1 Ferrari Leclerc/Sainz 2022-2023 - 1/43 Bburago"),
//            Arguments.of("lustre", "Lustra moderna, Goeco, Fier, 12x32x72 cm, Negru"),
//            Arguments.of("becuri", "Pachet 2 becuri LED Philips A67, E27, 13W (100W), 1521 lm, lumina neutra (4000K), Clasa energetica E"),
//            Arguments.of("caramele", "Topping cu Aroma de Caramel, 1 Kg, Metro Chef"),
//// Arguments.of("sandale", "Champion, Sandale cu velcro Moon, Bej deschis, 38"),
//            Arguments.of("oua", "Set oua din plastic, 3 maro si 3 albe, 6/set, Rayher"),
//            Arguments.of("lustre", "Lustra Vintage, Arta fierului Negru 3 Brate reglabile E27 Yx-3")
//    );
//}
//}
//
//
////final String productToSearch = "ferari";
////        searchBox.
////
////sendKeys(productToSearch);
////        searchBox.
////
////sendKeys(Keys.RETURN);
////
////final String urlDupaCautare = String.format("https://www.emag.ro/search/%s?ref=effective_search", productToSearch);
////        Assertions.
////
////assertEquals(urlDupaCautare, driver.getCurrentUrl());
////
////final WebElement cardGrid = driver.findElement(By.id("card_grid"));
////        Assertions.
////
////assertNotNull(cardGrid);
////
////final List<WebElement> produse = cardGrid.findElements(By.cssSelector("div[class='card-item card-standard js-product-data js-card-clickable ']"));
////        Assertions.
////
////assertTrue(produse.size() >5);
////
////final Map<String, WebElement> titluriSiProduse = produse.stream()
////        .collect(Collectors.toMap(webElement -> webElement
////                .findElement(By.tagName("h2")).getText(), element -> element));
////
////        for(
////Map.Entry<String, WebElement> entry :titluriSiProduse.
////
////entrySet()){
////final String descriereProdus = entry.getKey();
////final WebElement produs = entry.getValue();
////final Actions actions = new Actions(driver);
////
////            actions.
////
////keyDown(Keys.CONTROL)
////                    .
////
////click(produs)
////                    .
////
////build()
////                    .
////
////perform();
////
////            for(
////String tab :driver.
////
////getWindowHandles()){
////        try{
////WebDriver window = driver.switchTo().window(tab);
////final String pageTitle = window.findElement(By.className("page-title")).getText();
////                    Assertions.
////
////assertEquals(pageTitle, descriereProdus);
////                }catch(
////Exception e){
////        System.out.
////
////println("NU am gasit in window handle: "+driver.getWindowHandle());
////        }
////        }
////        }
////
////        for(
////WebElement produs :produse){
////final String descriereProdus = produs.findElement(By.tagName("h2")).getText();
////final String toCLick = "Macheta Ferrari Racing F1-75 GP Italia 2022, BBurago, Metal, 1:43";
////            if(descriereProdus.
////
////equals(toCLick)){
////
////        produs.
////
////click();
////
////final String pageTitle = driver.findElement(By.className("page-title")).getText();
////                driver.
////
////manage().
////
////timeouts().
////
////implicitlyWait(Duration.ofSeconds(1));
////        Assertions.
////
////assertEquals(pageTitle, toCLick);
////                driver.
////
////navigate().
////
////back();
////                Assertions.
////
////assertEquals(urlDupaCautare, driver.getCurrentUrl());
////        driver.
////
////navigate().
////
////forward();
////                Assertions.
////
////assertEquals(pageTitle, toCLick);
////
////                break;
////                        }
////                        }
////                        }
////
////
////                        }
