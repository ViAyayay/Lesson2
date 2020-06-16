package Task_1_new;

public class Wall extends Obstacle{
    float height;

    public Wall(float height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Member member) {
        return ((JumpAble)member).jump(height);
    }
}
