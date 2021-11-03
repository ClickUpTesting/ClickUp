/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package cucumber.ui.steps;

import clickup.ui.utils.PageTransporter;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.Given;

import static clickup.ui.utils.PageUrl.getUrlPage;

public class NavigateSteps {
    public WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;

    public NavigateSteps(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(webDriverManager);
    }

    @Given("^I navigate to (.*) page$")
    public void navigateMySettingsPage(String page) {
        pageTransporter.goToUrl(getUrlPage(page));
    }
}
