/**
 * Copyright (c) 2021 JalaSoft.
 * This software is the confidential and proprietary information of JalaSoft
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with JalaSoft
 *
 * @author Gustavo Huanca
 */

package core.report.cucumber.model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ScenarioSQL {
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("AT-Framework");

    /**
     * Inserts a Scenario to database.
     *
     * @param scenario is scenario
     */
    public void insertAssetData(Scenario scenario) {
        emf = Persistence.createEntityManagerFactory("AT-Framework");
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(scenario);
        manager.getTransaction().commit();
    }

    /**
     * Gets all scenario of database
     *
     * @return a list of scenario
     */
    public List<Scenario> getScenarios() {
        emf = Persistence.createEntityManagerFactory("AT-Framework");
        EntityManager manager = emf.createEntityManager();
        return (List<Scenario>) manager.createQuery("FROM Scenario").getResultList();
    }
}
