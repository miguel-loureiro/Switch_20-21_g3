package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.services.FamilyService;
import switchtwentytwenty.project.domain.dtos.output.MemberProfileDTO;

public class GetFamilyMemberProfileController {

    private final Application ffmApplication;

    public GetFamilyMemberProfileController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * Method that obtains the FFMapp that has the FamilyService as
     * its attribute. Using the familyID it iterates through the families on FamilyService
     * and after finding the correct family iterates through the list of
     * family members to find the family member which profile has been
     * requested. The profile is the returned as a MemberProfileDTO
     *
     * @param familyID representing the unique ID given to each family
     * @param ccNumber representing the unique ID from each family member
     * @return MemberProfileDTO with member's attributes
     */
    public MemberProfileDTO getMemberProfile(int familyID, String ccNumber) {

            FamilyService familyService = this.ffmApplication.getFamilyService();
            return familyService.getFamilyMemberProfile(familyID, ccNumber);
    }
}
