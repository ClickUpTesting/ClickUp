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

public final class GetPath {

    private GetPath() {

    }

    /**
     * Gets path according the operating system.
     *
     * @param path is the path to convert
     * @return a string with path
     */
    public static String getPathCorrect(final String path) {
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        if (isWindows) {
            return path;
        } else {
            return  System.getProperty("user.dir").concat(path);
        }
    }
}
