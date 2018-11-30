package lv.ctco.notepad;

/**
 * Created by olga.zoldaka on 11/23/2018.
 */
public class StickyNote extends Record {

    private String text;


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "StickyNote{" +
                "id=" + getId() +
                " text='" + text + '\'' +
                '}';
    }

    @Override
    public boolean contains(String str) {
        String s = str.toLowerCase();
        return text.toLowerCase().contains(s);
    }

    @Override
    public void askData() {
        text = Main.askString("Enter note");
    }
}
