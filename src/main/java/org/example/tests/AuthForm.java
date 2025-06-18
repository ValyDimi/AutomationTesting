package org.example.tests;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.WebDriverWait;

//
//import static org.testng.Assert.assertEquals;
import java.time.Duration;

public class AuthForm {

    public static void main(String[] args) {
        WebDriver driver = new EdgeDriver();
//        driver.navigate().to("https://the-internet.herokuapp.com/");
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

//        3 ways to find an element:
//        1. WebElement numeVariabila = driver.findElement(By.name / id / classname / .. ("..."));
//        numeVariabila.sendKeys / click() / get ... (" ... ");

//        2. var numeVariabila = driver.findElement(By. ....(""));
//        numeVariabila.sendKeys / click() / get .. ("...");

//        3. driver.findElement(By.tagname / id / ... ("...");

//        pentru verificare test case
//        String actualResult = driver.findElement(By.tagName / id / ...  ("...")).getText();
//        String expectedResult = "The name of the webpage that should be showed / opened after the operations was made";
//        Assert.assertEquals(actualResult, expectedResult); - aici se compara rezulatele
//        Assert.assertNotEquals(actualResult, expectedResult); - aici se compara rezulatele
//        WebElement authElement = driver.findElement(By.xpath("//a[@href='/basic_auth']"));
        WebElement formAuthElement = driver.findElement(By.xpath("//a[@href='/login']"));
        formAuthElement.click();
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");

//        The var keyword in Java is a feature known as "local variable type inference."
//        This means that the compiler can infer (deduct) the type of a local variable at compile time,
//        based on the context in which it is used

        var password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.findElement(By.tagName("button")).click();

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));

//        driver.findElement(By.xpath("//a[@href='/logout']")).click(); works!

        String expectedResult = "Secure Area";
        String actualResult = driver.findElement(By.tagName("h2")).getText();

        Assertions.assertEquals(actualResult, expectedResult);

//        System.out.println(actualResult);
//        System.out.println(expectedResult);

        boolean resultCheck = actualResult.equalsIgnoreCase(expectedResult);
//        System.out.println(resultCheck);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.navigate().back();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.navigate().back();

        var scrollElement = driver.findElement(By.xpath("//a[@href='/infinite_scroll']"));
        scrollElement.click();
//
//        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromViewport(10, 10);
//        new Actions(driver)
//                .scrollFromOrigin(scrollOrigin, 200, 0)
//                .perform();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(0, 300)"); // , document.body.scrollWeight);");

        //driver.findElement


    }
}
