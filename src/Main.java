public class Main {
    public static void main(String[] args) throws Exception {
        ThreadGroup threadsGroup = new ThreadGroup("group one");
        Thread[] myThreadsArray = createMyThreadsArray(4, "поток", threadsGroup);
        threadsGroup.setDaemon(true);
        toStartMyThreads(myThreadsArray);
        Thread.sleep(15000);
        toStopThreadsGroup(threadsGroup);
    }

    public static Thread[] createMyThreadsArray(int size, String threadsPreName, ThreadGroup threadsGroup) {
        Thread[] newMyThreadsArray = new Thread[size];
        for (int i = 0 ; i < newMyThreadsArray.length ; i++) {
            MyThread newPreMyThread = new MyThread();
            newPreMyThread.setName(threadsPreName + " " + (i + 1));
            final Thread newMyThread = new Thread(threadsGroup, newPreMyThread);
            newMyThreadsArray[i] = newMyThread;
        }
        System.out.println("Потоки успешно созданы!");
        return newMyThreadsArray;
    }

    public static void toStartMyThreads(Thread[] myThreadsArray) {
        for (int i = 0; i < myThreadsArray.length; i++) {
            myThreadsArray[i].start();
        }
        System.out.println("Запускаю все потоки...");
    }

    public static void toStopThreadsGroup(ThreadGroup threadsGroup) {
        System.out.println("Завершаю все потоки...");
        threadsGroup.interrupt();
    }

}
