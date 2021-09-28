package cucumber.steps;

import clickup.entities.FeatureFactory;
import clickup.entities.IFeatures;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.*;
import core.utils.Context;
import core.utils.SelectPathParams;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

import java.util.Map;

public class ApiSteps {
    ApiRequestBuilder apiRequestBuilder;
    ApiRequest apiRequest = new ApiRequest();
    ApiResponse apiResponse = new ApiResponse();
    FeatureFactory featureFactory = new FeatureFactory();
    SoftAssert softAssert = new SoftAssert();
    SelectPathParams selectPathParams = new SelectPathParams();
    String featureName;
    Context context;

    public ApiSteps(ApiRequestBuilder apiRequestBuilder, Context context) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.context = context;
    }

    @Given("^I set the request endpoint to (.*)$")
    public void iSetTheRequestEndpointToTeamTeam_idGoal(final String endpoint) {
        apiRequestBuilder
                .endpoint(endpoint)
//                .pathParams(getPathParams(endpoint));
//                .pathParams("team_id", "12908183")
//                .pathParams("folder_id", "25022057");
                .pathParams(selectPathParams.getMapFollowEndpoint(context.getPathParams(),endpoint));
    }

    @When("^I set the request body as (.*) with following values:$")
    public void iSetTheRequestBodyAsGoalWithFollowingValues(final String featureName, final Map<String, String> body)
            throws Exception, JsonProcessingException {
        IFeatures feature = featureFactory.getFeature(featureName);
        feature.setAllFields(body);
        apiRequestBuilder.body(new ObjectMapper().writeValueAsString(feature));
        this.featureName = featureName;
    }

    @When("^I execute the (.*) request$")
    public void iExecuteThePOSTRequest(final String apiMethod) {
        apiRequest = apiRequestBuilder
                .method(ApiMethod.valueOf(apiMethod))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        IFeatures featureResponse = apiResponse.getBody(featureFactory.getFeature(this.featureName).getClass());
        context.addPathParamsStep(String.format("%s_id",featureName),featureResponse.getIdentifier());
    }

    @Then("I verify that the response status is {int}")
    public void iVerifyThatTheResponseStatusIs(final int statusCode) {
        softAssert.assertEquals(apiResponse.getStatusCode(), statusCode);
    }

    @Then("^I verify the schema matches the file: (.*)$")
    public void iVerifyTheSchemaMatchesTheFileSchemasCreate_goalJson(final String schemaPath) {
        apiResponse.validateBodySchema(schemaPath);
    }

    @Then("I verify the values set on the feature")
    public void iVerifyTheValuesSetOnTheGoal() {
        softAssert.assertAll();
    }
}
