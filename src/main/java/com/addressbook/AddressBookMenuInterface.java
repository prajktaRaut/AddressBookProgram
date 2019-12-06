package com.addressbook;

import java.io.IOException;

public interface AddressBookMenuInterface {

    public boolean createNewAddressBook(String newFileName) throws IOException;

    public boolean openExistingAddressBook(String existingAddressBook) throws IOException;

    public boolean saveAddressBook(String addressBookName) throws IOException;

    public boolean SaveAddressBookAs(String oldAddressBook,String newAddressBook) throws IOException;

   }
