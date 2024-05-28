package ch.fhnw.webec.exercise.e2e;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class DeleteCategoryE2ETest {

    @Test
    public void testDeleteCategory() {
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/categories");

        // Assuming there is a category to delete with id=1
        WebElement deleteButton = driver.findElement(By.id("deleteCategory-1"));
        deleteButton.click();

        // Confirm the deletion if there is a confirmation dialog
        // driver.switchTo().alert().accept();

        WebElement categoryList = driver.findElement(By.id("categoryList"));
        assertThat(categoryList.getText()).doesNotContain("categoryToDelete");

        driver.quit();
    }
}