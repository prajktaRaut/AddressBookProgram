package com.addressbook;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
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

    @Override
    public String editPerson(String name,String phonenumber, String city, String state, String zipCode) throws IOException {

        readFromJson(fileName);

        for (int i=0;i<personInformation.size();i++)
        {
            if (personInformation.get(i).getFirstName().equals(name))
            {
                personInformation.get(i).setPhoneNumber(phonenumber);
                personInformation.get(i).getAddress().setCity(city);
                personInformation.get(i).getAddress().setState(state);
                personInformation.get(i).getAddress().setZipCode(zipCode);
            }
        }
        writeIntoJson();
        return "Edit Successfully";
    }

    @Override
    public String deletePerson(String name) throws IOException {

        readFromJson(fileName);
        personInformation.removeIf(Person->Person.getFirstName().equals(name));

        writeIntoJson();

        return "Delete successfully";
    }

    @Override
    public String sortByName() throws IOException {

        readFromJson(fileName);
        Collections.sort(personInformation);
        writeIntoJson();

        return "Data sorted by name Successfully";
    }

    @Override
    public String sortByZip() throws IOException {

            readFromJson(fileName);
            for(int i=0;i<personInformation.size()-1;i++)
            {
                for (int j = 0; j < personInformation.size() - i - 1; j++)
                {
                    if (personInformation.get(j).getAddress().getZipCode().compareTo(personInformation.get(j + 1).getAddress().getZipCode()) > 0)
                    {
                        Person temp=personInformation.get(j);
                        personInformation.set(j,personInformation.get(j+1));
                        personInformation.set(j+1,temp);
                    }
                }
            }
            writeIntoJson();
            return "Sorted By Zip Successfully";


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
