package com.kodilla.testing.forum.statistics;

import java.util.List;

public class ForumStatistics {
    private int quantityOfUsers;
    private int quantityOfPosts;
    private int quantityOfComments;
    private double postsPerUser;
    private double commentsPerUser;
    private double commentsPerPost;

    Statistics statistics;

    public ForumStatistics(Statistics statistics) {
        this.statistics = statistics;
    }

    public int getQuantityOfUsers() {
        return quantityOfUsers;
    }

    public int getQuantityOfPosts() {
        return quantityOfPosts;
    }

    public int getQuantityOfComments() {
        return quantityOfComments;
    }

    public double getPostsPerUser() {
        return postsPerUser;
    }

    public double getCommentsPerUser() {
        return commentsPerUser;
    }

    public double getCommentsPerPost() {
        return commentsPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        quantityOfUsers = statistics.usersNames().size();
        quantityOfPosts = statistics.postsCount();
        quantityOfComments = statistics.commentsCount();

        if(quantityOfUsers == 0) {
            postsPerUser = quantityOfPosts;
        }
        else {
            postsPerUser = quantityOfPosts/quantityOfUsers;
        }

        if(quantityOfUsers == 0) {
            commentsPerUser = quantityOfComments;
        }
        else {
            commentsPerUser = quantityOfComments/quantityOfUsers;
        }

        if(quantityOfPosts == 0) {
            commentsPerPost = quantityOfComments;
        }
        else {
            commentsPerPost = quantityOfComments/quantityOfPosts;
        }
    }

    public void ShowStatistics() {
        System.out.println("liczba użytkowników: "+quantityOfUsers+"\nliczba postów: "+quantityOfPosts+"\nliczba komentarzy: "+quantityOfComments+"\nśrednia liczba postów na użytkownika: "+postsPerUser+"\nśrednia liczba komentarzy na użytkownika: "+commentsPerUser+"\nśrednia liczba komentarzy na post: "+commentsPerPost);
    }
}
