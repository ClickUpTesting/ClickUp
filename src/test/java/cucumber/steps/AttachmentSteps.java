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

import clickup.api.entities.Attachment;
import core.api.ApiHeaders;
import core.api.ApiRequestBuilder;
import core.api.ApiResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;
import java.io.File;

public class AttachmentSteps {
    private ApiRequestBuilder apiRequestBuilder;
    private ApiResponse apiResponse;
    private SoftAssert softAssert;
    private File file;

    public AttachmentSteps(ApiRequestBuilder apiRequestBuilder, ApiResponse apiResponse, SoftAssert softAssert) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.apiResponse = apiResponse;
        this.softAssert = softAssert;
    }

    @When("I Add an attachment to the task")
    public void addAttachmentToTask() {
        file = new File(System.getProperty("user.dir"), "attachment.txt");
        apiRequestBuilder
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.MULTIPART_FORM_DATA.getValue())
                .setMultipart("attachment", file);
    }

    @And("I verify the attachment is in the task")
    public void verifyTaskAttachment() {
        Attachment attachment = apiResponse.getBody(Attachment.class);
        softAssert.assertEquals(attachment.getTitle(), file.getName());
    }
}
