package cucumber.steps;

import clickup.entities.features.tags.Tag;
import clickup.entities.features.tasks.TasksResponse;
import clickup.requests.TasksRequests;
import clickup.utils.ScenarioContext;
import clickup.utils.ScenarioTrash;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class VerifyTagInTask {
    private ScenarioTrash scenarioTrash;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();
    private TasksRequests tasksRequests;
    private SoftAssert softAssert;

    public VerifyTagInTask(ScenarioTrash scenarioTrash, SoftAssert softAssert) {
        this.scenarioTrash = scenarioTrash;
        this.softAssert = softAssert;
        this.tasksRequests = new TasksRequests();
    }

    @Then("I verify that the tag does not exist in the task")
    public void iVerifyThatTheTagDoesNotExistInTheTask() {
        TasksResponse tasksResponse = tasksRequests.getTask(scenarioContext.getEnvData("task_id"));
        List<Tag> tagsList = tasksResponse.getTags();
        String tagName = scenarioTrash.getTrashValue("tagName");
        boolean isInTask = tagsList.stream().anyMatch(tag -> tag.getName().equals(tagName));
        softAssert.assertTrue(isInTask);
    }
}
