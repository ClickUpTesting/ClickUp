/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.steps;

import core.api.ApiHeaders;
import core.api.ApiRequestBuilder;
import io.cucumber.java.en.When;
import java.io.File;

public class AttachmentSteps {
    private ApiRequestBuilder apiRequestBuilder;

    public AttachmentSteps(ApiRequestBuilder apiRequestBuilder) {
        this.apiRequestBuilder = apiRequestBuilder;
    }

    @When("I Add an attachment to the task")
    public void addAttachmentToTask() {
        File file = new File(System.getProperty("user.dir"), "attachment.txt");
        apiRequestBuilder
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.MULTIPART_FORM_DATA.getValue())
                .setMultipart("attachment", file);
    }
}
