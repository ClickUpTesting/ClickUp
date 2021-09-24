package clickup;

import clickup.entities.Goal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import core.api.ApiManager;
import core.api.ApiRequest;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;

public class GoalsRequests {
    public static void deleteGoal(final String goalId) {
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse = new ApiResponse();
        ApiRequest apiRequest = apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "pk_18916260_75528SIM2T2KAL8T2WQXNGTSYG6XWT2V")
                .headers("Content-Type", "application/json")
                .endpoint("goal/{GoalId}")
                .pathParams("GoalId", goalId)
                .build();
        ApiManager.execute(apiRequest, apiResponse);
    }

    public static Goal getGoal(final String goalId) {
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse = new ApiResponse();
        ApiRequest apiRequest = apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "pk_18916260_75528SIM2T2KAL8T2WQXNGTSYG6XWT2V")
                .endpoint("goal/{GoalId}")
                .pathParams("GoalId", goalId)
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        return apiResponse.getBody(Goal.class);
    }

    public static String createGoal(final Goal goal) throws JsonProcessingException {
        ApiRequestBuilder apiRequestBuilder = new ApiRequestBuilder();
        ApiResponse apiResponse = new ApiResponse();
        ApiRequest apiRequest = apiRequestBuilder
                .baseUri("https://api.clickup.com/api/v2/")
                .headers("Authorization", "pk_18916260_75528SIM2T2KAL8T2WQXNGTSYG6XWT2V")
                .headers("Content-Type", "application/json")
                .endpoint("team/{TeamId}/goal")
                .pathParams("TeamId", "12908518")
                .body(new ObjectMapper().writeValueAsString(goal))
                .build();
        ApiManager.execute(apiRequest, apiResponse);
        return apiResponse.getBody(Goal.class).getId();
    }
}
