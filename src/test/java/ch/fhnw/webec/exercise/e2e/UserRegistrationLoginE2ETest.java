// src/test/java/ch/fhnw/webec/exercise/e2e/UserRegistrationLoginE2ETest.java
package ch.fhnw.webec.exercise.e2e;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserRegistrationLoginE2ETest {

    @Test
    public void testUserRegistrationAndLogin() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/register");

        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        WebElement submitButton = driver.findElement(By.name("submit"));

        usernameField.sendKeys("e2eTestUser");
        passwordField.sendKeys("password");
        submitButton.click();

        driver.get("http://localhost:8080/login");
        usernameField = driver.findElement(By.name("username"));
        passwordField = driver.findElement(By.name("password"));
        submitButton = driver.findElement(By.name("submit"));

        usernameField.sendKeys("e2eTestUser");
        passwordField.sendKeys("password");
        submitButton.click();

        WebElement logoutButton = driver.findElement(By.name("logout"));
        assertThat(logoutButton).isNotNull();

        driver.quit();
    }
}