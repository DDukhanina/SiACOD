package ru.vsu.cs.gr12_2.dukhanina_d_a.siakod;

public class FileLogger extends LogDecor{
    public FileLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void log(Message message) {
        if (Checklvl(message)) {
            // какая-то логика
        }
        super.log(message);
    }
}

