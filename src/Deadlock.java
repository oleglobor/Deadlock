
public class Deadlock {
    static class Friend {
        private final String name;
        public Friend(String name) {
            this.name = name;
        }
        public String getName() {
            return this.name;
        }
        public synchronized void drink(Friend bower) {
            System.out.format("%s: %s"
                            + "  випив зі мною кави%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }
        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s"
                            + " випив зі мною чаю%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend oleg =
                new Friend("Олег");
        final Friend ivan =
                new Friend("Іван");
        new Thread(new Runnable() {
            public void run() { oleg.drink(ivan); }
        }).start();
        new Thread(new Runnable() {
            public void run() { ivan.drink(oleg); }
        }).start();
    }
}