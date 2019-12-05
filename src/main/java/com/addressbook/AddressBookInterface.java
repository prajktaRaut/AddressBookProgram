package com.addressbook;

import java.io.IOException;
import java.util.List;

public interface AddressBookInterface {

    public String addPerson(String firstName,String lastName,String phoneNumber,String city,String state,String zipCode) throws IOException;

    public String editPerson(String name,String phonenumber,String city,String state,String zipCode) throws IOException;

    public String deletePerson(String name) throws IOException;


    }