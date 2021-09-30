/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Raymundo Guaraguara
 */

package unittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

import static clickup.utils.getPathParamsNames.getPathParamsFromEndpoint;

public class getPathParamsNamesTest {

    @Test
    public void testGetPathParamsFromEndpoint() {
        String endpoint = "/team/{team_id}/goal/{tag_id}";
        List<String> actual = getPathParamsFromEndpoint(endpoint);
        List<String> expected = new ArrayList<>();
        expected.add("team_id");
        expected.add("tag_id");
        Assert.assertEquals(actual, expected);
    }
}
