package task_3;


import java.util.*;

public class Phonebook {
    private HashMap<String, LinkedList<Long>> book = new HashMap<>();

    public void add(String lastName, Long number){
        if (book.containsKey(lastName)){
            book.get(lastName).add(number);
        }else {
            book.put(lastName, new LinkedList<>(Arrays.asList(number)));
        }
    }

    public void get(String name){
        System.out.println(name + ": " + book.get(name).toString());
    }
}
