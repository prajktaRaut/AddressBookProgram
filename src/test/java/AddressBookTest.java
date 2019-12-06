import com.addressbook.AddressBookImplementation;
import com.addressbook.AddressBookServices;
import com.addressbook.Person;
import org.junit.Assert;
import org.junit.Test;

import javax.xml.ws.Service;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class AddressBookTest {

    AddressBookImplementation implementation=new AddressBookImplementation();

    AddressBookServices services=new AddressBookServices();

    Scanner scanner=new Scanner(System.in);

    @Test
    public void givenMethod_AddPersonInformation() throws IOException {

        String result=implementation.addPerson("NewAddressBook","Pari","Raut","9872312345","Akola","Maharashtra","444103");

        System.out.println(result);

    }

    @Test
    public void givenMethod_EditPersonInformation() throws IOException {

        String result=implementation.editPerson("AddressBook","Pari","9870341454","Mumbai","Maharashtra","444106");

        System.out.println(result);
    }

    @Test
    public void givenMethod_DeletePersonInformation() throws IOException {

        String reult=implementation.deletePerson("AddressBook","Pari");
        System.out.println(reult);

    }

    @Test
    public void givenMethod_SortPersonInformation_ByName() throws IOException {

        String result=implementation.sortByName("AddressBook");

        System.out.println(result);

    }

    @Test
    public void givenMethod_SortPersonInformation_ByZipCode() throws IOException {

        String result=implementation.sortByZip("AddressBook");

        System.out.println(result);

    }

    @Test
    public void givenMethod_ShowAllData_FromAddressBook() throws IOException {

        implementation.printAllEntries("AddressBook");

    }

    @Test
    public void givenMethod_CreateNewFile() throws IOException {

        boolean flag=services.createNewAddressBook("NewAddressBook");
        Assert.assertTrue(flag);
    }

    @Test
    public void givenMethod_OpenExistFile() throws IOException {

        boolean status=services.openExistingAddressBook("NewAddressBook");
        Assert.assertTrue(status);
    }

    @Test
    public void givenMethod_SaveAddressBook() throws IOException {

        String result=implementation.addPerson("NewAddressBook","Shreysha","Khandare","9872317889","Akola","Maharashtra","444106");
        System.out.println(result);
        boolean flag=services.saveAddressBook("NewAddressBook");
        Assert.assertTrue(flag);
    }
}
