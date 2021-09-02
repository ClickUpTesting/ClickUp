package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.HomePage;
import pages.KeyPresses;
import java.net.MalformedURLException;
import java.net.URL;
import static org.testng.Assert.assertEquals;

public class KeySteps {
    FirefoxOptions firefoxOptions = new FirefoxOptions();
    private RemoteWebDriver driver;
    protected HomePage homePage;
    private KeyPresses keyPage;
    private URL newUrl = new URL("http://10.24.48.192:4445/wd/hub");

    public KeySteps() throws MalformedURLException {
    }

    @Given("I navigate to Keys page")
    public void iNavigateToKeysPage() {
        driver = new RemoteWebDriver(newUrl, firefoxOptions);
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
        keyPage = homePage.clickKeyPresses();
    }
    @When("I type A and Back Space")
    public void iTypeAAndBackSpace() {
        keyPage.enterText("A" + Keys.BACK_SPACE);
    }

    @Then("You entered: BACK_SPACE message should be displayed")
    public void youEnteredBACK_SPACEMessageShouldBeDisplayed() {
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE", "Input result incorrect");
    }

    @After("@keys")
    public void takeScreenShoot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
        driver.quit();
    }
}
