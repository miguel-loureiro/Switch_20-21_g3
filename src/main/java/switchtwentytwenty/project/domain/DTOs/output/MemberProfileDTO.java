package switchtwentytwenty.project.domain.DTOs.output;

import switchtwentytwenty.project.domain.model.Relation;
import switchtwentytwenty.project.domain.model.user_data.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberProfileDTO {

    private String ccNumber;
    private String name;
    private Date birthDate;
    private List<PhoneNumber> phoneNumbers = new ArrayList();
    private List<EmailAddress> emails = new ArrayList<>();
    private VatNumber vatNumber;
    private Address address;
    private boolean administrator;


    public MemberProfileDTO(CCNumber ccNumber, String name, Date birthDate, List<PhoneNumber> phoneNumbers, List<EmailAddress> emails, VatNumber vatNumber, Address address, boolean administrator) {
        this.ccNumber = ccNumber.getCcNumber();
        this.name = name;
        this.birthDate = (Date) birthDate.clone();
        List<PhoneNumber> phoneNumbersClone = new ArrayList<>();
        phoneNumbersClone.addAll(phoneNumbers);
        this.phoneNumbers = phoneNumbersClone;
        List<EmailAddress> emailsCopy = new ArrayList<>();
        emailsCopy.addAll(emails);
        this.emails = emailsCopy;
        this.vatNumber = vatNumber;
        this.address = address;
        this.administrator = administrator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemberProfileDTO)) return false;
        MemberProfileDTO that = (MemberProfileDTO) o;

        return ccNumber==that.ccNumber && administrator == that.administrator && name.equals(that.name) && birthDate.equals(that.birthDate) && phoneNumbers.equals(that.phoneNumbers) && emails.equals(that.emails) && vatNumber.equals(that.vatNumber) && address.equals(that.address);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(name, birthDate, phoneNumbers, emails, vatNumber, address, administrator);
    }*/
}
