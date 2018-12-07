package lv.ctco.notepad;

/**
 * Created by olga.zoldaka on 12/7/2018.
 */
public interface Expirable {
    boolean isExpired();


    default void dismiss() {
        System.out.println("DISMISS is not yet implemented");
    }

}
