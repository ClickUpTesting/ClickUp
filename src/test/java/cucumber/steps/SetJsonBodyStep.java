package cucumber.steps;

import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.utils.ScenarioContext;
import io.cucumber.java.en.When;
import org.json.JSONObject;

import java.util.Map;

public class SetJsonBodyStep {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;
    private ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public SetJsonBodyStep(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @When("I set the tags body with following values:")
    public void iSetTheTagsBodyWithFollowingValues(final Map<String, String> body) {
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
