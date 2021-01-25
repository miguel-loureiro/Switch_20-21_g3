package switch2020.project.controllers;

import org.junit.jupiter.api.Test;
import switch2020.project.domain.model.*;
import switch2020.project.domain.services.AccountService;
import switch2020.project.domain.services.FamilyService;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

class AddCreditCardAccountControllerTest {

   // family1 data
    int family1ID = 5;
    String family1Name = "Silva";
    Family silva = new Family(family1Name, family1ID);

    // family1 member1 data
    String cc1 = "166699209ZY8";
    String name1 = "Ze";
    Date date1 = new Date(1970, 1, 2);
    int numero1 = 931456789;
    String email1 = "ze90@gmail.com";
    int nif1 = 231874316;
    String rua1 = "Rua dos Abracos";
    String codPostal1 = "4000-011";
    String local1 = "Porto";
    String city1 = "Porto";
    String relacao1 = "pai";
    Relation relation1 = new Relation(relacao1);
    boolean admin1 = true;

    // family1 member2 data
    String cc2 = "137476450ZX0";
    String name2 = "Maria";
    Date date2 = new Date(2001, 6, 12);
    int numero2 = 938036428;
    String email2 = "maria303@gmail.com";
    int nif2 = 299525295;
    String rua2 = "Rua dos Carqueijais";
    String codPostal2 = "4000-181";
    String local2 = "Porto";
    String city2 = "Porto";
    String relacao2 = "filha";
    Relation relation2 = new Relation(relacao2);
    boolean admin2 = false;

    // add member1 and member2 to family

    FamilyMember maria = new FamilyMember(cc1, name1, date1, numero1, email1, nif1, rua1, codPostal1, local1, city2, admin1);

    @Test
    void addCreditCardAccountToFamilyMemberTrue() {

        Application app = new Application();
        FamilyMember ze = new FamilyMember(cc1, name1, date1, numero1, email1, nif1, rua1, codPostal1, local1, city2, admin1);
        AddCreditCardAccountController addCreditCardAccountController = new AddCreditCardAccountController(app);
        /*CreditCardAccount visaZe = new CreditCardAccount(5000,"Visa do Ze",12 );
        addCreditCardAccountController.addCreditCardAccountToFamilyMember(ze.getID(), family1ID,"Cartao VISA Ze", 1000);
*/

    }

    @Test
    void addCreditCardAccountToFamilyMemberTrueWithCardDescriptionNull() {

    }

    @Test
    void addCreditCardAccountToFamilyMemberFalseFamilyDoesNotExist() {

    }

    @Test
    void addCreditCardAccountToFamilyMemberFalseFamilyMemberDoesNotExist() {
    }
}