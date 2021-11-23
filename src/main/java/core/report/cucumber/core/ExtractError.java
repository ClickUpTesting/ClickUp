/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.report.cucumber.core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import core.report.cucumber.core.entities.Elements;
import core.report.cucumber.core.entities.Steps;
import core.report.cucumber.model.Scenario;
import core.report.cucumber.model.ScenarioSQL;
import core.utils.JsonFileManager;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import core.report.cucumber.core.entities.ScenarioEntity;
import org.openqa.selenium.InvalidArgumentException;

public class ExtractError {
    private String pathJsonFile;
    private JsonFileManager jsonFileManager;
    private ScenarioSQL scenarioSQL;

    public ExtractError(String pathJsonFile) {
        this.pathJsonFile = pathJsonFile;
        jsonFileManager = new JsonFileManager();
        scenarioSQL = new ScenarioSQL();
        analiseFile();
    }

    /**
     * Converts Json file to List< ScenarioEntity>
     *
     * @return a list of ScenarioEntity
     * @author Gustavo Huanca
     */
    public List<ScenarioEntity> converterJsonFileToScenarioEntity() {
        Type listType = new TypeToken<List<ScenarioEntity>>() {
        }.getType();
        try {
            return new Gson().fromJson(
                    jsonFileManager.readFileJsonToJsonArray(pathJsonFile).toString(),
                    listType);
        } catch (IOException e) {
            throw new InvalidArgumentException("The path or file are wrong");
        }
    }

    /**
     * Analise the scenarios
     *
     * @author Gustavo Huanca
     */
    private void analiseFile() {
        List<ScenarioEntity> scenarioEntities = converterJsonFileToScenarioEntity();
        Scenario scenario;
        for (ScenarioEntity scenarioEntity : scenarioEntities) {
            List<Elements> elements = scenarioEntity.getElements();
            for (Elements element : elements) {
                List<Steps> steps = element.getSteps();
                for (Steps step : steps) {
                    if ("failed".equals(step.getResult().getStatus())) {
                        scenario = new Scenario();
                        scenario.setScenarioName(element.getName());
                        scenario.setIdScenario(scenarioEntity.getId());
                        scenario.setStep(step.getName());
                        scenario.setStatus(step.getResult().getStatus());
                        scenario.setUri(scenarioEntity.getUri());
                        scenarioSQL.insertAssetData(scenario);
                    }
                }
            }
        }
    }
}
