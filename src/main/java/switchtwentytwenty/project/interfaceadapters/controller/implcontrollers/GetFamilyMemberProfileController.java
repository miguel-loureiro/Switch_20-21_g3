package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import switchtwentytwenty.project.dto.InternalProfileDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

@Controller
public class GetFamilyMemberProfileController implements switchtwentytwenty.project.interfaceadapters.controller.IControllers.IGetFamilyMemberProfileController {

    @Autowired
    IGetFamilyMemberProfileService getProfileService;

    public OutputPersonDTO getFamilyMemberProfile(InternalProfileDTO internalProfileDTO){
        OutputPersonDTO outputPersonDTO;

        outputPersonDTO = getProfileService.getFamilyMemberProfile(internalProfileDTO);

        return outputPersonDTO;
    }
}