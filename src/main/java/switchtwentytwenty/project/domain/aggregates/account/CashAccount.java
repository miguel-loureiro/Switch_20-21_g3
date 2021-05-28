package switchtwentytwenty.project.domain.aggregates.account;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import switchtwentytwenty.project.domain.valueobject.AccountID;
import switchtwentytwenty.project.domain.valueobject.Designation;
import switchtwentytwenty.project.domain.valueobject.Movement;
import switchtwentytwenty.project.domain.valueobject.IOwnerID;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class CashAccount extends AbCashAccount{


    protected CashAccount(IOwnerID ownerID, Designation designation){
        super(ownerID, designation);

    }

    public CashAccount(){
        super();
    }

    public CashAccount(AccountID id, IOwnerID ownerID, Designation designation, List<Movement> movements) {
        super(id, ownerID, designation, movements);
    }

    @Override
    public AccountID id() {
        return super.id();
    }

    @Override
    public IOwnerID getOwnerId() {
        return super.getOwnerId();
    }

    @Override
    public Designation getDesignation() {
        return super.getDesignation();
    }

    @Override
    public List<Movement> getListOfMovements() {
        List<Movement> copyMovements = new ArrayList<>();
        if (!super.getListOfMovements().isEmpty()) {
            copyMovements.addAll(super.getListOfMovements());
        }
        return copyMovements;
    }

    @Override
    public String getAccountType() {
        return "cash";
    }

    @Override
    public void addMovement(Movement movement){
        super.addMovement(movement);
    }

    @Override
    public boolean hasID(AccountID id) {
        return super.hasID(id);
    }

    @Override
    public void setAccountID(AccountID accountID) {
        super.setAccountID(accountID);
    }

    @Override
    public void setMovements(List<Movement> movements) {
        super.setMovements(Collections.unmodifiableList(movements));
    }

    @Override
    public void setOwner(IOwnerID ownerID) {
        super.setOwner(ownerID);
    }

    @Override
    public void setDesignation(Designation designation) {
        super.setDesignation(designation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CashAccount)) return false;
        CashAccount that = (CashAccount) o;
        return Objects.equals(super.id(), that.id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.id(), super.getOwnerId(), getDesignation(), super.getListOfMovements());
    }
}