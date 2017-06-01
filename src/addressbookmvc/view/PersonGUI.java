package addressbookmvc.view;

// Fig. 28.32: PersonView.java
// A simple address book
// Amended to conform to the MVC pattern by Dennis Jarvis September2012


import addressbookmvc.controler.PersonController;
import addressbookmvc.controler.PersonController;
import addressbookmvc.view.IPersonGUI;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class PersonGUI extends JFrame 
    implements IPersonGUI
{
   PersonController controller;
   
  
   // GUI components
   private JButton browseButton;
   private JLabel emailLabel;
   private JTextField emailTextField;
   private JLabel firstNameLabel;
   private JTextField firstNameTextField;
   private JLabel idLabel;
   private JTextField idTextField;
   private JTextField indexTextField;
   private JLabel lastNameLabel;
   private JTextField lastNameTextField;
   private JTextField maxTextField;
   private JButton nextButton;
   private JLabel ofLabel;
   private JLabel phoneLabel;
   private JTextField phoneTextField;
   private JButton previousButton;
   private JButton queryButton;
   private JLabel queryLabel;
   private JPanel queryPanel;
   private JPanel navigatePanel;
   private JPanel displayPanel;
   private JTextField queryTextField;
   private JButton insertButton;
   
   // no-argument constructor
   public PersonGUI( PersonController pc )
   {
      super( "Address Book" ); 
           
      // set controller
      controller = pc;

      // create GUI
      navigatePanel = new JPanel();
      previousButton = new JButton();
      indexTextField = new JTextField( 2 );
      ofLabel = new JLabel();
      maxTextField = new JTextField( 2 );
      nextButton = new JButton();
      displayPanel = new JPanel();
      idLabel = new JLabel();
      idTextField = new JTextField( 10 );
      firstNameLabel = new JLabel();
      firstNameTextField = new JTextField( 10 );
      lastNameLabel = new JLabel();
      lastNameTextField = new JTextField( 10 );
      emailLabel = new JLabel();
      emailTextField = new JTextField( 10 );
      phoneLabel = new JLabel();
      phoneTextField = new JTextField( 10 );
      queryPanel = new JPanel();
      queryLabel = new JLabel();
      queryTextField = new JTextField( 10 );
      queryButton = new JButton();
      browseButton = new JButton();
      insertButton = new JButton();

      setLayout( new FlowLayout( FlowLayout.CENTER, 10, 10 ) );
      setSize( 400, 355 );
      setResizable( false );

      navigatePanel.setLayout(
         new BoxLayout( navigatePanel, BoxLayout.X_AXIS ) );

      previousButton.setText( "Previous" );
      previousButton.setEnabled( false );
      previousButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               
               controller.previousButtonAction();
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      navigatePanel.add( previousButton );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      indexTextField.setHorizontalAlignment(
         JTextField.CENTER );
      
      navigatePanel.add( indexTextField );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      ofLabel.setText( "of" );
      navigatePanel.add( ofLabel );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      maxTextField.setHorizontalAlignment(
         JTextField.CENTER );
      maxTextField.setEditable( false );
      navigatePanel.add( maxTextField );
      navigatePanel.add( Box.createHorizontalStrut( 10 ) );

      nextButton.setText( "Next" );
      nextButton.setEnabled( false );
      nextButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               controller.nextButtonAction();
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      navigatePanel.add( nextButton );
      add( navigatePanel );

      displayPanel.setLayout( new GridLayout( 5, 2, 4, 4 ) );

      idLabel.setText( "Address ID:" );
      displayPanel.add( idLabel );
      idTextField.setEditable( false );
      displayPanel.add( idTextField );

      firstNameLabel.setText( "First Name:" );
      displayPanel.add( firstNameLabel );
      displayPanel.add( firstNameTextField );

      lastNameLabel.setText( "Last Name:" );
      displayPanel.add( lastNameLabel );
      displayPanel.add( lastNameTextField );

      emailLabel.setText( "Email:" );
      displayPanel.add( emailLabel );
      displayPanel.add( emailTextField );

      phoneLabel.setText( "Phone Number:" );
      displayPanel.add( phoneLabel );
      displayPanel.add( phoneTextField );
      add( displayPanel );

      queryPanel.setLayout( 
         new BoxLayout( queryPanel, BoxLayout.X_AXIS) );

      queryPanel.setBorder( BorderFactory.createTitledBorder(
         "Find an entry by last name" ) );
      queryLabel.setText( "Last Name:" );
      queryPanel.add( Box.createHorizontalStrut( 5 ) );
      queryPanel.add( queryLabel );
      queryPanel.add( Box.createHorizontalStrut( 10 ) );
      queryPanel.add( queryTextField );
      queryPanel.add( Box.createHorizontalStrut( 10 ) );

      queryButton.setText( "Find" );
      queryButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               controller.queryButtonAction();
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      queryPanel.add( queryButton );
      queryPanel.add( Box.createHorizontalStrut( 5 ) );
      add( queryPanel );

      browseButton.setText( "Browse All Entries" );
      browseButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               controller.browseButtonAction();
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

      add( browseButton );

      insertButton.setText( "Insert New Entry" );
      insertButton.addActionListener(
         new ActionListener()
         {
            public void actionPerformed( ActionEvent evt )
            {
               controller.insertButtonAction();
            } // end method actionPerformed
         } // end anonymous inner class
      ); // end call to addActionListener

	   add( insertButton );

      addWindowListener( 
         new WindowAdapter() 
         {  
            public void windowClosing( WindowEvent evt )
            {
               controller.closeAction();
               System.exit( 0 );
            } // end method windowClosing
         } // end anonymous inner class
      ); // end call to addWindowListener
	
      setVisible( true );
   } // end no-argument constructor

    // IPersonGUI interface implementation
   
    public void setIdTextField(String s) { idTextField.setText(s); } 
    public String getIdTextField() { return idTextField.getText(); }
    
    public void setFirstNameTextField(String s) { firstNameTextField.setText(s); }
    public String getFirstNameTextField() { return firstNameTextField.getText(); }
    
    public void setLastNameTextField(String s) { lastNameTextField.setText(s); } 
    public String getLastNameTextField() { return lastNameTextField.getText(); }
    
    public void setEmailTextField(String s) { emailTextField.setText(s); }
    public String getEmailTextField() { return emailTextField.getText(); }
    
    public void setPhoneNumberTextField(String s) { phoneTextField.setText(s); } 
    public String getPhoneNumberTextField() { return phoneTextField.getText(); } 
    
    public void setMaxTextField(String s) { maxTextField.setText(s); }
    public String getMaxTextField() { return maxTextField.getText(); }
    
    public void setIndexTextField(String s) { indexTextField.setText(s); }
    public String getIndexTextField() { return indexTextField.getText(); }
    
    public void setQueryTextField(String s) { queryTextField.setText(s); }
    public String getQueryTextField() { return queryTextField.getText(); }
  
    public void enableNext() { nextButton.setEnabled( true ); }
    public void enablePrevious() { previousButton.setEnabled( true ); }
    public void disableNext() { nextButton.setEnabled( false ); }
    public void disablePrevious() { previousButton.setEnabled( false ); }
    
    public void showMessageDialog(String s1, String s2) {
        JOptionPane.showMessageDialog( this, s1, s2, JOptionPane.PLAIN_MESSAGE );
    } 
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

 