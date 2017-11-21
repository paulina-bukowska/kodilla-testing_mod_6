package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistics.ForumStatistics;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.*;
import java.util.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of test of calculateAdvStatistics method for different cases.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Test
    public void testCalculateAdvStatisticsWhenNoUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        int quantityOfUsers = forumStatistics.getQuantityOfUsers();
        //Then
        Assert.assertEquals(0, quantityOfUsers);
    }

    @Test
    public void testCalculateAdvStatisticsWhenNoPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        int quantityOfPosts = forumStatistics.getQuantityOfPosts();
        //Then
        Assert.assertEquals(0, quantityOfPosts);
    }

    @Test
    public void testCalculateAdvStatisticsWhenNoComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        int quantityOfComments = forumStatistics.getQuantityOfComments();
        //Then
        Assert.assertEquals(0, quantityOfComments);
    }

    @Test
    public void testCalculateAdvStatisticsWhenHundredUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> users = new ArrayList<String>();
        for(int i=0; i<100; i++) {
            users.add("Roy Adams");
        }

        when(statisticsMock.usersNames()).thenReturn(users);

        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        int quantityOfUsers = forumStatistics.getQuantityOfUsers();
        //Then
        Assert.assertEquals(100, quantityOfUsers);
    }

    @Test
    public void testCalculateAdvStatisticsWhenThousandPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> posts = new ArrayList<String>();
        for(int i=0; i<1000; i++) {
            posts.add("Hello everyone!");
        }

        when(statisticsMock.postsCount()).thenReturn(posts.size());

        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        int quantityOfPosts = forumStatistics.getQuantityOfPosts();
        //Then
        Assert.assertEquals(1000, quantityOfPosts);
    }

    @Test
    public void testCalculateAdvStatisticsWhenMoreCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> posts = new ArrayList<String>();
        for(int i=0; i<10; i++) {
            posts.add("Hello everyone!");
        }

        ArrayList<String> comments = new ArrayList<String>();
        for(int i=0; i<23; i++) {
            comments.add("How are you?");
        }

        when(statisticsMock.postsCount()).thenReturn(posts.size());
        when(statisticsMock.commentsCount()).thenReturn(comments.size());

        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        int quantityOfPosts = forumStatistics.getQuantityOfPosts();
        int quantityOfComments = forumStatistics.getQuantityOfComments();
        //Then
        Assert.assertTrue(quantityOfComments > quantityOfPosts);
    }

    @Test
    public void testCalculateAdvStatisticsWhenMorePostsThanComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);

        ArrayList<String> posts = new ArrayList<String>();
        for(int i=0; i<10; i++) {
            posts.add("Hello everyone!");
        }

        ArrayList<String> comments = new ArrayList<String>();
        for(int i=0; i<8; i++) {
            comments.add("How are you?");
        }

        when(statisticsMock.postsCount()).thenReturn(posts.size());
        when(statisticsMock.commentsCount()).thenReturn(comments.size());

        ForumStatistics forumStatistics = new ForumStatistics(statisticsMock);
        //When
        forumStatistics.calculateAdvStatistics(statisticsMock);
        int quantityOfPosts = forumStatistics.getQuantityOfPosts();
        int quantityOfComments = forumStatistics.getQuantityOfComments();
        //Then
        Assert.assertFalse(quantityOfComments > quantityOfPosts);
    }
}
