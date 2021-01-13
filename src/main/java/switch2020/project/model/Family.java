package switch2020.project.model;

import switch2020.project.utils.FamilyWithoutAdministratorDTO;

import java.util.*;

public class Family {

    // Attributes

    private int familyID;
    private String familyName;
    private Date registrationDate;
    //private FamilyMember familyAdministrator;
    private List<FamilyMember> familyMembers;
    private List<String> relationDesignations = new ArrayList<>();
    private CashAccount familyCashAccount = null;
    private List<CustomCategory> familyCustomCategories = new ArrayList<>();

    /********************** CONSTRUCTORS ***************/
    //Constructors

    /**
     * Constructor for an empty Family, uses the current date as the registation date for the created family
     *
     * @param familyName String with Name of the family to be created
     */
    public Family(String familyName, int familyID) {
        if (!isNameValid(familyName)) throw new IllegalArgumentException("Invalid Name");
        this.familyMembers = new ArrayList<>();
        this.registrationDate = new Date();
        this.familyName = familyName; //.trim().toUpperCase() o nome da familia não deve necessitar do uppercase uma vez que a familia começa sempre por maiuscula
        this.familyID = familyID;
    }

    /**
     * Constructor for an empty family for registrations requiring a different registration date
     * @param familyName String with the name of the family to be created
     * @param registrationDate Date of the registration of the given family
     */
    public Family(String familyName, Date registrationDate, int familyID) {
        if (!isNameValid(familyName)) throw new IllegalArgumentException("Invalid Name");
        if (!isDateValid(registrationDate)) throw new IllegalArgumentException("Invalid Registration Date");
        this.familyMembers = new ArrayList<>();
        this.registrationDate = registrationDate;
        this.familyName = familyName; //.trim().toUpperCase() o nome da familia não deve necessitar do uppercase uma vez que a familia começa sempre por maiuscula
        this.familyID = familyID;
    }

    // Validations

    private boolean isNameValid(String familyName) {
        if (familyName == null || familyName.isBlank() || familyName.isEmpty()) return false;

        return true;
    }

    private boolean isDateValid(Date registrationDate) {
        Date today = new Date();
        if (registrationDate.after(today)) return false; //means registration date is after current date
        return true;
    }

    /********************** GETTERS AND SETTERS **********************/

    public List<FamilyMember> getFamilyMembers() {

        return Collections.unmodifiableList(familyMembers);
    }

    // Get and Setter methods
    /**
     * Method to return family ID
     *
     * @return family ID
     */

    public int getFamilyID() {
        return familyID;
    }

    public List<CustomCategory> getFamilyCustomCategories() {
        return familyCustomCategories;
    }

    // Business methods


    /**
     * Method to find the index of a family member with a specific ID in the Family ArrayList
     *
     * @param ccNumber Integer representing the ID to find
     * @return Int corresponding to the index of the family member that has the passed ID
     * @throws IllegalArgumentException if there is no family member with the passed ID
     */

    private int findFamilyMemberIndexByID(String ccNumber) {
        int index = 0;
        for (FamilyMember member : this.familyMembers) {
            if (member.getID() == ccNumber) {
                return index;
            }
            index++;
        }
        throw new IllegalArgumentException("No family member with that ID was found");
    }

    /**
     * Method to verify if a given Family Member is Administrator
     *
     * @param ccNumber Family Member ID to verify
     * @return boolean
     */

