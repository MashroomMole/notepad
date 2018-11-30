package lv.ctco.notepad;

import java.time.LocalDate;

public class Reminder extends Alarm {
    private LocalDate date;

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
        this.date = Main.askDate("Enter reminder Date");
        super.askData();
    }
}
