package org.example;

import configuration.EdgeDriverConfiguration;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
        EdgeDriverConfiguration edgeDriverConfiguration = new EdgeDriverConfiguration();
        WebDriver driver = edgeDriverConfiguration.getWebDriver();
        driver.manage().window().maximize();
//        WebDriver edgeDriver = new EdgeDriver();
        //deschide pagina emag
        driver.navigate().to("https:www.emag.ro/");
        //click pe butonul de joc "refuza toate"
        WebElement refuzaToateButon = driver.findElement(By.cssSelector("button[class='btn btn-primary btn-block js-refuse gtm_bxxzbgwexm']"));
        refuzaToateButon.click();

        //gaseste elementul searchbox si scrie un cuvant de cautare (vitamine)
        WebElement casutaCautare = driver.findElement(By.id("searchboxTrigger"));
        casutaCautare.sendKeys("Vitamine");
        //click pe butonul de cautare
        WebElement butonCautare = driver.findElement(By.cssSelector("button[class='btn btn-default searchbox-submit-button']"));
        butonCautare.click();

        //click pe un produs din lista afisata pentru "vitamine"
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        WebElement imageOmegaElement = wait.until(ExpectedConditions.elementToBeClickable(By.className("w-100")));
//        WebElement imageOmegaElement = wait.until(ExpectedConditions.elementToBeClickable(By.name("Premium Omega 3 Fish Oil 1000 mg TG")));
//        WebElement imageOmegaElement = wait.until(ExpectedConditions.elementToBeClickable(By.className("mb-2 js-product-url card-v2-thumb px-1")));
//        WebElement imageOmegaElement = driver.findElement(By.className("mb-2 js-product-url card-v2-thumb px-1"));
//        WebElement imageOmegaElement = driver.findElement(By.linkText().findElement(By.cssSelector())
//
//        imageOmegaElement.click();








//        try {
//            webDriver.get("https://www.emag.ro/search/Vitamine?ref=effective_search");
//            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement imageOmegaElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@title, 'Premium Omega 3 Fish Oil 1000 mg TG + Vitamina E Naturală 10 mg')]")));
//            imageOmegaElement.click();
//            System.out.println("Produsul a fost accesat cu succes");
//
//        } catch (Exception e) {
//            System.out.println("Eroare " + e.getMessage());
//
//        } finally {
//            webDriver.quit();
//        }
//        WebElement imageOmegaElement = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("img-component position-relative card-v2-thumb-inner")));
//        imageOmegaElement.click();


//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='https://www.emag.ro/premium-omega-3-fish-oil-1000-mg-tg-vitamina-e-naturala-10-mg-supliment-alimentar-pentru-sanatatea-inimii-si-creierului-absorbtie-superioara-protectie-antioxidanta-pentru-90-zile-po-90/pd/D510BWYBM/?ref=sponsored_products_search_r_1_1&recid=recads_1_5db6e6042c57a54eb550dd82144f590d63f6c32cd899996dfa2fd15779876dde_1747592446&aid=25d9b6ad-e4b7-11ef-8003-06eb3cbbbd1b_eyJicGQiOjF9-103621ac630b2d953b61ac3953f7128102e449ded0f79e7c098943d001f98f9c&oid=221160172&scenario_ID=1']"))).click();

//        WebElement clickProdusOmega = driver.findElement(By.cssSelector("img[src='https://s13emagst.akamaized.net/products/84975/84974281/images/res_7ee9ad48c2210fbf949a2cc33b2489e3.png?width=720&height=720&hash=975BBBEBD2ADBA99BE4CA270BB1F592E']"));
//          WebElement clickProdusOmega = driver.findElement(By.xpath("//img[@src='https://s13emagst.akamaized.net/products/84975/84974281/images/res_7ee9ad48c2210fbf949a2cc33b2489e3.png?width=720&height=720&hash=975BBBEBD2ADBA99BE4CA270BB1F592E']"));
//          WebElement imgProdusOmega = driver.findElement(By.xpath("//a[@href='https://www.emag.ro/premium-omega-3-fish-oil-1000-mg-tg-vitamina-e-naturala-10-mg-supliment-alimentar-pentru-sanatatea-inimii-si-creierului-absorbtie-superioara-protectie-antioxidanta-pentru-90-zile-po-90/pd/D510BWYBM/?ref=sponsored_products_search_r_1_1&recid=recads_1_5db6e6042c57a54eb550dd82144f590d63f6c32cd899996dfa2fd15779876dde_1747592446&aid=25d9b6ad-e4b7-11ef-8003-06eb3cbbbd1b_eyJicGQiOjF9-103621ac630b2d953b61ac3953f7128102e449ded0f79e7c098943d001f98f9c&oid=221160172&scenario_ID=1']"));
//
//        imgProdusOmega.click();

//        WebElement magneziuImag = driver.findElement(By.className("img-component position-relative card-v2-thumb-inner"));
//        magneziuImag.click();


        //button - tip element ("button") ce are o clasa ce are o denumire "class" - luat din fisierul HTML al paginii.
// parantezele patrate pt delimitare (specificatia cautarii).

// tema - click pe un rezultate al cautarii de Vitamine.

//edgeDriver.quit();
//edgeDriver.close();

//        Exception in thread "main" org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
//                Build info: version: '4.32.0', revision: 'd17c8aa950'
//        System info: os.name: 'Windows 10', os.arch: 'amd64', os.version: '10.0', java.version: '17.0.7'
//        Driver info: org.openqa.selenium.edge.EdgeDriver
//        Command: [null, close {}]
//        Capabilities {acceptInsecureCerts: false, browserName: MicrosoftEdge, browserVersion: 136.0.3240.76, fedcm:accounts: true, ms:edgeOptions: {debuggerAddress: localhost:50680}, msedge: {msedgedriverVersion: 136.0.3240.76 (77e9ec69748f..., userDataDir: C:\Users\Dimi\AppData\Local...}, networkConnectionEnabled: false, pageLoadStrategy: normal, platformName: windows, proxy: Proxy(), se:cdp: ws://localhost:50680/devtoo..., se:cdpVersion: 136.0.3240.76, setWindowRect: true, strictFileInteractability: false, timeouts: {implicit: 0, pageLoad: 300000, script: 30000}, unhandledPromptBehavior: dismiss and notify, webauthn:extension:credBlob: true, webauthn:extension:largeBlob: true, webauthn:extension:minPinLength: true, webauthn:extension:prf: true, webauthn:virtualAuthenticators: true}
//        at org.openqa.selenium.remote.HttpCommandExecutor.execute(HttpCommandExecutor.java:176)
//            at org.openqa.selenium.remote.service.DriverCommandExecutor.invokeExecute(DriverCommandExecutor.java:216)
//            at org.openqa.selenium.remote.service.DriverCommandExecutor.execute(DriverCommandExecutor.java:174)
//            at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:545)
//            at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:618)
//            at org.openqa.selenium.remote.RemoteWebDriver.execute(RemoteWebDriver.java:622)
//            at org.openqa.selenium.remote.RemoteWebDriver.close(RemoteWebDriver.java:418)
//            at org.example.Main.main(Main.java:43)
        driver.quit();
        driver.close();
    }
}

  
