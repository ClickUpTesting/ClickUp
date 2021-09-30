package cucumber.steps;

import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.And;

public class TagsRequests {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiRequest apiRequest;
    private ApiResponse apiResponse;

    public TagsRequests(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
    }

    @And("I execute the POST request for tags")
    public void iExecuteThePOSTRequestForTags() {
        apiRequest = apiRequestBuilder.method(ApiMethod.POST).build();
        ApiManager.execute(apiRequest, apiResponse);
    }
}
