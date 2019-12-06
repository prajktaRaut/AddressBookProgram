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

        boolean result=implementation.addPerson("AddressBook","Shreyash","Khandare","9872345345","Akola","Maharashtra","444108");
        Assert.assertTrue(result);

    }

    @Test
    public void givenMethod_EditPersonInformation() throws IOException {

        boolean result=implementation.editPerson("AddressBook","Pari","9870341454","Mumbai","Maharashtra","444106");
        Assert.assertTrue(result);
    }

    @Test
    public void givenMethod_DeletePersonInformation() throws IOException {

        boolean result=implementation.deletePerson("AddressBook","Pari");
        Assert.assertTrue(result);

    }

    @Test
    public void givenMethod_SortPersonInformation_ByName() throws IOException {

        boolean result=implementation.sortByName("AddressBook");
        Assert.assertTrue(result);

    }

    @Test
    public void givenMethod_SortPersonInformation_ByZipCode() throws IOException {

        boolean result=implementation.sortByZip("AddressBook");
        Assert.assertTrue(result);

    }

    @Test
    public void givenMethod_ShowAllData_FromAddressBook() throws IOException {

        boolean result=implementation.printAllEntries("AddressBook");
        Assert.assertTrue(result);
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

        boolean result=implementation.addPerson("NewAddressBook","Shreysha","Khandare","9872317889","Akola","Maharashtra","444106");
        Assert.assertTrue(result);
        boolean flag=services.saveAddressBook("NewAddressBook");
        Assert.assertTrue(flag);
    }

    @Test
    public void givenMethod_SaveAddressBookAs() throws IOException {

        boolean flag=services.SaveAddressBookAs("AddressBook","NewAddressBook");
        Assert.assertTrue(flag);
    }

}
