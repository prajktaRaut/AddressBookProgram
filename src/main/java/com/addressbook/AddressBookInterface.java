package com.addressbook;

import java.io.IOException;


public interface AddressBookInterface {

    public String addPerson(String fileName,String firstName,String lastName,String phoneNumber,String city,String state,String zipCode) throws IOException;

    public String editPerson(String fileName,String name,String phonenumber,String city,String state,String zipCode) throws IOException;

    public String deletePerson(String fileName,String name) throws IOException;

    public String sortByName(String fileName) throws IOException;

    public String sortByZip(String fileName) throws IOException;

    public void printAllEntries(String fileName) throws IOException;




    }
