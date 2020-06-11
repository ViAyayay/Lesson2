package Task_1;

public class Paries extends Obstacles{
    final float height;

    public Paries(float height) {
        this.height = height;
    }

    @Override
    float getValue() {
        return height;
    }
}
