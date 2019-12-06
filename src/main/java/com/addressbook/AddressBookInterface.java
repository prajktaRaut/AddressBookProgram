package com.addressbook;

import java.io.IOException;


public interface AddressBookInterface {

    public boolean addPerson(String fileName,String firstName,String lastName,String phoneNumber,String city,String state,String zipCode) throws IOException;

    public boolean editPerson(String fileName,String name,String phonenumber,String city,String state,String zipCode) throws IOException;

    public boolean deletePerson(String fileName,String name) throws IOException;

    public boolean sortByName(String fileName) throws IOException;

    public boolean sortByZip(String fileName) throws IOException;

    public boolean printAllEntries(String fileName) throws IOException;




    }
