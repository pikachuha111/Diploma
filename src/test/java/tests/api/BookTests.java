package tests.api;

import baseEntities.BaseApiTest;
import models.CollectionBooks;
import org.testng.annotations.Test;


public class BookTests extends BaseApiTest {
    protected CollectionBooks collectionBooks = new CollectionBooks();

    @Test
    public void getCollectionBooksTest() {
        collectionBooks = bookAdapter.getCollectionBooks();
    }

    @Test(dependsOnMethods = "getCollectionBooksTest")
    public void getBookByNameTest() {
        bookAdapter.getBookByName(collectionBooks, "git Pocket Guide");
    }

    @Test(dependsOnMethods = "getCollectionBooksTest")
    public void addBookToUserTest() {
        bookAdapter.addBookToUser(actualUser, collectionBooks, "git Pocket Guide");
    }

    @Test(dependsOnMethods = "addBookToUserTest")
    public void getUserTest() {
        userAdapter.getUser(actualUser);
    }

}
