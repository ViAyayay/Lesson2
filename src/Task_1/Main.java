package Task_1;

import java.util.Random;

public class Main {

     static MembersAction[] members;
     static Random random = new Random();
     static Obstacles[] obstacles;

    public static void main(String[] args) {
        doTask();
    }

    static void doTask(){
        int number = 9;
        getMembers(number);
        getObstacles(10);
        System.out.println("Приглашаем всех к полосе препятствий!\n");
        for (int i = 0; i < number; i++) {
            go(members[i], i+1);
        }
    }

    static void getMembers(int number) {
        members = new MembersAction[number];
        for (int i = 0; i < number; i++) {
            members[i] = new Human(random.nextInt(2001)+1000, random.nextFloat()+2.5f);
            i++;
            members[i] = new Cat(random.nextInt(1001)+500, (random.nextFloat()/2)+1.5f);
            i++;
            members[i] = new PieceOfIron();
        }
    }

    private static void getObstacles(int number) {
        obstacles = new Obstacles[number];
        for (int i = 0; i < number; i++) {
            obstacles[i] = random.nextFloat() > 0.7f ? new Paries(random.nextFloat() * 3.5f) : new Racetrack(random.nextInt(201) + 100);
        }

    }

    private static void go(MembersAction member, int i) {
        StringBuilder text = new StringBuilder();
        text.append(member.greeting((1+i/3)));
        for (int j = 0; j < obstacles.length; j++) {
            if(obstacles[j].getClass().equals(Paries.class)){
                if (member.getRiseHeight()>=obstacles[j].getValue()) {
                    text.append(member.climbOver(obstacles[j].getValue()));
                }else{
                    text.append(" не смог преодолеть препятствие и сходит с дистанции\n");
                    System.out.println(text);
                    return;
                }
            }else{
                text.append(member.run((int)obstacles[j].getValue()));
            }
            if(!member.canContinue()){
                System.out.println(text);
                return;
            }
        }
        text.append(" и пришёл к финишу. Поздравим с преодолением препятствий!\n");
        System.out.println(text);
    }
}
