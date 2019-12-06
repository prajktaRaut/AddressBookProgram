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

    File fileName=new File("/home/admin1/Documents/AddressBook/src/test/resources/AddressBook.json");

    @Override
    public String addPerson(String fileName,String firstName, String lastName, String phoneNumber, String city,String state,String zipCode) throws IOException {

        try {
            readFromJson(new File("/home/admin1/Documents/AddressBook/src/test/resources/" + fileName + ".json"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        address.setCity(city);
        address.setState(state);
        address.setZipCode(zipCode);

        person.setFirstName(firstName);
        person.setLastName(lastName);
        person.setPhoneNumber(phoneNumber);
        person.setAddress(address);

        personInformation.add(person);

        String output=writeIntoJson(fileName);

        return output;

    }

    @Override
    public String editPerson(String fileName,String name,String phonenumber, String city, String state, String zipCode) throws IOException {

        readFromJson(new File("/home/admin1/Documents/AddressBook/src/test/resources/"+fileName+".json"));

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
        writeIntoJson(fileName);
        return "Edit Successfully";
    }

    @Override
    public String deletePerson(String fileName,String name) throws IOException {

        readFromJson(new File("/home/admin1/Documents/AddressBook/src/test/resources/"+fileName+".json"));
        personInformation.removeIf(Person->Person.getFirstName().equals(name));

        writeIntoJson(fileName);

        return "Delete successfully";
    }

    @Override
    public String sortByName(String fileName) throws IOException {

        readFromJson(new File("/home/admin1/Documents/AddressBook/src/test/resources/"+fileName+".json"));
        Collections.sort(personInformation);
        writeIntoJson(fileName);

        return "Data sorted by name Successfully";
    }

    @Override
    public String sortByZip(String fileName) throws IOException {

            readFromJson(new File("/home/admin1/Documents/AddressBook/src/test/resources/"+fileName+".json"));
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
            writeIntoJson(fileName);
            return "Sorted By Zip Successfully";


    }

    @Override
    public void printAllEntries(String fileName) throws IOException {

        readFromJson(new File("/home/admin1/Documents/AddressBook/src/test/resources/"+fileName+".json"));

        System.out.print("FirstName"+"\t"+"LastName"+"\t"+"PhoneNumber"+"\t\t"+"City"+"\t\t"+"State"+"\t\t"+"ZipCode");
        System.out.println();

        for (int i=0;i<personInformation.size();i++)
        {
            System.out.println(personInformation.get(i).getFirstName()+" \t"+personInformation.get(i).getLastName()+" \t\t"+personInformation.get(i).getPhoneNumber()+" \t\t"+personInformation.get(i).getAddress().getCity()+" \t\t"+personInformation.get(i).getAddress().getState()+" \t"+personInformation.get(i).getAddress().getZipCode());

        }


    }

    public String writeIntoJson(String fileName) throws IOException {

        String json=gson.toJson(personInformation);
        FileWriter writer=new FileWriter("/home/admin1/Documents/AddressBook/src/test/resources/"+fileName+".json");
        writer.write(json);
        writer.close();

        return "Write successfully.....";

    }

    public void readFromJson(File fileName) throws IOException {

        this.personInformation=mapper.readValue(fileName, new TypeReference<List<Person>>()
        {
        });

    }


}
