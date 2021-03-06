package lv.ctco.notepad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.time.format.DateTimeFormatter.*;


public class Main {
    public static final String DATE_PATTERN = "dd-MMM-uuuu";
    public static final String TIME_PATTERN = "H:mm";
    public static final DateTimeFormatter DATE_FORMATTER = ofPattern(DATE_PATTERN);
    public static final DateTimeFormatter TIME_FORMATTER = ofPattern(TIME_PATTERN);

    static Scanner scanner = new Scanner(System.in);
    static List<Record> records = new ArrayList<>();

    public static void main(String[] args) {
        for (; ; ) {
            System.out.print("cmd: ");
            String cmd = scanner.next();
            switch (cmd) {
                case "search":
                    search();
                    break;
                case "cp":
                case "createPerson":
                    createRecord(new Person());
                    break;
                case "help":
                    showHelp();
                    break;
                case "delete":
                    deleteRecordById();
                case "list":
                    showList();
                    break;
                case "note":
                    createRecord(new StickyNote());
                    break;
                case "rmd":
                case "reminder":
                    createRecord(new Reminder());
                    break;
                case "alarm":
                    createRecord(new Alarm());
                    break;
                case "expired":
                    listExpired();
                    break;
                case "dismiss":
                    dismiss();
                    break;
//                case "cd":
//                    calcDuration();
//                break;
                case "exit":
                    return;
                default:
                    System.out.println("Wrong command. Try 'help'");
            }
        }
    }

    private static void dismiss() {
        int id = askInt("Enter ID of record to dismiss");
        Optional<Expirable> first = records.stream()
                .filter(r -> r.getId() == id)
                .filter(r -> r instanceof Expirable)
                .map(r -> (Expirable) r)
                .findFirst();
        first.ifPresent(e -> e.dismiss());
    }




private static void listExpired(){
        records.stream()
        .filter(r->r instanceof Expirable)
        .map(r->(Expirable)r)
        .filter(e->e.isExpired())
        .forEach(e->System.out.println(e));

//        for (Record r : records) {
//                        if (r instanceof Expirable){
//                            Expirable e = (Expirable) r;
//                            if (e.isExpired()) {
//                                System.out.println(e);
//                }
//            }
//        }
        }
//
//    private static void calcDuration() {
//        String cd = askString("Enter flight data");
//        LocalDate dd = askDate("Enter departure date");
//        LocalTime dt = askTime("Enter departure time");
//        LocalDate ad = askDate("Enter arrival date");
//        LocalTime at = askTime("Enter arrival time");
//        Period p = ;
//    }

private static void search(){
        String ss=askString("What would you like to find?");
        for(Record r:records){
        if(r.contains(ss)){
        System.out.println(r);
        }
        }
        }

private static void createRecord(Record record){
        record.askData();
        records.add(record);
        System.out.println(record);
        }

private static void deleteRecordById(){
        int id=askInt("ID to delete");
        for(int i=0;i<records.size();i++){
        Record record=records.get(i);
        if(record.getId()==id){
        records.remove(i);
        break;
        }
        }
        showList();
        }

private static void showList(){
        records.forEach(System.out::println);
        }

private static void showHelp(){

        }


public static String askString(String msg){
        for(;;){
        System.out.print(msg+": ");
        String val=scanner.next();
        if(!val.startsWith("\"")){
        return val;
        }
        List<String> words=new ArrayList<>();
        words.add(val);
        while(!val.endsWith("\"")){
        val=scanner.next();
        words.add(val);
        }
        String result=String.join(" ",words);
        result=result.substring(1,result.length()-1);
        if(result.length()< 1){
        System.out.println("at least one character, please");
        continue;
        }
        return result;
        }
        }

public static long askLong(Long msg){
        System.out.print(msg+": ");
        return scanner.nextLong();
        }

public static int askInt(String msg){
        System.out.print(msg+": ");
        return scanner.nextInt();
        }

public static String askPhone(String msg){
        for(;;){
        String result=askString(msg);
        boolean hasWrongChars=result.codePoints()
        .anyMatch(c->!(Character.isDigit(c)||Character.isSpaceChar(c)||c=='-'||c=='+'));
        if(hasWrongChars){
        System.out.println("Only numbers, spaces dashes and pluses are allowed");
        continue;
        }

        long digitCount=result.codePoints()
        .filter(Character::isDigit)
        .count();
        if(digitCount< 5){
        System.out.println("Should be 5 or more digits");
        continue;
        }

        return result;
        }
        }

public static LocalDate askDate(String msg){
        String strDate=askString(msg);
        return LocalDate.parse(strDate,DATE_FORMATTER);
        }

public static LocalTime askTime(String msg){
        String strTime=askString(msg);
        return LocalTime.parse(strTime,TIME_FORMATTER);
        }
        }
