package cucumber.hooks;

import core.api.ApiRequestBuilder;
import core.utils.Context;
import io.cucumber.java.Before;

public class ApiHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private Context context;

    public ApiHooks(final ApiRequestBuilder apiRequestBuilder, final Context context) {
        this.context = context;
        this.apiRequestBuilder = apiRequestBuilder;
    }

    @Before
    public void setUp() {
        apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "pk_18915744_BBOVH8SIAV8XZZA3W06NS6PSY8WZI7LJ")
                .headers("Content-Type", "application/json");
        context.addPathParams("team_id", "12908183");
    }
}
