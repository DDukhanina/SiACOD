package ru.vsu.cs.gr12_2.dukhanina_d_a.siakod;

public class Message {
    private Level Level;
    private String text;

    public Message(ru.vsu.cs.gr12_2.dukhanina_d_a.siakod.Level level, String text) {
        Level = level;
        this.text = text;
    }

    public Level getLevel() {
        return Level;
    }

    public void setLevel(Level level) {
        Level = level;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
