package cucumber.steps;

import clickup.Endpoints;
import clickup.entities.FeatureFactory;
import clickup.entities.Features;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.http.HttpStatus;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import static core.utils.PascalCaseConverter.convertToPascalCase;

public class ApiSteps {
    ApiRequestBuilder apiRequestBuilder;
    ApiRequest apiRequest = new ApiRequest();
    ApiResponse apiResponse = new ApiResponse();
    FeatureFactory featureFactory = new FeatureFactory();
    SoftAssert softAssert = new SoftAssert();

    public ApiSteps(ApiRequestBuilder apiRequestBuilder) {
        this.apiRequestBuilder = apiRequestBuilder;
    }

    @Given("^I build a (.*) request$")
    public void iBuildAPOSTRequest(final String apiMethod) {
        apiRequestBuilder
                .method(ApiMethod.valueOf(apiMethod));
    }

    @When("^I create a (.*) body with parameters$")
    public void iCreateAGoalBodyWithParameters(final String featureName, final Map<String, String> entry) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, JsonProcessingException {
        Features feature = featureFactory.getFeature(featureName);
        feature.setAllFields(entry);
        apiRequestBuilder.body(new ObjectMapper().writeValueAsString(feature));
    }

    @And("^I execute the request on (.*) endpoint$")
    public void iExecuteTheRequestOnTheEndpoint(final String endpointName) {
        apiRequest = apiRequestBuilder
                .endpoint(Endpoints.valueOf(convertToPascalCase(endpointName)).getEndpoint())
                .pathParams("TeamId", "12908518")
                .build();
        ApiManager.execute(apiRequest, apiResponse);
    }

    @Then("^I check that the response status is (.*)$")
    public void iCheckThatTheResponseStatusIsOK(final String responseStatus) {
        HttpStatus httpStatus = HttpStatus.valueOf(responseStatus);
        int expectedStatus = httpStatus.value();
        softAssert.assertEquals(apiResponse.getStatusCode(), expectedStatus);
    }

    @And("^I see that the schema matches the provided on the file (.*)$")
    public void iSeeThatTheSchemaMatchesTheProvidedOnTheFileCreateGoalJson(final String schemaPath) {
        apiResponse.validateBodySchema(schemaPath);
    }

    @Then("^I check that the (.*) was created with provided parameters$")
    public void iCheckThatTheGoalWasCreatedWithProvidedParameters(final String featureType) {
        softAssert.assertAll();
    }
}
