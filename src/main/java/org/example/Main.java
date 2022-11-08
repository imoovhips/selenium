package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","/Users/imoovhips/Desktop/chromedriver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.delivery-club.ru/moscow");

        WebElement use = driver.findElement(By.xpath("//button[@class='header__search-button']"));
        //
        use.click();

    }
}