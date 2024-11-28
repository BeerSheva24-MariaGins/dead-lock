package telran.multithreading;

public class Worker extends Thread {
    private static final Object mutex1 = new Object();
    private static final Object mutex2 = new Object();

    private void f1() {
        synchronized (mutex1) {
            System.out.println(Thread.currentThread().getName() + " acquired mutex1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (mutex2) {
                System.out.println(Thread.currentThread().getName() + " acquired mutex2");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    private void f2() {
        synchronized (mutex2) {
            System.out.println(Thread.currentThread().getName() + " acquired mutex2");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (mutex1) {
                System.out.println(Thread.currentThread().getName() + " acquired mutex1");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    

    @Override
    public void run() {
        f1();
        f2();
    }

   
}
