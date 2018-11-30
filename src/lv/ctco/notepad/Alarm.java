package lv.ctco.notepad;

import java.time.LocalTime;

/**
 * Created by olga.zoldaka on 11/30/2018.
 */
public class Alarm extends StickyNote {
    private LocalTime time;

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || time.format(Main.TIME_FORMATTER).contains(str);
    }

    @Override
    public void askData() {
        this.time = Main.askTime("Enter alarm time");
        super.askData();
    }

    @Override
    public String toString() {
        return "Alarm{" +
                "id= " + getId() +
                ", date='" + getTime() + '\'' +
                ", text='" + getText() + '\'' +
                '}';
    }

}
