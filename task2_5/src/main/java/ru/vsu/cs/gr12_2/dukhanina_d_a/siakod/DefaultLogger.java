package ru.vsu.cs.gr12_2.dukhanina_d_a.siakod;

class DefaultLogger extends Logger {
    private Level level;

    public DefaultLogger(Level level) {
        super(level);
    }

    @Override
    public void log(Message message) {
        System.out.println(message);
    }
}