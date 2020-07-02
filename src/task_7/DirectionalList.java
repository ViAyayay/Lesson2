package task_7;

public interface DirectionalList {
    void add(String val);
    boolean remove(String val);
    Object getFirst();
    Object getEnd();
    void arrayToList (String[] array);
    int size();
}
