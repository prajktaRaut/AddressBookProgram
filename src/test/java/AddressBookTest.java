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
    public void addPerson() throws IOException {

        String result=implementation.addPerson("Prajkta","Raut","7666682585","Mumbai","Maharashtra","400088");

        System.out.println(result);

    }

}
