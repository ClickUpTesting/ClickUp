package cucumber.ui.steps;

import clickup.ui.pages.ListPage;
import clickup.ui.pages.sidebar.CreateNew;
import clickup.ui.pages.sidebar.FeatureSettings;
import clickup.ui.pages.sidebar.SideBar;
import clickup.ui.pages.sidebar.TaskForm;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class TaskSteps {
    protected WebDriverManager webDriverManager;
    protected ScenarioTrash scenarioTrash;
    private ScenarioContext scenarioContext;
    private Map<String, String> settingsMap;
    private SoftAssert softAssert;

    public TaskSteps(WebDriverManager webDriverManager, ScenarioTrash scenarioTrash, SoftAssert softAssert) {
        this.webDriverManager = webDriverManager;
        this.scenarioTrash = scenarioTrash;
        this.softAssert = softAssert;
        scenarioContext = ScenarioContext.getInstance();
    }

    @When("I create a new task with field")
    public void createANewTaskWithField(final Map<String, String> settingsMap) {
        this.settingsMap = settingsMap;
        SideBar sideBar = new SideBar(webDriverManager);
        System.out.println(scenarioContext.getEnvData("space_name"));
        sideBar.clickInASpace(scenarioContext.getEnvData("space_name"));
        sideBar.clickFolderInSpace(scenarioContext.getEnvData("space_name"));
        sideBar.clickInAList(scenarioTrash.getTrashValue("list_name"));
        FeatureSettings settings = sideBar.clickInSettingList();
        CreateNew createNew = settings.clickCreateNew();
        TaskForm taskForm = createNew.clickNewTask();
        taskForm.setTaskName(settingsMap.get("name"));
        taskForm.clickCreateTaskButton();
    }

    @Then("I verify that the created task contains the default values")
    public void verifyThatTheCreatedTaskContainsTheDefaultValues() {
        ListPage listPage = new ListPage(webDriverManager);
        softAssert.assertTrue(listPage.getTasks().stream().
                anyMatch(value -> value.equals(settingsMap.get("name"))));
    }
}
