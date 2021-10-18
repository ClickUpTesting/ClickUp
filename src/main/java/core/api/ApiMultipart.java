/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package core.api;

import java.io.File;

public class ApiMultipart {
    private String key;
    private File file;

    /**
     * Gets the key.
     *
     * @return key for the multipart
     * @author Jorge Caceres
     */
    public String getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key for the multipart
     * @author Jorge Caceres
     */
    public void setKey(final String key) {
        this.key = key;
    }

    /**
     * Gets the file.
     *
     * @return file set on the multipart
     * @author Jorge Caceres
     */
    public File getFile() {
        return file;
    }

    /**
     * Sets the file.
     *
     * @param file for the multipart
     * @author Jorge Caceres
     */
    public void setFile(final File file) {
        this.file = file;
    }
}
