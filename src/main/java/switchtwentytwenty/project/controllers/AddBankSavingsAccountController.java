package switchtwentytwenty.project.controllers;

import switchtwentytwenty.project.domain.dtos.input.AddBankSavingsAccountDTO;
import switchtwentytwenty.project.domain.model.Application;
import switchtwentytwenty.project.domain.model.Family;
import switchtwentytwenty.project.domain.model.FamilyMember;
import switchtwentytwenty.project.domain.services.AccountService;
import switchtwentytwenty.project.domain.services.FamilyService;

public class AddBankSavingsAccountController {

    private final Application ffmApplication;

    public AddBankSavingsAccountController(Application ffmApplication) {
        this.ffmApplication = ffmApplication;
    }

    /**
     * A method that adds a BankSavingsAccount to a given FamilyMember.
     * The method will return false if there is no such Family or FamilyMember.
     * If the input data is empty or null, an account will still be created.
     *
     * @param addBankSavingsAccountDTO a DTO containing all necessary data.
     * @return true if account was created, else false.
     */
    public boolean addBankSavingsAccount(AddBankSavingsAccountDTO addBankSavingsAccountDTO) {
        boolean result;
        AccountService accountService = this.ffmApplication.getAccountService();
        try {
            accountService.addBankSavingsAccount(addBankSavingsAccountDTO);
            result = true;
        } catch (Exception exception) {
            result = false;
        }
        return result;
    }
}