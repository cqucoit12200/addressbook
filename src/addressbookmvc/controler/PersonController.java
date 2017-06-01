package addressbookmvc.controler;


import addressbookmvc.model.PersonModel;
import addressbookmvc.view.IPersonGUI;

/**
 *
 * @author dhj
 */
public class PersonController {
    
    PersonModel model;
    IPersonGUI gui;
    
    public PersonController( PersonModel pm ) {
        model = pm;
    }
    
    // set gui
    public void setGUI( IPersonGUI ipg ) {
        gui = ipg;
    }
    
   // handles call when previousButton is clicked
   public void previousButtonAction() {
       model.previousEntry();
   }

   // handles call when nextButton is clicked
   public void nextButtonAction() 
   {
       model.nextEntry();
   } 

   // handles call when queryButton is clicked
   public void queryButtonAction()
   {
      gui.enableNext();
      gui.enablePrevious();
      String q = gui.getQueryTextField();
      model.performQuery( q );
      gui.setQueryTextField( "" );
   } 

   // handles call when browseButton is clicked
  public void browseButtonAction()
   {
      gui.enableNext();
      gui.enablePrevious();
      model.browse();
   }

   // handles call when insertButton is clicked
   public void insertButtonAction() 
   {
      gui.disableNext();
      gui.disablePrevious();
      String s1 = gui.getLastNameTextField();
      String s2 = gui.getFirstNameTextField();
      String s3 = gui.getEmailTextField();
      String s4 = gui.getPhoneNumberTextField();
      model.insertNewEntry( s1, s2, s3, s4 );
   } 
    
   // handles call when window closed
   public void closeAction() 
   {
      model.close();
   } 
   public void test(){
   
   }
}
