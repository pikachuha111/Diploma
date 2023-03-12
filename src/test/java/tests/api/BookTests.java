package tests.api;

import baseEntities.BaseApiTest;
import models.CollectionBooks;
import org.testng.annotations.Test;


public class BookTests extends BaseApiTest {
    protected CollectionBooks collectionBooks = new CollectionBooks();

    @Test (description = "GET collection of books")
    public void getCollectionBooksTest() {
        collectionBooks = bookAdapter.getCollectionBooks();
    }

    @Test(description = "GET book by name",dependsOnMethods = "getCollectionBooksTest")
    public void getBookByNameTest() {
        bookAdapter.getBookByName(collectionBooks, "git Pocket Guide");
    }

    @Test(description = "POST add book to user who has been authorized", dependsOnMethods = "getCollectionBooksTest")
    public void addBookToUserTest() {
        bookAdapter.addBookToUser(actualUser, collectionBooks, "git Pocket Guide");
    }

    @Test(description = "GET user method", dependsOnMethods = "addBookToUserTest")
    public void getUserTest() {
        userAdapter.getUser(actualUser);
    }

}
