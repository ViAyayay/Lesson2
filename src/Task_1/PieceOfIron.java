package Task_1;

public class PieceOfIron implements Action{
    private float riseHeight =3.0f;

    @Override
    public float getRiseHeight() {
        return riseHeight;
    }

    @Override
    public String toString() {
        return Integer.toHexString(hashCode());
    }


    @Override
    public String greeting(int i) {
        return String.format("устройство под номером %s выехал на дистанцию", Integer.toHexString(hashCode()));
    }

    @Override
    public String run(int distance) {
        return String.format(" проехал %d метра,",distance);
    }

    @Override
    public String climbOver(float height) {

        return String.format(" преодолел препятствие в %.1f метра высотой,",height);
    }

    @Override
    public boolean canContinue() {
        return true;
    }
}
