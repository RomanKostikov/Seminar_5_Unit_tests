package classwork.task004;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;
import org.junit.Test;

import java.time.Duration;

public class SeleniumTest {
    @Test
    public void testSearchSelenium() {
        // Установка пути к драйверу Chrome
        System.setProperty("webdriver.chrome.driver", "C://WebDriver//chromedriver.exe");
        // Опциональные настройки браузера Chrome(на семинаре)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // Максимизация окна браузера

        // Создание экземпляра WebDriver
        WebDriver driver = new ChromeDriver();
        // Открытие главной страницы Google
        driver.get("https://www.google.com");

        // Находим элемент поисковой строки и вводим текст "Selenium"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        // Нажимаем кнопку "Поиск в Google"(На семинаре)
        searchBox.submit();
        // Поиск ссылки на официальный сайт Selenium
        WebElement officialLink = driver.findElement(By.partialLinkText("Selenium"));
        // Проверка, что ссылка действительно присутствует среди результатов поиска
        if (officialLink != null) {
            System.out.println("Ссылка на официальный сайт Selenium найдена.");
        } else {
            System.out.println("Ссылка на официальный сайт Selenium не найдена.");
        }
        // Завершение сеанса браузера
        driver.quit();

    }


}
