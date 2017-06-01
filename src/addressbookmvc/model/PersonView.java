package addressbookmvc.model;


import addressbookmvc.model.PersonEntry;
import addressbookmvc.model.PersonModel;
import addressbookmvc.view.IPersonGUI;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author dhj
 */
public class PersonView implements Observer {
    
    IPersonGUI gui;
    
    public PersonView( PersonModel pm ) {
        pm.addObserver( this );
    }
    
    public void setGUI( IPersonGUI ipg ) {
        gui = ipg;
    }
    
    // Observer interface implementation
    @Override
    public void update( Observable obs, Object obj){
        PersonEntry e = (PersonEntry) obj;
        if ( e == null ) {
            
            gui.disableNext();
            gui.disablePrevious();
            gui.setIdTextField( "" );
            gui.setFirstNameTextField( "" );
            gui.setLastNameTextField( "" );
            gui.setEmailTextField( "" );
            gui.setPhoneNumberTextField( "" );
            gui.setMaxTextField( "" );
            gui.setIndexTextField( "" );
            gui.showMessageDialog( "Operation failed", "Status" );
            return;
        }
        
        gui.setIdTextField( "" + e.getAddressID());
        gui.setFirstNameTextField( e.getFirstName() );
        gui.setLastNameTextField( e.getLastName() );
        gui.setEmailTextField( e.getEmail() );
        gui.setPhoneNumberTextField( e.getPhoneNumber() );
        gui.setMaxTextField( "" + e.getNumberOfEntries() );
        gui.setIndexTextField( "" + e.getEntryNumber() );
        return;
    }    
}
