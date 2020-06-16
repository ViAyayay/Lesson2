package Task_1_new;

public class Robot implements Member, JumpAble, RunAble{

//    float runLimit;
    float jumpLimit = 2f;
    boolean canContinue = true;

    @Override
    public boolean run(float runTrackLength) {
        System.out.println("Robot ran track.");
        return canContinue;
    }

    @Override
    public boolean jump(float wallHeight) {
        if(wallHeight>jumpLimit){
            canContinue = false;
            System.out.println("Robot could not jump over the wall.");
        }else{
            System.out.println("Robot jump over the wall.");
        }
        return canContinue;
    }
}
