package javaCore.module13.task3;

public class OpenTasks {
    private final int userId;
    private final int id;
    private final String title;
    boolean completed;

    public OpenTasks(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "OpenTasks{" +
                "userId=" + userId +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", completed=" + completed +
                '}';
    }
}
