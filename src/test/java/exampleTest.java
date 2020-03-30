import com.codeborne.selenide.SelenideElement;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class exampleTest {
    WebDriver driver;



    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(enabled=false)
    public void userCanSearch() {
        driver.get("https://www.google.com/ncr");
        GooglePage page = PageFactory.initElements(driver, GooglePage.class);
        SearchResultsPage results = page.searchFor("Selenide");
        assertThat(results.getResults().get(0).getText(), containsString("Selenide: concise UI tests in Java"));
    }

    @Test
    public void googleSearch(){
        open("https://www.google.com/ncr");
        $(By.name("q")).setValue("PES").submit();
        $(By.name("btnI")).should(disappear);
        $("#res .g").shouldHave(text("pes"));
    }

    @Test
    public void googleSearcher(){
        open("https://www.google.com/ncr");
        SelenideElement selenideElement = $(By.name("q")).scrollTo();

        selenideElement.shouldBe(visible).setValue("PES").submit();
        $("#res .g").shouldHave(text("pes"));
    }

}