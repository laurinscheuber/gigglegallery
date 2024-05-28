package ch.fhnw.webec.exercise.e2e;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class EditFriendshipE2ETest {

    @Test
    public void testEditFriendship() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/friendships");

        // Assuming there is a friendship to edit with id=1
        driver.findElement(By.id("editFriendship-1")).click();

        WebElement userIdField = driver.findElement(By.name("userId"));
        WebElement friendIdField = driver.findElement(By.name("friendId"));
        WebElement submitButton = driver.findElement(By.name("submit"));

        userIdField.clear();
        userIdField.sendKeys("1");  // Assume userId 1
        friendIdField.clear();
        friendIdField.sendKeys("3");  // Assume new friendId 3
        submitButton.click();

        WebElement friendshipList = driver.findElement(By.id("friendshipList"));
        assertThat(friendshipList.getText()).contains("1").contains("3");

        driver.quit();
    }
}