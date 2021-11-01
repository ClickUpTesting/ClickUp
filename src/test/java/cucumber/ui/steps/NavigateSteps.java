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

public class NavigateSteps {
    private WebDriverManager webDriverManager;
    private PageTransporter pageTransporter;

    public NavigateSteps(final WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
        this.pageTransporter = new PageTransporter(this.webDriverManager);
    }

    @Given("^I navigate to (.*) page$")
    public void navigateMySettingsPage(String page) {
        pageTransporter.navigateToPage(page);
    }
}
