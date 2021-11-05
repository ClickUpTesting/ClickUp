/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Jorge Caceres
 */

package cucumber.ui.steps;

import clickup.ui.utils.PageTransporter;
import clickup.utils.ScenarioTrash;
import core.selenium.WebDriverManager;
import io.cucumber.java.en.And;

import static clickup.ui.utils.PageUrl.getUrlPage;

public class OpenFeatureStep {
    private WebDriverManager webDriverManager;
    private ScenarioTrash scenarioTrash;
    private PageTransporter pageTransporter;

    public OpenFeatureStep(WebDriverManager webDriverManager, ScenarioTrash scenarioTrash) {
        this.webDriverManager = webDriverManager;
        this.scenarioTrash = scenarioTrash;
        this.pageTransporter = new PageTransporter(webDriverManager);
    }

    @And("^I open a new (.*)")
    public void openFeature(String featureName) {
        pageTransporter.goToUrl(getUrlPage(featureName)
                .concat(scenarioTrash.getTrashValue(String.format("%s_id", featureName))));
    }
}
