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

        String result=implementation.addPerson("Pallavi","Raut","7666682585","Akola","Maharashtra","400088");

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
}
