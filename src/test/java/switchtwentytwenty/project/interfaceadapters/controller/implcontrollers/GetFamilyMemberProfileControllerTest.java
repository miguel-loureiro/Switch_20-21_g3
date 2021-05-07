package switchtwentytwenty.project.interfaceadapters.controller.ImplControllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import switchtwentytwenty.project.dto.InternalProfileDTO;
import switchtwentytwenty.project.dto.person.OutputPersonDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMemberProfileService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
class GetFamilyMemberProfileControllerTest {

    OutputPersonDTO outputPersonDTOoutput = new OutputPersonDTO();

    @Mock
    IGetFamilyMemberProfileService getProfileService;

    @InjectMocks
    GetFamilyMemberProfileController getFamilyMemberProfileController;

    @Mock
    InternalProfileDTO internalProfileDTO;

    @Test
    @DisplayName("Test if the GetFamilyMemberProfileController returns the correct DTO")
    void getFamilyMemberProfileSuccessCase() {
        String personID = "email@domain.pt";
        OutputPersonDTO expected = new OutputPersonDTO();

        Mockito.when(getProfileService.getFamilyMemberProfile(internalProfileDTO)).thenReturn(outputPersonDTOoutput);

        OutputPersonDTO result = getFamilyMemberProfileController.getFamilyMemberProfile(internalProfileDTO);

        assertNotSame(expected, result);
        assertEquals(expected, result);

    }

    @Test
    void testGetFamilyMemberProfileFailCase() {

    }
}