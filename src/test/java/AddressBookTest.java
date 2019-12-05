import com.addressbook.AddressBookImplementation;
import com.addressbook.Person;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddressBookTest {

    AddressBookImplementation implementation=new AddressBookImplementation();

    Scanner scanner=new Scanner(System.in);

    @Test
    public void givenMethod_AddPersonInformation() throws IOException {

        String result=implementation.addPerson("Avanisha","Ingale","7666645677","Karanja","Maharashtra","400105");

        System.out.println(result);

    }

    @Test
    public void givenMethod_EditPersonInformation() throws IOException {

        String result=implementation.editPerson("Pallavi","9850178109","Pune","Maharashtra","444103");

        System.out.println(result);
    }

    @Test
    public void givenMethod_DeletePersonInformation() throws IOException {

        String reult=implementation.deletePerson("Prajkta");
        System.out.println(reult);

    }

    @Test
    public void givenMethod_SortPersonInformation_ByName() throws IOException {

        String result=implementation.sortByName();

        System.out.println(result);

    }
}
