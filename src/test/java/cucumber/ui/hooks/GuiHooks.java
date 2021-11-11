/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.ui.hooks;

import clickup.ui.pages.LoginPage;
import clickup.ui.utils.PageTransporter;
import core.api.ApiHeaders;
import core.api.ApiRequestBuilder;
import core.selenium.WebDriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.testng.asserts.SoftAssert;

import static clickup.ui.utils.PageUrl.getUrlPage;

public class GuiHooks {
    private ApiRequestBuilder apiRequestBuilder;
    private SoftAssert softAssert;
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;

    public GuiHooks(final ApiRequestBuilder apiRequestBuilder, final SoftAssert softAssert,
                    final WebDriverManager webDriverManager) {
        this.apiRequestBuilder = apiRequestBuilder;
        this.softAssert = softAssert;
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(webDriverManager);
    }

    @Before(order = 1, value = "@GUI")
    public void setUp() {
        apiRequestBuilder
                .baseUri(ApiHeaders.URL_BASE.getValue())
                .headers(ApiHeaders.AUTHORIZATION.getValue(), System.getenv("API_TOKEN"))
                .headers(ApiHeaders.CONTENT_TYPE.getValue(), ApiHeaders.APPLICATION_JSON.getValue());
    }

    @After(value = "@GUI")
    public void assertAllSteps() {
        softAssert.assertAll();
    }

    @After(value = "@GUI")
    public void tearDown() {
        webDriverManager.closeWebDriver();
        webDriverManager.quitWebDriver();
    }
}
