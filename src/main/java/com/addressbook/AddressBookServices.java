package com.addressbook;

import java.io.File;
import java.io.IOException;

public class AddressBookServices implements AddressBookMenuInterface {

    @Override
    public void createNewAddressBook(String newFileName) throws IOException {

        File file=new File("/home/admin1/Documents/AddressBook/src/test/resources/"+newFileName+".json");

        boolean flag=file.createNewFile();

        if (flag)
        {
            System.out.println("File has been created successfully.");
        }
        else
        {
            System.out.println("File is already present at specific location");
        }

    }

}
