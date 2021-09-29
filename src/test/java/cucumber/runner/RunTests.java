package cucumber.runner;

import clickup.Endpoints;
import clickup.entities.Space;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiMethod;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import core.api.request.Header;
import core.utils.BaseContext;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

@CucumberOptions(
        features = {"src/test/resources/features"},
        plugin = {"html:target/site/cucumber-pretty.html", "json:target/cucumber/cucumber.json"},
        glue = {"cucumber"}
)
public class RunTests extends AbstractTestNGCucumberTests {
    private ApiResponse apiResponse = new ApiResponse();
    private final String TOKEN = "pk_18915744_BBOVH8SIAV8XZZA3W06NS6PSY8WZI7LJ";
    private String teamId = "12908183";
    private ApiRequest apiRequest;
    private BaseContext BaseContext;

    /**
     * Sets base of request.
     *
     * @return ApiRequestBuilder contains base request
     */
    private ApiRequestBuilder baseRequest() {
        return new ApiRequestBuilder()
                .baseUri(Endpoints.URL_BASE.getEndpoint())
                .headers(Header.AUTHORIZATION.getValue(), TOKEN)
                .headers(Header.CONTENT_TYPE.getValue(), Header.APPLICATION_JSON.getValue());
    }

    @BeforeTest
    public void setup() {
        BaseContext = BaseContext.getBaseContext();
    }

    @BeforeTest (dependsOnMethods = {"setup"})
    public void createSpace() throws JsonProcessingException {
        Space space = new Space();
        space.setName("Space before From API");
        apiRequest = baseRequest()
                .method(ApiMethod.POST)
                .endpoint(Endpoints.CREATE_SPACE.getEndpoint())
                .pathParams("team_id", teamId)
                .body(new ObjectMapper().writeValueAsString(space))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        BaseContext.addPathParamsBase("space_id", apiResponse.getBody(Space.class).getId());
    }

    @AfterTest()
    public void deleteSpace() {
         apiRequest = baseRequest()
                .method(ApiMethod.DELETE)
                .endpoint(Endpoints.GET_SPACE.getEndpoint())
                 .pathParams("space_id", BaseContext.getPathParamsBase().get("space_id"))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
    }
}
