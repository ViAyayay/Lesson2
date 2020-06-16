package Task_1_new;

public class Cat implements Member, JumpAble, RunAble{

    float runLimit;
    float jumpLimit;
    boolean canContinue = true;

    public Cat(float runLimit, float jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }
    @Override
    public boolean run(float runTrackLength) {
        if(runTrackLength>runLimit){
            canContinue = false;
            System.out.println("Cat could not run track.");
        }else{
            System.out.println("Cat ran track.");
        }
        return canContinue;
    }

    @Override
    public boolean jump(float wallHeight) {
        if(wallHeight>jumpLimit){
            canContinue = false;
            System.out.println("Cat could not jump over the wall.");
        }else{
            System.out.println("Cat jump over the wall.");
        }
        return canContinue;
    }
}
