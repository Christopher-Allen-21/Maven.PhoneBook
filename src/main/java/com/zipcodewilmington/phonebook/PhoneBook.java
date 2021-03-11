package com.zipcodewilmington.phonebook;

import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        phonebook = map;
    }

    public PhoneBook() {
        phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        List<String> phoneNumList = Arrays.asList(phoneNumber);
        phonebook.put(name,phoneNumList);
    }

    public void addAll(String name, String... phoneNumbers) {
        List<String> phoneNumList = Arrays.asList(phoneNumbers);
        phonebook.put(name,phoneNumList);
    }

    public void remove(String name) {
        phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name,String phoneNumber) {
        return phonebook.containsKey(name);
    }

    public List<String> lookup(String name) {
        return phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        List<String> nameList = getAllContactNames();
        List<String> temp;

        for(String i: nameList){
            temp = phonebook.get(i);
            for(String j:temp){
                if(j==phoneNumber){
                    return i;
                }
            }
        }
        return null;

    }




    public List<String> getAllContactNames() {
        List<String> returnList = new ArrayList<>();
        for(String i : phonebook.keySet()){
            returnList.add(i);
        }
        return returnList;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
