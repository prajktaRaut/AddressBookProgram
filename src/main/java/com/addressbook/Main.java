package com.addressbook;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        AddressBookImplementation implementation=new AddressBookImplementation();

        String response=implementation.addPerson("Prajkta","Deshmukha","7666682585","Akola","Maharashtra","444103");

        System.out.println(response);


    }

}
