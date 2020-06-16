package Task_1;

public enum CyrillicNumbers {
    ONE("первый", 1), TWO("второй", 2),
    THREE("третий", 3), FOUR("четвёртый", 4),
    FIVE("пятый", 5), SIX("шестой", 6),
    SEVEN("седьмой", 7), EIGHT("восьмой",8), NINE("девятый", 9);
    private String russianTitle;
    private int number;

    CyrillicNumbers(String russianTitle, int number) {
        this.russianTitle = russianTitle;
        this.number = number;
    }

    public String getRussianTitle() {
        return russianTitle;
    }

    public int getNumber() {
        return number;
    }
}
