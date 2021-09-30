package cucumber.hooks;

import core.api.ApiRequestBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.asserts.SoftAssert;

public class ApiHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private SoftAssert softAssert;

    public ApiHooks(final ApiRequestBuilder apiRequestBuilder, final SoftAssert softAssert) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.softAssert = softAssert;
    }

    @Before
    public void setUp() {
        apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "pk_18916260_75528SIM2T2KAL8T2WQXNGTSYG6XWT2V")
                .headers("Content-Type", "application/json");
    }

    @After
    public void assertAllSteps() {
        softAssert.assertAll();
    }
}
