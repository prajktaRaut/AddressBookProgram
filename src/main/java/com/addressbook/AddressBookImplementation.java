package com.addressbook;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookImplementation implements AddressBookInterface {

    List<Person> personInformation =new ArrayList<>();

    Gson gson=new Gson();

    ObjectMapper mapper=new ObjectMapper();

    Person person= new Person();
    Address address=new Address();

    String fileName="/home/admin1/Documents/AddressBook/src/test/resources/AddressBook.json";

    @Override
    public String addPerson(String firstName, String lastName, String phoneNumber, String city,String state,String zipCode) throws IOException {

        readFromJson(fileName);

        address.setCity(city);
        address.setState(state);
        address.setZipCode(zipCode);

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhoneNumber(phoneNumber);
        person.setAddress(address);

        personInformation.add(person);

        String output=writeIntoJson();

        return output;
    }



    public String writeIntoJson() throws IOException {

        String json=gson.toJson(personInformation);

        FileWriter writer=new FileWriter("/home/admin1/Documents/AddressBook/src/test/resources/AddressBook.json");

        writer.write(json);
        writer.close();

        return "Write successfully.....";

    }

    public void readFromJson(String fileName) throws IOException {

        this.fileName=fileName;
        this.personInformation=mapper.readValue(new File(this.fileName), new TypeReference<List<Person>>()
        {
        });

    }


}
