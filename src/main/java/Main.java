import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.stream.Stream;

public class Main {

   static LinkedList<Tasks> journal = new LinkedList<>();
    static String regEx;
    static  String[] task;


    public static void main(String[] args) {

        System.out.println("Введите команду\n" +
                "add - добавление задачи\n" +
                "print - печать списка задач\n" +
                "search - поиск задачи\n"+
                "toggle - изменение статуса задачи\n" +
                "delete - удаление задачи\n"+
                "edit - изменение задачи\n"+
                "quit - завершение работы");

        String command = "";


        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (!(command=reader.readLine()).equals("quit")){
                task = command.split(" ");

                switch (task[0].toLowerCase()){
                    case("add"):
                        addTask();
                        break;
                    case("print"):
                        printTasks();
                        break;
                    case("search"):
                        searchTask();
                        break;
                    case("toggle"):
                        toggleTask();
                        break;
                    case("edit"):
                        editTask();
                        break;
                    case("delete"):
                        deleteTask();
                        break;
                    default:
                        System.out.println("Неверно введена команда или описание.\n"+"Необходимо поставить пробел между каомандой и описанием");
                        break;

                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private  static void addTask(){
        if(task.length==1){
            journal.add(new Tasks(" "));
        }
        regEx = Arrays.toString(task).replaceAll("(?:add)|[\\[\\]\\,]","");

        journal.add(new Tasks(regEx));
    }

    private static  void printTasks(){
        if(journal.isEmpty()){
            System.out.println("Список пуст\n");}
        else{
        if (task.length==1) {
            for(int i =0;i<journal.size();i++){
                if(journal.get(i).getStatus().contains("[ ]")) {
                    System.out.println((i + 1) + ". " + journal.get(i).getStatus() + " " + journal.get(i).getName());
                }
            }
        } else {
            printTaskWithArg(task[1]);
        }

    }}

    private static void printTaskWithArg(String arg) {
        if(arg.contains("all")){
            for(int i =0;i<journal.size();i++){
                System.out.println((i+1)+". " + journal.get(i).getStatus()+" " +journal.get(i).getName());
            }
        }else{
            System.out.println("Неверно указан аргумент");
        }
    }


    private static void searchTask(){
        if(journal.isEmpty()){
            System.out.println("Список пуст\n");}
        else{
        if(task.length>1){
            for(int i=0;i< journal.size();i++){
                if(journal.get(i).getName().contains(task[1])){
                    System.out.println((i+1)+"."+journal.get(i).getStatus()+journal.get(i).getName());
                }
            }
        }else{
            System.out.println("Неуказан аргумент");
        }
    }}

    private static void toggleTask(){
        if(journal.isEmpty()){
            System.out.println("Список пуст\n");}
        else{
        if(task.length==1){System.out.println("Неуказан идинтификатор");}
        else {
            try {
                int id = Integer.parseInt(task[1]);
                if(id>journal.size()||id<=0) {
                    System.out.println("Неверный идинтификатор");
                }else{
                if (journal.get(id-1).getStatus().contains("[ ]")) {
                    journal.get(id-1).setStatus("[x]");
                } else {
                    journal.get(id-1).setStatus("[ ]");
                }}

            } catch (NumberFormatException e) {
                System.out.println("Неверно указан идинтификатор");
            }
        }
    }}

    private static void editTask(){
        if(journal.isEmpty()){
            System.out.println("Список пуст\n");}
        else{
        if(task.length==1){
            System.out.println("Неуказаны дополнительные парамметры");
        }else {
            try{
                int id = Integer.parseInt(task[1]);
                if(id>journal.size()||id<=0) {
                    System.out.println("Неверный идинтификатор");
                }else{
                regEx = Arrays.toString(task).replaceAll("(?:edit)|[\\[\\]\\,]", "").replaceAll("^(\\s*\\d+)", "");
                journal.get((id-1)).setName(regEx);}
            }catch (NumberFormatException e){
                System.out.println("Неверно указан идинтификатор");
            }
        }
    }}

    private static void deleteTask(){
        if(journal.isEmpty()){
            System.out.println("Список пуст\n");}
        else{
        if(task.length==1){
            System.out.println("Неуказан идинтификатор");
        }else{
            try{
                int id = Integer.parseInt(task[1]);
                if(id>journal.size()||id<=0) {
                    System.out.println("Неверный идинтификатор");
                }else{
                journal.remove((id-1));}

            }catch (NumberFormatException e){
                System.out.println("Неверно  указан идинтификатор");
            }
        }
    }}





}





