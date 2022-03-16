package javaCore.module13.task2;

import java.io.IOException;

public class CommentsFinderTests {
    public static void main(String[] args) throws IOException, InterruptedException {
        CommentsFinder comments = new CommentsFinder();
        int userId = 1;
        comments.createJsonWithAllCommentsFromLastPostByUserId(userId);
    }
}
