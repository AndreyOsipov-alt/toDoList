package com.toDoList.core;

import java.util.Optional;
import java.util.stream.Stream;

public interface TaskDao {

    void save(Tasks task);
    Optional<Tasks> get(long id);
    Stream<Tasks> find(String query, boolean excludeCompleted);
    void delete(long id);
    Stream<Tasks> getTasks();
}
