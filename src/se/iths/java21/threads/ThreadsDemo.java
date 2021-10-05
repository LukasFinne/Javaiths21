package se.iths.java21.threads;

public class ThreadsDemo {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new DoSomething());
        Thread thread2 = new Thread(new DoSomething());
        thread1.setDaemon(true);//Detta betyder att trådarna stängs ner när main tråden lämnar
        thread2.setDaemon(true);
        thread1.start(); //Detta startar en tråd
        thread2.start();
        //  new DoSomething().run();//Detta blir main tråden
    }
}

class DoSomething implements Runnable{
    private int counter = 0;
    @Override
    public void run() {
        while(counter < 10){
            System.out.println("This is Thread " + Thread.currentThread().getName()  + ": " + counter++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}