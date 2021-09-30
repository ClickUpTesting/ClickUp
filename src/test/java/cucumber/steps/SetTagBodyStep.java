package cucumber.steps;

import clickup.utils.ScenarioContext;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.When;
import org.json.JSONObject;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SetTagBodyStep {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private SoftAssert softAssert;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public SetTagBodyStep(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse, SoftAssert softAssert) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
        this.softAssert = softAssert;
    }

    @When("I set the tags body with following values:")
    public void iSetTheTagsBodyWithFollowingValues(final Map<String, String> body) {
        List<String> trashList =  new ArrayList<>();
        System.out.println(body.get("name"));
        trashList.add(body.get("name"));
        scenarioContext.setTrash("Tags Trash", trashList);
        JSONObject jsonBody = new JSONObject();
        JSONObject tagBody = new JSONObject();
        for (String tagComponent: body.keySet()) {
            tagBody.put(tagComponent,body.get(tagComponent));
        }

        jsonBody.put("tag",tagBody);
        apiRequestBuilder.body(jsonBody.toString());
        System.out.println(jsonBody.toString());
    }
}
