package cucumber.ui.steps;

import clickup.api.requests.SpaceRequest;
import clickup.ui.pages.sidebar.FolderForm;
import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.utils.PageTransporter;
import clickup.utils.ScenarioTrash;
import core.config.EnvConfig;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.Map;

import static clickup.ui.utils.PageUrl.getUrlPage;

public class FolderSteps {
    protected WebDriverManager webDriverManager;
    protected ScenarioTrash scenarioTrash;
    private Map<String, String> bodyFolderForm;
//    private PageTransporter pageTransporter;
    private SoftAssert softAssert;

    public FolderSteps(WebDriverManager webDriverManager, ScenarioTrash scenarioTrash, SoftAssert softAssert) {
        this.webDriverManager = webDriverManager;
        this.scenarioTrash = scenarioTrash;
        this.softAssert = softAssert;
//        this.pageTransporter = new PageTransporter(webDriverManager);
    }

    @When("I create a new folder with field")
    public void iCreateANewFolderWithField(final Map<String, String> bodyFolderForm) {
        this.bodyFolderForm = bodyFolderForm;
     //   webDriverManager.getWebDriver().navigate().to(getUrlPage("workspace environment"));
         SideBar sideBar = new SideBar(webDriverManager);
//        System.out.println("-/-/-/-"+ scenarioTrash.getTrashValue("name_space"));
        sideBar.clickInASpace(scenarioTrash.getTrashValue("name_space"));
        FolderForm folderForm = sideBar.clickFolderTextLink();
        folderForm.setNameFolder(bodyFolderForm.get("name"));
        folderForm.clickCreateFolderButton();
    }

    @Then("I verify that the created folder contains the default values")
    public void iVerifyThatTheCreatedFolderContainsTheDefaultValues() {
        SideBar sideBar = new SideBar(webDriverManager);
        sideBar.clickFolderInSpace(scenarioTrash.getTrashValue("name_space"));
        softAssert.assertTrue(sideBar.getFoldersInASpace(scenarioTrash.getTrashValue("name_space")).stream().
                anyMatch(value -> value.equals(bodyFolderForm.get("name"))));
    }
}
