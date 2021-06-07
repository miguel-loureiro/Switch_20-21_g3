package switchtwentytwenty.project.interfaceadapters.controller.icontrollers;


import org.springframework.http.ResponseEntity;
import switchtwentytwenty.project.dto.OptionsDTO;
import switchtwentytwenty.project.dto.family.AddFamilyAndSetAdminDTO;
import switchtwentytwenty.project.dto.family.OutputFamilyDTO;
import switchtwentytwenty.project.dto.family.CreateRelationDTO;


public interface IFamilyRESTController {

    ResponseEntity<OutputFamilyDTO> createFamilyAndSetAdmin(AddFamilyAndSetAdminDTO addFamilyAndSetAdminDTO);

    ResponseEntity<OptionsDTO> familiesOptions();

    ResponseEntity<OptionsDTO> getFamilyOptions(String familyID);

    ResponseEntity<Object> createRelation(CreateRelationDTO createRelationDTO, String familyID);

    ResponseEntity<OutputFamilyDTO> getFamily(String familyName);

    ResponseEntity<Object> getCategories(String familyID);
}