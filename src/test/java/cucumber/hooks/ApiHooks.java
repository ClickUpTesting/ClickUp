package cucumber.hooks;

import core.api.ApiRequestBuilder;
import io.cucumber.java.Before;

public class ApiHooks {
    private ApiRequestBuilder apiRequestBuilder;

    public ApiHooks(final ApiRequestBuilder apiRequestBuilder) {
        this.apiRequestBuilder = apiRequestBuilder;
    }

    @Before(order  = 1)
    public void setUp() {
        apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "3152915_d6831bb6342aea560c0d7bdcfd16a6f9ce50b1fb")
                .headers("Content-Type", "application/json");
        System.out.println("uno");
    }
}
