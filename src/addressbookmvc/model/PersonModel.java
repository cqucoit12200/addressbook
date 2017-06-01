package addressbookmvc.model;

import java.util.List;
import java.util.Observable;
//import java.util.Observer;

public class PersonModel extends Observable {  
   
    IPersonQueries queries;
    List< PersonEntry > results;
    int currentEntryIndex;
    int numberOfEntries;
    PersonEntry currentEntry;
    
    public PersonModel( IPersonQueries ipq ) {
        super();
        queries = ipq;
        currentEntryIndex = -1;
        numberOfEntries = 0;
        results = null;
        currentEntry = null;
    }
    
    private void setModelState() {
      numberOfEntries = results.size();
      if ( numberOfEntries > 0 ) {
         currentEntryIndex = 0;
         currentEntry = results.get( currentEntryIndex );
      }
      else {
         currentEntryIndex = -1;
         currentEntry = null;
      }
      setChanged();
      notifyObservers(currentEntry);    
    }
    
   // handles call when previousButton is clicked
   public void previousEntry() {   
      currentEntryIndex--;
      // wrap around
      if ( currentEntryIndex < 0 )
         currentEntryIndex = numberOfEntries - 1;
      currentEntry = results.get( currentEntryIndex );
      setChanged();
      notifyObservers(currentEntry);
   }

   // handles call when nextButton is clicked
   public void nextEntry() {
      currentEntryIndex++;
      // wrap around
      if ( currentEntryIndex >= numberOfEntries )
         currentEntryIndex = 0;
      currentEntry = results.get( currentEntryIndex );
      setChanged();
      notifyObservers(currentEntry);
   }

   // handles call when queryButton is clicked
   public void performQuery( String q ) {
      results = queries.getPeopleByLastName( q );
      setModelState();    
   }

   // handles call when browseButton is clicked
   public void browse() {
      results = queries.getAllPeople();
      System.err.println(results.size());
      setModelState();
   
   }

   // handles call when insertButton is clicked
   public void insertNewEntry( String lastName, String firstName, String email, String phoneNumber) {
      results = queries.addPerson( lastName, firstName, email, phoneNumber );
      setModelState(); 
   }
   
   // handles window closure
   public void close() {
      queries.close();
   }
}
