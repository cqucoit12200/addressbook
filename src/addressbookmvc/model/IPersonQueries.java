package addressbookmvc.model;

import java.util.List;

public interface IPersonQueries {
      List< PersonEntry > getAllPeople();
      List< PersonEntry > getPeopleByLastName( String name );
      List< PersonEntry > addPerson( String fname, String lname, String email, String num );
      void close();
}
