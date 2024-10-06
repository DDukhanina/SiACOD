package ru.vsu.cs.gr12_2.dukhanina_d_a.siakod;

abstract class LogDecor extends Logger{
    private Logger logger;
    public LogDecor(Logger logger) {
        super(logger.level);
        this.logger = logger;
    }

    protected boolean Checklvl(Message message) {
        switch (level) {
            case ERROR:
                return message.getLevel() == Level.ERROR;
            case DEBUG:
                return message.getLevel() == Level.DEBUG || message.getLevel() == Level.ERROR;
            case INFO:
                return true;
            default:
                return false;
        }
    }

    @Override
    public void log(Message message) {
        super.log(message);
    }
}
