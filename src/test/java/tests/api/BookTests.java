package tests.api;

import baseEntities.BaseApiTest;
import org.testng.annotations.Test;

public class BookTests extends BaseApiTest {

    @Test(priority = 1)
    public void getCollectionBooksTest() {
        collectionBooks = bookAdapter.getCollectionBooks();
    }

    @Test(priority = 2)
    public void getBookByNameTest() {
        bookAdapter.getByBookName(collectionBooks, "git Pocket Guide");
    }

    @Test( priority = 3)
    public void addBookToUserTest() {
        bookAdapter.addBook(actualUser, collectionBooks, "git Pocket Guide");
    }

    @Test(priority = 4)
    public void getUserTest() {
        userAdapter.getUser(actualUser);
    }

}
