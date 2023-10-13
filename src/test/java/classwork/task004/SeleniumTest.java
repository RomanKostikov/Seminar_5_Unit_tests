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
        // ��������� ���� � �������� Chrome
        System.setProperty("webdriver.chrome.driver", "C://WebDriver//chromedriver.exe");
        // ������������ ��������� �������� Chrome(�� ��������)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized"); // ������������ ���� ��������

        // �������� ���������� WebDriver
        WebDriver driver = new ChromeDriver();
        // �������� ������� �������� Google
        driver.get("https://www.google.com");

        // ������� ������� ��������� ������ � ������ ����� "Selenium"
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium");
        // �������� ������ "����� � Google"(�� ��������)
        searchBox.submit();
        // ����� ������ �� ����������� ���� Selenium
        WebElement officialLink = driver.findElement(By.partialLinkText("Selenium"));
        // ��������, ��� ������ ������������� ������������ ����� ����������� ������
        if (officialLink != null) {
            System.out.println("������ �� ����������� ���� Selenium �������.");
        } else {
            System.out.println("������ �� ����������� ���� Selenium �� �������.");
        }
        // ���������� ������ ��������
        driver.quit();

    }


}
