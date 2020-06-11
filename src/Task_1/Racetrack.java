package Task_1;

public class Racetrack extends Obstacles{
    final int length;

    public Racetrack(int length) {
        this.length = length;
    }


    @Override
    float getValue() {
        return length;
    }
}
