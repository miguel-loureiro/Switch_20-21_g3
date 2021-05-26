package switchtwentytwenty.project.datamodel.assemblerjpa.implassemblersjpa;

import org.junit.jupiter.api.Test;
import switchtwentytwenty.project.datamodel.domainjpa.CategoryJPA;
import switchtwentytwenty.project.datamodel.domainjpa.FamilyIDJPA;
import switchtwentytwenty.project.domain.aggregates.category.Category;
import switchtwentytwenty.project.domain.aggregates.category.CustomCategory;
import switchtwentytwenty.project.domain.aggregates.category.StandardCategory;
import switchtwentytwenty.project.domain.valueobject.CategoryID;
import switchtwentytwenty.project.domain.valueobject.CategoryName;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.domain.valueobject.ParentCategoryPath;

import static org.junit.jupiter.api.Assertions.*;


class CategoryDataDomainAssemblerTest {

    CategoryDataDomainAssembler categoryDataDomainAssembler = new CategoryDataDomainAssembler();
    CategoryJPA customCategoryJPA = new CategoryJPA("catName", 12L, "11L", new FamilyIDJPA("@famid@famid.com"));


    @Test
    void createCategoryID() {
        CategoryID expected = new CategoryID(12L);
        CategoryID result = categoryDataDomainAssembler.createCategoryID(customCategoryJPA);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void createCategoryName() {
        CategoryName expected = new CategoryName("catName");
        CategoryName result = categoryDataDomainAssembler.createCategoryName(customCategoryJPA);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void createParentID() {
        ParentCategoryPath expected = new ParentCategoryPath("11L");
        ParentCategoryPath result = categoryDataDomainAssembler.createParentID(customCategoryJPA);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void createFamilyID() {
        FamilyID expected = new FamilyID("@famid@famid.com");
        FamilyID result = categoryDataDomainAssembler.createFamilyID(customCategoryJPA).get();

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void toDataCategoryJPA() {
        CategoryJPA expected = new CategoryJPA("catName", 12L, "11", new FamilyIDJPA("@famid@famid.com"));
        Category category = new CustomCategory(new CategoryID(12L), new ParentCategoryPath("11"), new CategoryName("catname"), new FamilyID("@famid@famid.com"));
        CategoryJPA result = categoryDataDomainAssembler.toData(category);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void toDataCategoryJPANoFamilyID() {
        CategoryJPA expected = new CategoryJPA("catName", 12L, "11", null);
        Category category = new StandardCategory(new CategoryName("catName"), new CategoryID(12L), new ParentCategoryPath("11"));
        CategoryJPA result = categoryDataDomainAssembler.toData(category);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }

    @Test
    void toDataCategoryJPANoCategoryID() {
        CategoryJPA expected = new CategoryJPA("catName", null, "11", null);
        Category category = new StandardCategory(new CategoryName("catName"), null, new ParentCategoryPath("11"));
        CategoryJPA result = categoryDataDomainAssembler.toData(category);

        assertNotSame(expected, result);
        assertNotNull(result);
    }

    @Test
    void testToDataFamilyIDJPA() {
        FamilyIDJPA expected = new FamilyIDJPA("@fam@id.com");
        FamilyID familyID = new FamilyID("@fam@id.com");
        FamilyIDJPA result = categoryDataDomainAssembler.toData(familyID);

        assertNotSame(expected, result);
        assertEquals(expected, result);
    }
}