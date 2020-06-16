package Task_1_new;

public class RunningTrack extends Obstacle{
    float length;

    public RunningTrack(float length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Member member) {
        return ((RunAble)member).run(length);
    }
}
