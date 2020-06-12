package Task_1;

public class Cat implements MembersAction {
    private int endurance =0;
    private float riseHeight =0;

    public Cat(int endurance, float riseHeight) {
        this.endurance = endurance;
        this.riseHeight = riseHeight;
    }

    @Override
    public String greeting(int i) {
        String number = "какой то";
        for(CyrillicNumbers CNumber: CyrillicNumbers.values()){
            if(CNumber.getNumber() == i) number = CNumber.getRussianTitle();
        }
        return String.format("%s кот вышел на дистанцию", number);
    }

    @Override
    public String run(int distance) {
        endurance -= distance;
        return !canContinue() ? " и решил, что с него хватит.\n" : String.format(" пробежал %d метров,",distance);
    }

    @Override
    public String climbOver(float height) {
        endurance -= (height*25);
        return !canContinue() ? " и решил, что с него хватит.\n" : String.format(" перепрыгнул %.1f метра,",height);
    }

    @Override
    public boolean canContinue() {
        return endurance <=0 ? false: true;
    }

    @Override
    public float getRiseHeight() {
        return riseHeight;
    }
}
