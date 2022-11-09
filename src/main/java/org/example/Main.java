package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/imoovhips/Desktop/chromedriver/chromedriver.exe");

        //h3[contains(@class, '')][contains(@class, '')] - уточнение элемента (содержит что-то)
        //h3[contains(@class, '')[not(contains(@class,''))] - уточнение (содержит что-то и не содержит чего-то)

        //div[@id='']/h3 - нашли элемент и взяли его наследника (тот элемент, который под ним)
        //div[@id='']//h3 - пропустили все элементы сверху до нужного если они есть

        WebDriver driver = new ChromeDriver();
        driver.get("http://uitestingplayground.com/");

        WebElement use = driver.findElement(By.xpath("//div[@class='row']//h1"));
        System.out.println(use + "элемент найден");
        WebElement clickElement = driver.findElement(By.xpath("/html/body/nav/a[@class='navbar-brand']"));

        // устаревший с ожиданием - driver.manage().timeouts().implicitlyWait(10, TimeUnit.MICROSECONDS);
        // manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // ожидание явное

        /**
         * Чтобы посмотреть, что мы ожиаем появление конкретного элемента, можно сделать следующее:
         */
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.xpath("/html/body/nav/a[@class='navbar-brand']"))));

        clickElement.click();
        System.out.println(clickElement + "клик успешный");
        System.out.println(element + "ожидание успешно");
        driver.quit();

    }
}