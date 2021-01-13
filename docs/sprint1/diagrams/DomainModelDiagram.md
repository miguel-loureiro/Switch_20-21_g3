# Domain Model Diagram

```puml
hide empty members
hide circles
left to right direction
title Domain Model Diagram SP01

class Family {
UniqueID
Name
RegistrationDate
}

class FamilyMember {
Name
BirthDate
}

class CCnumber {
}

class PhoneNumber {
}

class EmailAddress {
}

class VatNumber {
}

class Address {
Street
Postal Code
Local
City
}

class CashAccount {
UniqueID
Balance
}

class Relation {
Designation
}

class Category {
UniqueID
Name
}

Family "*" -- "*" Category : \n\nhas standard >
Family "1" -- "0..*" Category : \n\nhas custom >
Family "1" -- "1" CashAccount : has >
Family "1" -- "1" FamilyMember : has administrator >
Family "1" -- "1..*" FamilyMember : has members >
FamilyMember "1" -- "0..1" Relation : has >
FamilyMember "1" -- "1" CCnumber : has >
FamilyMember "1" -- "0..*" PhoneNumber : has >
FamilyMember "1" -- "0..*" EmailAddress : has >
FamilyMember "1" -- "1" VatNumber : has >
FamilyMember "1" -- "1" Address : has >
```