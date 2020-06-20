package task_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *  Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 Посчитать сколько раз встречается каждое слово.
 
 * Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
 В этот телефонный справочник с помощью метода add() можно добавлять записи.
 С помощью метода get() искать номер телефона по фамилии.
 Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
 тогда при запросе такой фамилии должны выводиться все телефоны.
 */

public class Main {

    public static void main(String[] args) {
//        doFirstTask();
//        doSecondTask();

    }

    private static void doSecondTask() {
        Phonebook phonebook = new Phonebook();
        phonebook.add("Valuyev", 79136552345L);
        phonebook.add("Konyuhov", 79476558940L);
        phonebook.add("Valuyev", 79326541212L);
        phonebook.add("Dmitriyew", 79972568654L);
        phonebook.add("Selkov", 79321265654L);
        phonebook.add("Soopov", 79222245654L);
        phonebook.add("Putin", 79735685654L);

        phonebook.get("Valuyev");
        phonebook.get("Soopov");
    }

    private static void doFirstTask() {
        ArrayList<String> words = getList();
        System.out.printf("мы имеем массив, состоящий из %d слов%n%n", words.size());
        HashMap<String, Integer> uniqWords = getunicWord(words);
        for(Map.Entry<String, Integer> map: uniqWords.entrySet()) {
            System.out.printf("слово %s встречается %s раз.%n", map.getKey(), map.getValue());
        }
    }

    private static HashMap<String, Integer> getunicWord(ArrayList<String> words) {
        HashMap<String, Integer> uniqWords = new HashMap<>();
        for(String s: words){
            if(uniqWords.containsKey(s)){
                uniqWords.put(s, (uniqWords.get(s)+1));
            } else{
                uniqWords.put(s, 1);
            }
        }
        return uniqWords;
    }

    private static ArrayList<String> getList() {
        return new ArrayList<>(Arrays.asList(
                "apple", "clock", "juice", "ice", "uno", "ice",  "three", "clock", "table", "tree", "uno",
                "cat", "list", "sword", "name", "key", "three", "apple", "ice", "uno", "green", "key",
                "table", "juice", "sword", "apple", "table", "cat", "key", "clock", "name", "ice", "three",
                "green", "key", "cat", "run", "three", "table", "sword", "name","word", "uno"
        ));
    }
}
