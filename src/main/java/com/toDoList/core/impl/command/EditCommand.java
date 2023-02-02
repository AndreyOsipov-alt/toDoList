package com.toDoList.core.impl.command;

import com.toDoList.core.ErrorHandler;
import com.toDoList.core.TaskDao;
import com.toDoList.core.Tasks;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EditCommand extends BaseDaoCommand {

    protected EditCommand(TaskDao taskDao, ErrorHandler errorHandler) {
        super(taskDao, errorHandler);
    }

    @Override
    public String getCommandName() {
        return "edit";
    }

    @Override
    public void process(BufferedReader reader) {
        try {
            String line = reader.readLine();
            if (!line.matches("(\\d+)\\s+(\\S+.*)")) {
                errorHandler.handle("Необходимо указать идентификатор и описание задачи");
            }else {
                Pattern pattern = Pattern.compile("(?<id>\\d+)\\s+(?<desc>\\S+.*)");
                Matcher matcher = pattern.matcher(line);
                if(matcher.find()) {
                    String id = matcher.group("id");

                Optional<Tasks> task = taskDao.get(Long.parseLong(id));
                if(task.isPresent()){
                    task.get().setName(matcher.group("desc"));
                }else{
                    errorHandler.handle("Задачи с таки идентификатором не существует");
                }
            }}

        } catch (IOException ex) {
                errorHandler.handle("Упс, ошибка" + ex);
        }


    }
}
