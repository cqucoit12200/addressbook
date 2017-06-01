package addressbookmvc.model;

// Extension of Fig. 28.30: Person.java
// PersonEntry class that represents an entry in an address book.
public class PersonEntry
{
   private int addressID;
   private String firstName;
   private String lastName;
   private String email;
   private String phoneNumber;
   private int numberOfEntries;
   private int entryNumber;

   // no-argument constructor
   public PersonEntry()
   {
   } // end no-argument constructor

   // constructor
   public PersonEntry( int id, String first, String last, 
      String emailAddress, String phone, int i, int n )
   {
      setAddressID( id );
      setFirstName( first );
      setLastName( last );
      setEmail( emailAddress );
      setPhoneNumber( phone );
      setEntryNumber( i );
      setNumberOfEntries( n );

   } // end constructor 

   // sets the addressID
   public void setAddressID( int id )
   {
      addressID = id;
   } // end method setAddressID

   // returns the addressID 
   public int getAddressID()
   {
      return addressID;
   } // end method getAddressID
   
   // sets the firstName
   public void setFirstName( String first )
   {
      firstName = first;
   } // end method setFirstName

   // returns the first name 
   public String getFirstName()
   {
      return firstName;
   } // end method getFirstName
   
   // sets the lastName
   public void setLastName( String last )
   {
      lastName = last;
   } // end method setLastName

   // returns the last name 
   public String getLastName()
   {
      return lastName;
   } // end method getLastName
   
   // sets the email address
   public void setEmail( String emailAddress )
   {
      email = emailAddress;
   } // end method setEmail

   // returns the email address
   public String getEmail()
   {
      return email;
   } // end method getEmail
   
   // sets the phone number
   public void setPhoneNumber( String phone )
   {
      phoneNumber = phone;
   } // end method setPhoneNumber

   // returns the phone number
   public String getPhoneNumber()
   {
      return phoneNumber;
   } // end method getPhoneNumber
   
   // sets the number of entries
   public void setNumberOfEntries( int n )
   {
      numberOfEntries = n;
   } // end method setNumberOfEntries

   // gets the number of entries
   public int getNumberOfEntries()
   {
      return numberOfEntries;
   } // end method getNumberOfEntries
   
   // sets the entry number
   public void setEntryNumber( int i )
   {
      entryNumber = i;
   } // end method setEntryNumber

   // gets the entry number
   public int getEntryNumber()
   {
      return entryNumber;
   } // end method getEntryNumber
} 

/**************************************************************************
 * (C) Copyright 1992-2012 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/

 