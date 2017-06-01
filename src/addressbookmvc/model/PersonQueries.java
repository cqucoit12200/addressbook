package addressbookmvc.model;

// Fig. 28.31: PersonQueries.java
// PreparedStatements used by the Address Book application
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class PersonQueries implements IPersonQueries
{
   private static final String URL = "jdbc:derby://localhost:1527/AddressBook";
   private static final String USERNAME = "deitel";
   private static final String PASSWORD = "deitel";

   private Connection connection = null; // manages connection
   private PreparedStatement selectAllPeople = null; 
   private PreparedStatement selectPeopleByLastName = null; 
   private PreparedStatement insertNewPerson = null; 
    
   // constructor
   public PersonQueries()
   {
      try 
      {
         connection = 
            DriverManager.getConnection( URL, USERNAME, PASSWORD );

         // create query that selects all entries in the AddressBook
         selectAllPeople = 
            connection.prepareStatement( "SELECT * FROM Addresses" );
         
         // create query that selects entries with a specific last name
         selectPeopleByLastName = connection.prepareStatement( 
            "SELECT * FROM Addresses WHERE LastName = ?" );
         
         // create insert that adds a new entry into the database
         insertNewPerson = connection.prepareStatement( 
            "INSERT INTO Addresses " + 
            "( FirstName, LastName, Email, PhoneNumber ) " + 
            "VALUES ( ?, ?, ?, ? )" );
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
         System.exit( 1 );
      } // end catch
   } // end PersonQueries constructor
   
   // select all of the addresses in the database
   public List< PersonEntry > getAllPeople()
   {
      List< PersonEntry > results = null;
      ResultSet resultSet = null;
      
      try 
      {
         // executeQuery returns ResultSet containing matching entries
         resultSet = selectAllPeople.executeQuery(); 
         results = new ArrayList< PersonEntry >();
         int n = 0;
         while ( resultSet.next() )
         {
            results.add( new PersonEntry(
               resultSet.getInt( "AddressID" ),
               resultSet.getString( "FirstName" ),
               resultSet.getString( "LastName" ),
               resultSet.getString( "Email" ),
               resultSet.getString( "PhoneNumber" ), 
               ++n,
               0
            ) );
         } // end while
         
         // Result sets don't have a size() method
         for (PersonEntry pe : results )
             pe.setNumberOfEntries(n);
         
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();         
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      return results;
   } // end method getAllPeople
   
   // select person by last name   
   public List< PersonEntry > getPeopleByLastName( String name )
   {
      List< PersonEntry > results = null;
      ResultSet resultSet = null;

      try 
      {
         selectPeopleByLastName.setString( 1, name ); // specify last name

         // executeQuery returns ResultSet containing matching entries
         resultSet = selectPeopleByLastName.executeQuery(); 

         results = new ArrayList< PersonEntry >();
         int n = 0;
         while ( resultSet.next() )
         {
            results.add( new PersonEntry( 
               resultSet.getInt( "AddressID" ),
               resultSet.getString( "FirstName" ),
               resultSet.getString( "LastName" ),
               resultSet.getString( "Email" ),
               resultSet.getString( "PhoneNumber" ),
               ++n,
               0
            ) );
         } // end while
         
         // Result sets don't have a size() method
         for (PersonEntry pe : results )
             pe.setNumberOfEntries(n);
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      } // end catch
      finally
      {
         try 
         {
            resultSet.close();
         } // end try
         catch ( SQLException sqlException )
         {
            sqlException.printStackTrace();         
            close();
         } // end catch
      } // end finally
      
      return results;
   } // end method getPeopleByName
   
   // add an entry
   public List <PersonEntry> addPerson( 
      String fname, String lname, String email, String pnumber ) {
      int result = 0;
      List< PersonEntry > results = null;
      
      // set parameters, then execute insertNewPerson
      try 
      {
         insertNewPerson.setString( 1, fname );
         insertNewPerson.setString( 2, lname );
         insertNewPerson.setString( 3, email );
         insertNewPerson.setString( 4, pnumber );

         // insert the new entry; returns # of rows updated
         result = insertNewPerson.executeUpdate(); 
         results = new ArrayList< PersonEntry >();
         if ( result == 1 )
             // just use id = -1 for now ...
             results.add( new PersonEntry( -1, fname, lname, email, pnumber, 1, 1 ) );
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
         close();
      } // end catch
      
      return results;
   } // end method addPerson
   
   // close the database connection
   public void close()
   {
      try 
      {
         connection.close();
      } // end try
      catch ( SQLException sqlException )
      {
         sqlException.printStackTrace();
      } // end catch
   } // end method close
} // end class PersonQueries


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

 