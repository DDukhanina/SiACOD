package ru.vsu.cs.gr12_2.dukhanina_d_a.siakod;

public class RemoteLogger extends LogDecor{
    public RemoteLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void log(Message message) {
        if (Checklvl(message)) {
            // какая-то логика
        }
    }
}
