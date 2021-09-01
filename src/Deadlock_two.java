public class Deadlock_two { //2 варіант
        public static void main(String[] args) {
            final String resource1 = "Люблю пляцки з тертої бульби";
            final String resource2 = "Дюблю сирники";

            Thread t1 = new Thread() {
                public void run() {
                    synchronized (resource1) {
                        System.out.println("люблю пляцки більше");

                        try { Thread.sleep(100);} catch (Exception e) {}

                        synchronized (resource2) {
                            System.out.println("люблю сирники більше");
                        }
                    }
                }
            };


            Thread t2 = new Thread() {
                public void run() {
                    synchronized (resource2) {
                        System.out.println("СИРНИКИ ВАН ЛАВ");

                        try { Thread.sleep(100);} catch (Exception e) {}

                        synchronized (resource1) {
                            System.out.println("ДЕРУНИ ВАН ЛАВ");
                        }
                    }
                }
            };


            t1.start();
            t2.start();
        }
    }