    public boolean isAdmin(String ccNumber) {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.getFamilyMemberID().equals(ccNumber))
                return familyMember.isAdmin();
        }
        return false;
    }

    /**
     * Method to verify if a given relation designation has been already added to a list os given relation designations
     *
     * @param relationDesignation String with the designation of the relation
     * @return boolean
     */

    public boolean hasDesignation(String relationDesignation) {
        for (String relationDesigantion : relationDesignations) {
            if (relationDesigantion.toLowerCase().equals(relationDesignation.toLowerCase()))
                return true;
        }
        return false;
    }

    private boolean checkIfVatExists(int vat) {
        ArrayList<Integer> vatList = new ArrayList();
        for ( FamilyMember member : familyMembers ) {
            vatList.add(member.getVatNumber());
        }
        for ( Integer nif : vatList) {
            if( nif == vat){
                return true;
            }
        }
        return false;
    }

    /**
     * Method to add a relation designation to list of relation designations
     *
     * @param relation String relation designation
     * @return boolean
     */

    public boolean addToRelationDesignationList(String relation) {
        return relationDesignations.add(relation);
    }

    /**
     * Method to add a Relation to A family Member
     *
     * @param ccNumber FamilyMemberID of the member to be added a Relation
     * @param relationDeignation Relation Designation to be added
     * @return boolean
     */

    public boolean addRelationToFamilyMember(String ccNumber, String relationDeignation) {
        FamilyMember familyMember = getFamilyMember(ccNumber);

        familyMember.addRelation(relationDeignation);

        return true;
    }

    /**
     * Method to get a Famaly Member by ID
     *
     * @param ccNumber FamilyMemberID to search
     * @return FamilyMember with given ID
     */

    public FamilyMember getFamilyMember(String ccNumber) {
        for (FamilyMember familyMember : familyMembers) {
            if (familyMember.getFamilyMemberID().equals(ccNumber))
                return familyMember;
        }
        // If given ID is not present, a expection is throw
        throw new IllegalArgumentException("No family member with such ID");
    }

    /**
     * Method to add a Family Member to list of FamilyMembers
     *
     * @param familyMember FamilyMember to add to list
     */

    public void addFamilyMember(FamilyMember familyMember) {
        this.familyMembers.add(familyMember);
    }

    /**
     * Method to add a Family Member Array to list of FamilyMembers
     *
     * @param familyMembers FamilyMember arry to add to list
     */

    public void addFamilyMemberArray(ArrayList<FamilyMember> familyMembers) {
        this.familyMembers.addAll(familyMembers);
    }

    /**
     * Method return the number of Family Members in List -> familyMembers
     *
     * @return number of Family Members
     */

    public int numberOfFamilyMembers() {
        return this.familyMembers.size();
    }

    /**
     * Method return the number of Family Members in List -> relationsDesignations
     *
     * @return number of relation designations
     */

    public int numberOfRelationDesignations() {
        return this.relationDesignations.size();

    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Family)) return false;
        Family otherFamily = (Family) other;
        return (this.familyID==otherFamily.familyID && this.familyName.equals(otherFamily.familyName));
    }


    /********************** USER STORIES **********************/

    /**
     * Method to add an EmailAddress object with the passed email address string to the FamilyMember with the passed ID
     *
     * @param emailToAdd String of the email address to add
     * @param ccNumber Integer representing the family member's ID
     * @return True if email successfully added to the Family Member with the passed ID
     */

    public boolean addEmail(String emailToAdd, String ccNumber) {
        FamilyMember targetMember = familyMembers.get(findFamilyMemberIndexByID(ccNumber));
        return targetMember.addEmail(emailToAdd);
    }

    public boolean addFamilyMember(String cc, String name, Date birthDate, int phone, String email, int vat, String street, String codPostal, String local, String city, Relation relationship){
        if(!checkIfVatExists(vat)){
            FamilyMember newFamilyMember = new FamilyMember(cc, name, birthDate, phone, email, vat, street, codPostal, local, city, relationship);
            familyMembers.add(newFamilyMember);
            return true;
        } else {
            throw new IllegalArgumentException("Vat already exists in the Family");
        }
    }

    public boolean addFamilyAdministrator(String ccNumber, String name, Date birthDate, int phone, String email, int vat, String street, String codPostal, String local, String city, Relation relationship){
        boolean administrator = true;
        if(!checkIfVatExists(vat)){
            FamilyMember newFamilyMember = new FamilyMember(ccNumber, name, birthDate, phone, email, vat, street, codPostal, local, city, relationship, administrator);
            familyMembers.add(newFamilyMember);
            return true;
        } else {
            throw new IllegalArgumentException("Vat already exists in the Family");
        }
    }

    /**
     * Method that creates a cash account for this family and stores it in this family's attributes
     *
     * @return returns true if an account was successfully created and stored
     */
    public boolean createFamilyCashAccount(double balance) {
        boolean success = false;
        if (!hasCashAccount()){
            this.familyCashAccount = new CashAccount(balance);
            success = true;
        }
        return success;
    }

    /**
     * Method that returns if a cash account has already been created for a this family
     *
     * @return returns true if a cash account alreay exists
     */

    private boolean hasCashAccount() {
        boolean hasCashAccount = false;
        if (this.familyCashAccount != null) {
            hasCashAccount = true;
        }
        return hasCashAccount;
    }

    /**
     * Method to verify if a Family has an administrator
     * @return boolean
     */

    public boolean hasAdministrator () {
        for (FamilyMember familyMember : familyMembers) {
            if(familyMember.isAdmin())
                return true;
        }
        return false;
    }

    /**
     * Method to create a DTO (familyWithoutAdministratorDTO) with name and id of a Family
     * @return aFamilyWithoutAdministratorDTO
     */

    public FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO() {
        FamilyWithoutAdministratorDTO familyWithoutAdministratorDTO = new FamilyWithoutAdministratorDTO(this.familyName, this.familyID);
     return  familyWithoutAdministratorDTO;
    }
}