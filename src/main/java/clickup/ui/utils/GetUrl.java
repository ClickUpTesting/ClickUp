/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package clickup.ui.utils;

public final class GetUrl {

    private GetUrl() {
    }

    /**
     * Gets id of the team.
     *
     * @param url is an url
     * @return an id of string
     * @author Gustavo Huanca
     */
    public static String getIdTeam(String url) {
        final int INDIC = 3;
        String[] diveList = url.split("/");
        return diveList[INDIC];
    }
}
