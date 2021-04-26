package switchtwentytwenty.project.domain.aggregates.ledger;

import switchtwentytwenty.project.domain.aggregates.AggregateRoot;
import switchtwentytwenty.project.domain.valueobject.LedgerID;
import switchtwentytwenty.project.domain.valueobject.ID;

import java.util.UUID;

public class Ledger implements AggregateRoot {

    private LedgerID id;

    public Ledger(UUID id) {
        this.id = new LedgerID(id);
    }

    @Override
    public ID id() {
        return null;
    }

    @Override
    public boolean hasID(ID id) {
        return false;
    }
}
