package task_7;

public class TwoDirectionalList implements DirectionalList {
    private Node first;
    private Node end;

    @Override
    public void add(String val) {
        if (first == null) {
            first = end = new Node(val, null);
            return;
        }

        add(val, end);
    }

    private void add(String val, Node current){
        end = new Node(val, current);
        current.setNext(end);
    }

    @Override
    public boolean remove(String val){
        if(first == null){
            return false;
        }
        if(first.getVal().equals(val)){
            if(first != end){
                first.getNext().setPrev(null);
                first = first.getNext();
            } else{
                first = null;
                end = null;
            }
            return true;
        }
        Node current = first.getNext();
        while (current != null){
            if(current.getVal().equals(val)){
                if(current == end){
                    end = current.getPrev();
                }else{
                    current.getNext().setPrev(current.getPrev());
                }
                current.getPrev().setNext(current.getNext());
                current = null;
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public Node getFirst() {
        return first;
    }

    public Node getEnd() {
        return end;
    }

    @Override
    public void arrayToList(String[] array) {
        add(array[0]);
        Node current;
        for (int i = 1; i < array.length; i++) {
            current = getEnd();
            add(array[i], current);
        }
    }

    @Override
    public int size() {
        if (first == null) {
            return 0;
        }

        int size = 1;

        Node current = first;
        while (current != end) {
            size++;
            current = current.getNext();
        }
        return size;
    }
    public class Node {

        private String val;
        private Node next;
        private Node prev;

        public Node(String val, Node prev) {
            this.val = val;
            this.prev = prev;
        }

        public String getVal() {
            return val;
        }

        public Node getNext() {
            return next;
        }

        public Node getPrev() { return prev; }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrev(Node prev) {
            this.prev = prev;
        }
    }
}
