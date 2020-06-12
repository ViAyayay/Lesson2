package Task_1;

public class Human implements MembersAction {
    private int endurance;
    private float riseHeight;

    public float getRiseHeight() {
        return riseHeight;
    }

    public Human(int endurance, float riseHeight) {
        this.endurance = endurance;
        this.riseHeight = riseHeight;
    }

    public float getEndurance() {
        return endurance;
    }


    @Override
    public String greeting(int i) {
        return String.format("Участник под номером %d", i);
    }

    @Override
    public String run(int distance) {
        endurance -= distance;
        return !canContinue() ? " и выдохся.\n" : String.format(" пробежал %d метров,",distance);
    }

    @Override
    public String climbOver(float height) {
        String s = " перешагнул";
        if(height>(riseHeight/6)){
            s = " перепрыгнул";
            if(height>(riseHeight/3)){
                s = " перелез";
                if(height>(riseHeight/2)){
                    endurance -= ((height-(riseHeight/3))*66+20);
                }
                endurance -= ((height-(riseHeight/3))*30+5);
                }
            endurance -= 5;
        }
        return !canContinue() ? " и выдохся.\n" : String.format( "%s %.1f метра,", s, height);
    }

    @Override
    public boolean canContinue() {
        return endurance <=0 ? false: true;
    }
}
