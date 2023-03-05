package tests.api;

import baseEntities.BaseApiTest;
import org.testng.annotations.Test;

public class Tests extends BaseApiTest {

    @Test(priority = 1)
    public void getCollectionBooks() {
        collectionBooks = booksAdapter.getCollectionBooks();
    }

    @Test(priority = 2)
    public void getBookByName() {
        booksAdapter.getByBookName(collectionBooks, "git Pocket Guide");
    }

    @Test( priority = 3)
    public void addBookToUser() {
        booksAdapter.addBook(actualUser, collectionBooks, "git Pocket Guide");
    }

    @Test(priority = 4)
    public void getUser() {
        userAdapter.getUser(actualUser);
    }

}
