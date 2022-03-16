package javaCore.module13.task2;

public class Comment {
    private final String postId;
    private final int id;
    private final String name;
    private final String email;
    private final String body;

    public Comment(String postId, int id, String name, String email, String body) {
        this.postId = postId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.body = body;
    }


    @Override
    public String toString() {
        return "Comment{" +
                "postId='" + postId + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", body='" + body + '\'' +
                '}';
    }


}
