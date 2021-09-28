package unittest;

import core.utils.SelectPathParams;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class SelectPathParamsTest {
    private SelectPathParams selectPathParams = new SelectPathParams();

    @Test
    public void shouldReturnOneString() {
        List<String> actual = selectPathParams.getPathParamsInEndPoint("/folder/{folder_id}/list");
        List<String> expected = new ArrayList<>();
        expected.add("folder_id");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnTwoString() {
        List<String> actual = selectPathParams.getPathParamsInEndPoint("/folder/{folder_id}/list/{list_id}");
        List<String> expected = new ArrayList<>();
        expected.add("folder_id");
        expected.add("list_id");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnThreeString() {
        List<String> actual = selectPathParams.getPathParamsInEndPoint("{team_id}/folder/{folder_id}{list_id}");
        List<String> expected = new ArrayList<>();
        expected.add("team_id");
        expected.add("folder_id");
        expected.add("list_id");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnZeroString() {
        List<String> actual = selectPathParams.getPathParamsInEndPoint("/folder/test");
        List<String> expected = new ArrayList<>();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnOnePathParams() {
        Map<String, String> mapValues = new HashMap<>();
        mapValues.put("team_id", "12908183");
        mapValues.put("list_id", "245475");
        mapValues.put("folder_id", "245475");
        Map<String, String> actual = selectPathParams.getMapFollowEndpoint(mapValues,"/folder/{folder_id}");
        Map<String, String> expected = new HashMap<>();
        expected.put("folder_id", "245475");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnTwoPathParams() {
        Map<String, String> mapValues = new HashMap<>();
        mapValues.put("team_id", "34324");
        mapValues.put("list_id", "245475");
        mapValues.put("folder_id", "245475");
        Map<String, String> actual = selectPathParams.getMapFollowEndpoint(mapValues,"{team_id}/folder/{folder_id}");
        Map<String, String> expected = new HashMap<>();
        expected.put("folder_id", "245475");
        expected.put("team_id", "34324");
        Assert.assertEquals(actual, expected);
    }
}
