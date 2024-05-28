package ch.fhnw.webec.exercise.e2e;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@TestConfiguration
public class WebDriverConfiguration {
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @ConditionalOnClass(name = "org.openqa.selenium.htmlunit.HtmlUnitDriver")
    public WebDriver getHtmlUnitDriver() throws Exception {
        return (WebDriver) Class.forName("org.openqa.selenium.htmlunit.HtmlUnitDriver").getConstructor().newInstance();
    }

    @Primary
    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    @ConditionalOnClass(name = "org.openqa.selenium.chrome.ChromeDriver")
    public WebDriver getChromeDriver() throws Exception {
        return (WebDriver) Class.forName("org.openqa.selenium.chrome.ChromeDriver").getConstructor().newInstance();
    }
}
