package cucumber.steps;

import clickup.entities.GetAllFeatures;
import clickup.entities.Tags;
import core.api.ApiManager;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.utils.ScenarioContext;
import io.cucumber.java.en.Then;
import org.testng.asserts.SoftAssert;

public class VerifyAmount {
    ApiRequestBuilder apiRequestBuilder;
    ApiRequest apiRequest;
    ApiResponse apiResponse;
    SoftAssert softAssert = new SoftAssert();
    ScenarioContext scenarioContext = ScenarioContext.getInstance();

    public VerifyAmount(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @Then("I verify the amount of has increased by {int}")
    public void iVerifyTheAmountOfHasIncreasedBy(int arg0) {
        int actual = scenarioContext.getFeatures("Initial status").getAmount() + arg0;
        apiRequest = apiRequestBuilder.build();
        ApiManager.execute(apiRequest, apiResponse);
        GetAllFeatures featureResponse = apiResponse.getBody(Tags.class);
        int expected = featureResponse.getAmount();
                softAssert.assertEquals(actual, expected);
    }
}
