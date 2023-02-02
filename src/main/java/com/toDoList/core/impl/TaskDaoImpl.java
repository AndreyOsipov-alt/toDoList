package com.toDoList.core.impl;

import com.toDoList.core.TaskDao;
import com.toDoList.core.Tasks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class TaskDaoImpl implements TaskDao {

    private final List<Tasks> journal = new ArrayList<>();
    private long counter = 0;

    @Override
    public void save(Tasks task) {
        counter++;
        task.setId(counter);
        journal.add(task);
    }

    @Override
    public Optional<Tasks> get(long id) {
        return journal.stream()
                .filter(t -> t.getId() == id)
                .findAny();
    }

    @Override
    public Stream<Tasks> find(String query, boolean excludeCompleted) {
        Stream<Tasks> result = journal.stream();
        if (excludeCompleted) {
            result = result.filter(task -> !task.isDone());
        }
        if (query != null && !query.isEmpty()) {
            result = result.filter(task -> task.getName().contains(query));
        }
        return result;
    }


    @Override
    public void delete(long id) {
        for (Iterator<Tasks> i = journal.listIterator(); i.hasNext(); ) {
            Tasks t = i.next();
            if (t.getId() == id) {
                i.remove();
                break;
            }
        }

    }

    @Override
    public Stream<Tasks> getTasks() {
        return journal.stream();
    }
}
