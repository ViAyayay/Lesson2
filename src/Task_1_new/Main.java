package Task_1_new;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        Human h = new Human(1,1);
//        Wall w = new Wall(1);
//        w.overcome(h);

	Member[] members = getMembers();
	Obstacle[] obstacles = getObstacles();
	goTrack(members, obstacles);
    }

    private static void goTrack(Member[] members, Obstacle[] obstacles) {
        for (int i = 0; i < members.length; i++) {
            for (int j = 0; j < obstacles.length; j++) {
                if(!obstacles[j].overcome(members[i])){
                    break;
                }
            }
            System.out.println(" ");
        }
    }

    private static Obstacle[] getObstacles() {
        Obstacle[] obstacles = new Obstacle[] {
            new RunningTrack(100),
            new Wall(0.5f),
            new RunningTrack(150),
            new Wall(1),
            new RunningTrack(200),
            new Wall(1.5f),
        };
        return obstacles;
    }

    private static Member[] getMembers() {
        Random rnd = new Random();
        Member[] members = new Member[7];
        for (int i = 0; i < 7; i++) {
            int rndInt = rnd.nextInt(3);
            switch (rndInt){
                case 0:{
                    members[i] = new Human((rnd.nextInt(51)+150), (0.7f+rnd.nextFloat()/2));
                    break;
                }
                case 1:{
                    members[i] = new Cat((rnd.nextInt(100)+100), (0.5f+rnd.nextFloat()));
                    break;
                }
                case 2:{
                    members[i] = new Robot();
                    break;
                }

            }
        }
        return members;
    }


}
