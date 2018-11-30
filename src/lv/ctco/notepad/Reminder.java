package lv.ctco.notepad;

public class Reminder extends Record {
    private String reminder;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "date=" + getDate() +
                " text='" + reminder + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        String s = str.toLowerCase();
        return reminder.toLowerCase().contains(s)
                || date.contains(s);
    }


    @Override
    public void askData() {
        reminder = Main.askString("Enter Reminder");
        date = Main.askString("Enter Data");
    }
}
