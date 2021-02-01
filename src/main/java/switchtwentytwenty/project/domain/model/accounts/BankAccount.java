package switchtwentytwenty.project.domain.model.accounts;


import switchtwentytwenty.project.domain.dtos.MoneyValue;
import switchtwentytwenty.project.domain.model.categories.StandardCategory;
import switchtwentytwenty.project.domain.sandbox.IBAN;
import switchtwentytwenty.project.domain.dtos.input.AddBankAccountDTO;
import switchtwentytwenty.project.domain.model.categories.Category;
import switchtwentytwenty.project.domain.sandbox.Transaction;
import switchtwentytwenty.project.domain.utils.CurrencyEnum;

import java.util.List;

public class BankAccount implements Account {

    private final AccountType accountType = new AccountType(AccountTypeEnum.BANKACCOUNT);
    private AccountData accountData;
    //private IBAN iban;

    /***** CONSTRUCTORS ******/
    /*
    public BankAccount(String description, double balance, int bankAccountID, String iban){
        if(!validateDescription(description)){
            description = "BankAccount"+" "+bankAccountID;
        }
        if(!validateBalance(balance)){
            throw new IllegalArgumentException("Inserir aproximação do balanço");
        }
        if(!validateID(bankAccountID)){
            throw new IllegalArgumentException("Inserir valor");
        }
        this.data = new AccountData(balance,description,bankAccountID);

        if(validateIBAN(iban)){
            IBAN ibann = new IBAN(iban);
            this.iban = ibann;
        }
    }

     */
    public BankAccount(AddBankAccountDTO addBankAccountDTO, Integer bankAccountID) {
        double balance = addBankAccountDTO.getBalance();
        if (!validateBalance(balance)) {
            balance = 0.00;
        }
        String description = addBankAccountDTO.getDescription();
        if (!validateDescription(description)){
            description = "BankAccount" + " " + bankAccountID;
        }
        this.accountData = new AccountData(balance, description, bankAccountID);

    }
    public BankAccount(String description, Double balance, Integer bankAccountID) {
        if (!validateDescription(description)) {
            description = "BankAccount" + " " + bankAccountID;
        }
        if (!validateBalance(balance)) {
            balance = 0.00;
        }
        this.accountData = new AccountData(balance, description, bankAccountID);
    }

    public BankAccount(String description, Double balance, Integer bankAccountID, CurrencyEnum currencyEnum) {
        if (!validateDescription(description)) {
            description = "BankAccount" + " " + bankAccountID;
        }
        if (!validateBalance(balance)) {
            balance = 0.00;
        }
        this.accountData = new AccountData(balance, description, bankAccountID, currencyEnum);
    }

    /***** METHODS ******/
    // VALIDATORS
    public boolean validateDescription(String description) {
        if (description == null || description.isEmpty() || description.trim().length() == 0) return false;
        return true;
    }

    public boolean validateBalance(Double balance) {
        if (balance == null) {
            return false;
        }
        return true;
    }

    /*
    public boolean validateIBAN(String iban){
        if( iban == null){
            return false;
        }
        return true;
    }
     */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount account = (BankAccount) o;
        return accountData.equals(account.accountData);
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
     */

    // BUSINESS METHODS
    public String getDescription() {
        return accountData.getDescription();
    }

    public int getAccountID() {
        return accountData.getAccountID();
    }

    public void changeBalance(MoneyValue value) { // TODO: adicionar CurrencyEnum como argumento
        MoneyValue newBalance = new MoneyValue(this.accountData.getMoneyValue().getValue() + value.getValue(), CurrencyEnum.EURO); //this.accountData.getBalance() + value;
        this.accountData.setBalance(newBalance);
    }

    public boolean isIDOfThisAccount(int accountID) {
        return this.accountData.isIDOfThisAccount(accountID);
    }

    public boolean hasEnoughMoneyForTransaction(MoneyValue transferenceAmount) {
        // return accountData.hasEnoughMoneyForTransaction(transferenceAmount); // TODO: voltar a colocar desta forma quando o MoneyValue tiver aplicado em toda a APP
        if (transferenceAmount.getValue() < 0)
            throw new IllegalArgumentException("The transaction ammount needs to be a positive value");
        return ((this.getMoneyBalance().getValue() - transferenceAmount.getValue()) >= 0);
    }

    public boolean checkAccountType(AccountTypeEnum accountTypeEnum) {
        return this.accountType.getAccountType().equals(accountTypeEnum);
    }

    public MoneyValue getMoneyBalance() {
        return this.accountData.getCurrentBalance();
    }

    /**
     * A method that returns the list of movements stored in this account's AccountData attribute
     *
     * @return List of movements
     */
    public List<Transaction> getListOfMovements() {
        return this.accountData.getListOfMovements();
    }

    public void debit(MoneyValue value) { //expense

    }

    public void credit(MoneyValue value) { //expense

    }

    public boolean checkCurrency(CurrencyEnum currency){
        return accountData.checkCurrency(currency);
    }


}
