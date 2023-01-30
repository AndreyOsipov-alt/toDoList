import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Map<Integer, String> listTasks = new HashMap<>();

    public static void main(String[] args) {

        String command = "";
        String[] task ;

        System.out.println("Введите команду\n" +
                "add - добавление задачи\n" +
                "print - печать списка задач\n" +
                "toggle - изменение статуса задачи\n" +
                "quit - завершение работы");

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            while (!(command=reader.readLine()).equals("quit")){
                task = command.toString().split(" ");


                switch (task[0].toLowerCase()){
                    case("add"):addTask(Arrays.toString(task).replaceAll("[\\[\\]\\,]","").replace("add","[ ]"));
                        break;
                    case("print"): printTask();
                        break;
                    case("toggle"):

                        if (task.length > 1) {
                            toggleTask(Integer.parseInt(task[1]));
                        } else {
                            emptyList();
                        }

                        break;
                    case("quit"):
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

    private static void addTask(String task){
        listTasks.put(0,task);
    }

    private static void printTask(){
        emptyList();
        System.out.println("№1 "+listTasks.get(0));

    }

    private static void toggleTask(Integer id){
        emptyList();
        if(id>listTasks.size()||id<0){
            System.out.println("Неверное Id");
            return;
        }
        id = id-1;
        if(listTasks.get(id).contains("[ ]")){
            listTasks.put(id,listTasks.get(id).replace("[ ]","[X]"));
        }else{
            listTasks.put(id,listTasks.get(id).replace("[X]","[ ]"));
        }
    }

    private static void emptyList(){
        if(listTasks.isEmpty()){
            System.out.println("Список задач пуст\n");
        }
    }



}
