package addressbookmvc;


import addressbookmvc.view.PersonGUI;
import addressbookmvc.model.PersonQueries;
import addressbookmvc.model.PersonModel;
import addressbookmvc.controler.PersonController;
import addressbookmvc.controler.PersonController;
import addressbookmvc.model.PersonView;
import addressbookmvc.model.PersonView;

/**
 *
 * @author dhj
 */
public class AddressBook {
   
   // main method
   public static void main( String args[] )
   {
       PersonQueries pq = new PersonQueries();
       PersonModel pm = new PersonModel(  pq );
       PersonController pc = new PersonController( pm );
       PersonView pv = new PersonView( pm );
       PersonGUI pg = new PersonGUI( pc );
       pc.setGUI( pg );
       pv.setGUI( pg );
       
   } // end method main
}
