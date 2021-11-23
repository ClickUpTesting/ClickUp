/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.report.cucumber.model.errormessage;

import java.util.HashMap;
import java.util.Map;

public class MessageManager {
    private Map<String, String> map = new HashMap<>();

    /**
     * Analyses the String.
     *
     * @param message is String to analyse
     * @author Gustavo Huanca
     */
    public void analyse(String message) {
        getException(message);
    }

    /**
     * Gets exception to message.
     *
     * @param message is String to analyse
     * @author Gustavo Huanca
     */
    public void getException(String message) {
        String[] strings = message.split(" ");
        map.put("exception", strings[0]);
    }
}
