package cucumber.steps;

import clickup.entities.Tag;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.*;
import core.utils.ScenarioContext;
import io.cucumber.java.en.When;

public class AddManyTags {
    ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
    ApiRequest apiRequest = new ApiRequest();
    ApiResponse apiResponse = new ApiResponse();
    ScenarioContext scenarioContext = ScenarioContext.getInstance();

    @When("I add the amount of {int} to the total of tags")
    public void iAddTheAmountOfToTheTotalOfTags(int arg0) throws JsonProcessingException {
        apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "pk_18916260_75528SIM2T2KAL8T2WQXNGTSYG6XWT2V")
                .headers("Content-Type", "application/json")
                .endpoint("/space/{space_id}/tag")
                .pathParams("space_id", scenarioContext.getEnvData("space_id"))
                .method(ApiMethod.POST);
        String name = "";
        for (int i = 0; i < arg0; i++) {
            Tag tag = new Tag();
            name = "name".concat(Integer.toString(i));
            tag.setName(name);
            apiRequestBuilder.body(new ObjectMapper().writeValueAsString(tag));
            apiRequest = apiRequestBuilder.build();
            ApiManager.execute(apiRequest, apiResponse);
        }
    }
}
