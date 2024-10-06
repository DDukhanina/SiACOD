package ru.vsu.cs.gr12_2.dukhanina_d_a.siakod;

//Структурный паттерн, который позволяет динамически добавлять объектам новую функциональность
abstract class Logger {
    protected Level level;

    public Logger(Level level) {
        this.level = level;
    }

    public void log(Message message){};
}
