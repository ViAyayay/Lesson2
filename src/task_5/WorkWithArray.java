package task_5;

public class WorkWithArray {
    static final int size = 10000000;
    static float[] mainArray = new float[size];

    static void doTask() {
        methodOne();
        methodTwo();
    }

    private static void methodOne() {
        for (int i = 0; i < size; i++) {
            mainArray[i]=1.0f;
        }
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            mainArray[i] = (float)(mainArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("время выполнения первого метода: "+(System.currentTimeMillis()-timeStart));
    }

    private static void methodTwo(){
        for (int i = 0; i < size; i++) {
            mainArray[i]=1.0f;
        }
        final int halfSize = size / 2;
        float[] halfArr1 = new float[halfSize];
        float[] halfArr2 = new float[halfSize];
        long timeFirst = System.currentTimeMillis();
        System.arraycopy(mainArray, 0, halfArr1, 0, halfSize);
        System.arraycopy(mainArray, halfSize, halfArr2, 0, halfSize);
        System.out.println("время разделения массива: "+(System.currentTimeMillis()-timeFirst));
        new Thread(() -> WorkWithArray.doThread(halfArr1)).start();
        new Thread(() -> WorkWithArray.doThread(halfArr2)).start();
        new Thread(() -> WorkWithArray.stickArrays(halfArr1, halfArr2, timeFirst)).start();

    }

    private static void stickArrays(float[] arrFirst, float[] arrSecond, Long timeStart) {
        synchronized (arrFirst){
            synchronized (arrSecond){
                long timeFirst = System.currentTimeMillis();

                System.arraycopy(arrFirst, 0, mainArray, 0, arrFirst.length);
                System.arraycopy(arrSecond, 0, mainArray, arrFirst.length, arrFirst.length);

                System.out.println("время объединения массивов: " + (System.currentTimeMillis() - timeFirst));
                System.out.println("общее время работы второго метода: " + (System.currentTimeMillis()  - timeStart));
            }}

    }

    private static void doThread(float[] arr) {
        long firstTime = System.currentTimeMillis();
        synchronized (arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
            System.out.println("время обработки половины массива: " + (System.currentTimeMillis() - firstTime));
        }
    }

}
