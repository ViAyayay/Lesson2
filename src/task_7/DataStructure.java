package task_7;

public class DataStructure {
    public static void main(String[] args) {
    }

    private static void test(){
        String[] str = new String[]{"val2", "val3", "val4"};

        DirectionalList directionalList = new TwoDirectionalList();
        directionalList.add("val1");
        directionalList.add("val2");
        directionalList.add("val3");
        directionalList.add("val4");

        TwoDirectionalList.Node first = (TwoDirectionalList.Node) directionalList.getFirst();

        System.out.println(first.getVal());
        System.out.println(first.getNext().getVal());
        System.out.println(first.getNext().getNext().getVal());
        System.out.println(first.getNext().getNext().getNext().getVal());
        System.out.println(first.getNext().getNext().getNext().getNext());

        System.out.println("Size: " + directionalList.size());

        System.out.println("Removed? - " + directionalList.remove("val1"));
        System.out.println("Removed? - " + directionalList.remove("val4"));
        System.out.println("Removed? - " + directionalList.remove("val6"));
        System.out.println("Removed? - " + directionalList.remove("val2"));
        System.out.println("Removed? - " + directionalList.remove("val3"));
        directionalList.add("val1");
        directionalList.arrayToList(str);


        first = (TwoDirectionalList.Node) directionalList.getFirst();

        System.out.println(first.getVal());
        System.out.println(first.getNext().getVal());
        System.out.println(first.getNext().getNext().getVal());
        System.out.println(first.getNext().getNext().getNext().getVal());
        System.out.println(first.getNext().getNext().getNext().getNext());

        System.out.println(((TwoDirectionalList.Node)directionalList.getEnd()).getVal());

        System.out.println("Size: " + directionalList.size());
    }
}
