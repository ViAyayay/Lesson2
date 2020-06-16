package Task_1_new;

public class Human implements Member, JumpAble, RunAble{

    float runLimit;
    float jumpLimit;
    boolean canContinue = true;

    public Human(float runLimit, float jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }


    @Override
    public boolean run(float runTrackLength) {
        if(runTrackLength>runLimit){
            canContinue = false;
            System.out.println("Human could not run track.");
        }else{
            System.out.println("Human ran track.");
        }
        return canContinue;
    }

    @Override
    public boolean jump(float wallHeight) {
        if(wallHeight>jumpLimit){
            canContinue = false;
            System.out.println("Human could not jump over the wall.");
        }else{
            System.out.println("Human jump over the wall.");
        }
        return canContinue;
    }
}
