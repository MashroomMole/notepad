package lv.ctco.notepad;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Reminder extends Alarm implements Expirable {

    private LocalDate date;
    private boolean dismissed = false;

    @Override
    public void dismiss() {
        dismissed = true;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + getId() +
                "date=" + date.format(Main.DATE_FORMATTER) +
                " text='" + getText() +
                '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        return super.contains(str)
                || date.format(Main.DATE_FORMATTER).contains(str);
    }


    @Override
    public void askData() {
        this.date = Main.askDate("Enter reminder Date as dd-MMM-uuuu");
        super.askData();
    }

//    @Override
//    public boolean isExpired() {
//        LocalDate now = LocalDate.now();
//        return now.isAfter(date);
//    }

    @Override
    public boolean isExpired() {
        if (dismissed == true) {
            return false;
        }
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime dt = LocalDateTime.of(getDate(), getTime());
        return now.isAfter(dt);
    }
}
