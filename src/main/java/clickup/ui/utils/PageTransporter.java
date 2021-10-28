/**
 * Copyright (c) 2021 Fundacion Jala.
 * This software is the confidential and proprietary information of Fundacion Jala
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with Fundacion Jala
 */

package clickup.ui.utils;

import core.config.EnvConfig;
import core.selenium.WebDriverManager;
import salesforce.ui.pages.classic.contracts.ClassicContractsPage;
import salesforce.ui.pages.lightning.LoginPage;
import salesforce.ui.pages.lightning.campaign.CampaignsPage;
import salesforce.ui.pages.lightning.contracts.ContractsPage;
import salesforce.ui.pages.lightning.individuals.IndividualPageForm;
import salesforce.ui.pages.lightning.individuals.IndividualsPage;
import salesforce.ui.pages.lightning.search.SearchResultsPage;
import salesforce.ui.pages.lightning.worktype.WorkTypesPage;

import static core.utils.StringConverter.converterStringToEnum;

/**
 * Navigates to a page's url.
 */
public class PageTransporter {

    private String baseUrl = EnvConfig.getInstance().getBaseUrl();
    private String featureUrl = Urls.FEATURE_URL_LIGHTNING.getValue();
    private PageUrl pageUrl;
    private WebDriverManager webDriverManager;

    public PageTransporter(WebDriverManager webDriverManager) {
        this.webDriverManager = webDriverManager;
    }

    public LoginPage navigateToLoginPage() {
        goToUrl(baseUrl);
        return new LoginPage(webDriverManager);
    }

    /**
     * Goes directly to a page by an url.
     *
     * @param url to go.
     */
    public void goToUrl(final String url) {
        webDriverManager.getWebDriver().navigate().to(url);
    }


    /**
     * Navigates to feature page on lightning version.
     */
    public void navigateToFeaturePage(String featureName) {
        if ("CLASSIC".equals(EnvConfig.getInstance().getSkin())) {
            goToUrl(converterStringToEnum(featureName, EnvConfig.getInstance().getSkin()).getValue());
        } else {
            goToUrl(baseUrl.concat(String.format(featureUrl, featureName)));
        }
    }

    /**
     * Navigates to personal information page on lightning version.
     */
    public void navigatePersonalInformation() {
        goToUrl(baseUrl.concat("lightning/settings/personal/PersonalInformation/home"));
    }
}
