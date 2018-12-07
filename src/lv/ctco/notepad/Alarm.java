package lv.ctco.notepad;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Created by olga.zoldaka on 11/30/2018.
 */
public class Alarm extends StickyNote implements Expirable {
    private LocalTime time;
    private LocalDate dismissedAt;

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
        this.time = Main.askTime("Enter alarm time as HH:MM");
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

    @Override
    public boolean isExpired() {
        LocalDate nowD = LocalDate.now();
        if (dismissedAt != null && dismissedAt.isEqual(nowD))
            return false;
        LocalTime now = LocalTime.now();
        return now.isAfter(time);
    }

    @Override
    public void dismiss(){
        dismissedAt = LocalDate.now();

    }
}
