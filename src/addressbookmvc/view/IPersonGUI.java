package addressbookmvc.view;

public interface IPersonGUI {
    
    void setIdTextField(String s);
    String getIdTextField();
    void setFirstNameTextField(String s);
    String getFirstNameTextField(); 
    void setLastNameTextField(String s);
    String getLastNameTextField();
    void setEmailTextField(String s);
    String getEmailTextField();
    void setPhoneNumberTextField(String s);
    String getPhoneNumberTextField(); 
    void setMaxTextField(String s);
    String getMaxTextField(); 
    void setIndexTextField(String s);
    String getIndexTextField(); 
    void setQueryTextField(String s);
    String getQueryTextField(); 
    
    void enableNext();
    void enablePrevious();
    void disableNext();
    void disablePrevious();
    
    void showMessageDialog( String s1, String s2 );
}
