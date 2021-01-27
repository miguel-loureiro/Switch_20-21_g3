package switch2020.project.domain.model;

import switch2020.project.domain.sandbox.Category;
import switch2020.project.domain.utils.TransferenceDTO;

public class BankAccount implements Account {

    private AccountData accountData;
    private IBAN iban;

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

    public BankAccount(String description, Double balance, Integer bankAccountID){
        if(!validateDescription(description)){
            description = "BankAccount"+" "+bankAccountID;
        }
        if(!validateBalance(balance)){
            throw new IllegalArgumentException("Inserir aproximação do balanço");
        }
        if(!validateID(bankAccountID)){
            throw new IllegalArgumentException("Inserir valor");
        }
        this.accountData = new AccountData(balance,description,bankAccountID);
    }

    /***** METHODS ******/
    // VALIDATORS
    public boolean validateDescription(String description){
        if(description == null || description.isEmpty() || description.isBlank()){
            return false;
        }
        return true;
    }

    public boolean validateBalance(Double balance){
        if( balance == null){
            return false;
        }
        return true;
    }

    public boolean validateID(Integer bankAccountID){
        if( bankAccountID == null){
            return false;
        }
        return true;
    }

    public boolean validateIBAN(String iban){
        if( iban == null){
            return false;
        }
        return true;
    }

    /**  **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount account = (BankAccount) o;
        return accountData.equals(account.accountData);
    }

    public boolean equals2(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount)) return false;
        BankAccount account = (BankAccount) o;
        return this.getBalance() == account.getBalance() && this.getDescription() == account.getDescription() && this.getAccountID() == account.getAccountID();
    }

    /*
    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
     */

    // BUSINESS METHODS
    public double getBalance(){
        return accountData.getBalance();
    }

    public String getDescription(){
        return accountData.getDescription();
    }

    public int getAccountID(){
        return accountData.getAccountID();
    }

    public void changeBalance(double value){
        double newBalance = this.accountData.getBalance() + value;
        this.accountData.setBalance(newBalance);
    }
    /*
    public void changeBalance(Double value){
        if(value == null){
            throw new IllegalArgumentException("Inserir valor válido");
        }
        double newBalance = this.data.getBalance() + value;
        this.data.setBalance(newBalance);
    }

     */

    public boolean isIDOfThisAccount(int accountID){
        return this.accountData.isIDOfThisAccount(accountID);
    }

    public boolean hasEnoughMoneyForTransaction(double transferenceAmount ){
        return accountData.hasEnoughMoneyForTransaction(transferenceAmount);
    }

    public boolean registerTransaction(Account targetAccount, StandardCategory category, TransferenceDTO transferenceDTO){
        return accountData.registerTransaction(targetAccount, category, transferenceDTO);
    }



}
