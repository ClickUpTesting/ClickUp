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
                .headers("Authorization", "pk_18916260_75528SIM2T2KAL8T2WQXNGTSYG6XWT2V")
                .headers("Content-Type", "application/json");
    }
}
