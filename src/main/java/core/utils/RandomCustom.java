/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public final class RandomCustom {

    private RandomCustom() {
    }

    /**
     * Generates random and custom value.
     *
     * @return a String random
     * @author Gustavo Huanca
     */
    public static String random() {
        return generateDate().concat(generateFourRandom());
    }

    /**
     * Generates actual date.
     *
     * @return a String with actual date
     * @author Gustavo Huanca
     */
    private static String generateDate() {
        DateFormat dateFormat = new SimpleDateFormat(" yyyy-MM-dd HH:mm:ss ");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * Generates four random letters or numbers.
     *
     * @return a String with random value
     * @author Gustavo Huanca
     */
    public static String generateFourRandom() {
        String[] uniqueId = UUID.randomUUID().toString().split("-");
        return uniqueId[2];
    }
}
