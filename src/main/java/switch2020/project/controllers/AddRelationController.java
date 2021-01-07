package switch2020.project.controllers;

import switch2020.project.model.Application;
import switch2020.project.services.FamilyService;

public class AddRelationController {
    private Application app;

    public AddRelationController(Application app) {
        this.app = app;
    }

    /**
     *
     * @param selfID
     * @param otherID
     * @param relationDesignation
     * @param familyID
     * @return
     */

    public boolean createRelation(int selfID, int otherID, String relationDesignation, int familyID) {
        try {
            FamilyService familyService = this.app.getFamilyService();
            familyService.createRelation(selfID, otherID, relationDesignation, familyID);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return false;
        }

        return true;
    }
}