import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.naming.Name;
import java.util.List;

public class FirstFeatureStepdefs {

    WebDriver driver;

    @Given("Launch the browser")
    public void launchTheBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }

    @When("Hit Google on your browser")
    public void HitGoogleOnYourBrowser() {
        driver.get("https://www.google.ru/");
        System.out.println("Opened google.ru");

    }
    @Then("Enter \"Cucumber\" in the search text box.")
    public void EnterCucumberInSearchTextBox() {
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("Cucumber");
        driver.findElement(By.cssSelector("[name='q']")).sendKeys(Keys.ENTER);


    }

    @And("Select the first result")
    public void SelectFirstResult() {
        List<WebElement> results = driver.findElements(By.cssSelector("q"));
        results.get(1).click();
    }

}
