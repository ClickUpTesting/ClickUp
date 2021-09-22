package com.clickup.steps;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class CreateTask {

    @Given("I build a {string} request")
    public void iBuildARequest(final String request) {

    }

    @When("I create a new {string} with parameters:")
    public void iCreateANewWithParameters(final String entity) {

    }

    @Then("I verify that the response is {string}")
    public void iVerifyThatTheResponseIs(final String response) {

    }

    @Test
    public void checkApi() {
        ApiRequest apiRequest = new ApiRequest();
        apiRequest.setContentType(ContentType.JSON);
        apiRequest.setBaseUri("https://api.clickup.com/api/v2");
        apiRequest.setEndpoint("/list/list_id/task");
        apiRequest.addHeaders("Authorization", "3258051_34708867d2fd6b51648487f89643d39c1ba96805");
        apiRequest.addPathParams("list_id","25144387");
        apiRequest.setMethod(ApiMethod.POST);
        apiRequest.setBody("{\n" +
                "  \"name\": \"New Task Name\",\n" +
                "  \"description\": \"New Task Description\",\n" +
                "  \"assignees\": [\n" +
                "    183\n" +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    \"tag name 1\"\n" +
                "  ],\n" +
                "  \"status\": \"to do\",\n" +
                "  \"priority\": 3,\n" +
                "  \"due_date\": 1508369194377,\n" +
                "  \"due_date_time\": false,\n" +
                "  \"time_estimate\": 8640000,\n" +
                "  \"start_date\": 1567780450202,\n" +
                "  \"start_date_time\": false,\n" +
                "  \"notify_all\": true,\n" +
                "  \"parent\": null,\n" +
                "  \"links_to\": null,\n" +
                "  \"custom_fields\": [\n" +
                "    {\n" +
                "      \"id\": \"0a52c486-5f05-403b-b4fd-c512ff05131c\",\n" +
                "      \"value\": 23\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"03efda77-c7a0-42d3-8afd-fd546353c2f5\",\n" +
                "      \"value\": \"Text field input\"\n" +
                "    }\n" +
                "  ]\n" +
                "}");
        ApiResponse apiResponse = new ApiResponse();
        ApiManager.execute(apiRequest, apiResponse);
        apiResponse.getResponse().then().log().body();
    }
}
