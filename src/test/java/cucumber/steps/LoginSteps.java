package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SecureAreaPage;
import java.net.MalformedURLException;
import java.net.URL;
import static org.testng.Assert.assertTrue;

public class LoginSteps {
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    private RemoteWebDriver driver;
    protected HomePage homePage;
    private LoginPage loginPage;
    private URL newUrl = new URL("http://10.24.48.192:4445/wd/hub");

    public LoginSteps() throws MalformedURLException {
    }

    @Given("I navigate to the internet page")
    public void iNavigateToTheInternetPage() {
        driver = new RemoteWebDriver(newUrl, firefoxOptions);
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @When("I login successfully")
    public void iLoginSuccessfully() {
        loginPage = homePage.clickFormAuthentication();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
    }

    @Then("I verify the security page message")
    public void iVerifyTheSecurityPageMessage() {
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        assertTrue(secureAreaPage.getAlertText()
                        .contains("You logged into a secure area!"),
                "Alert text is incorrect");
    }
    @After("@Login")
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        driver.quit();
    }
}
