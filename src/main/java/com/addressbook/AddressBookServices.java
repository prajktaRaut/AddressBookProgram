package com.addressbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AddressBookServices implements AddressBookMenuInterface {

    AddressBookImplementation implementation=new AddressBookImplementation();

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

    @Override
    public void openExistingAddressBook(String existingAddressBook) throws IOException {

        File listOfFile=new File("/home/admin1/Documents/AddressBook/src/test/resources/");

        File[] files=listOfFile.listFiles();

        System.out.println("Existing files :");
        for (File file:
             files) {

            System.out.println(file.getName());
        }

        File existFile=new File("/home/admin1/Documents/AddressBook/src/test/resources/"+existingAddressBook+".json");

        System.out.println("Existing file name is"+existFile);

        if (existFile.exists()) {
            try {
                implementation.readFromJson(existFile);
                implementation.printAllEntries(existingAddressBook);
                System.out.println("File Open Successfully.");

            } catch (Exception e) {
                System.out.println("Inside catch block");
                e.printStackTrace();
            }

        }else {

            System.out.println("File Not Found");
        }

    }

}
