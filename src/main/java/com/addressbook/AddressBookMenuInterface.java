package com.addressbook;

import java.io.IOException;

public interface AddressBookMenuInterface {

    public void createNewAddressBook(String newFileName) throws IOException;

    public void openExistingAddressBook(String existingAddressBook) throws IOException;

   }
