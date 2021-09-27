package cucumber.hooks;

import core.api.ApiRequestBuilder;
import io.cucumber.java.Before;

public class ApiHooks {
    private ApiRequestBuilder apiRequestBuilder;

    public ApiHooks(final ApiRequestBuilder apiRequestBuilder) {
        this.apiRequestBuilder = apiRequestBuilder;
    }

    @Before
    public void setUp() {
        apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "pk_18915744_BBOVH8SIAV8XZZA3W06NS6PSY8WZI7LJ")
                .headers("Content-Type", "application/json");
    }
}
