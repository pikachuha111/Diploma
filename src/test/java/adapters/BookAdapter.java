package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Book;
import models.BookIndentifiers;
import models.CollectionBooks;
import models.User;
import org.apache.http.HttpStatus;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.EndPoints;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BookAdapter {
    Logger logger = LogManager.getLogger(BookAdapter.class);

    private BookIndentifiers bookIndentifier = new BookIndentifiers();

    public CollectionBooks getCollectionBooks() {

        logger.info("Getting collection of books method ... ");

        return given()
                .when()
                .get(EndPoints.GET_COLLECTION_BOOKS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(CollectionBooks.class, ObjectMapperType.GSON);

    }

    public Book getByBookName(CollectionBooks collectionBooks, String bookName) {

        logger.info("Getting book of collection by name method ... ");

        String bookIdentifier = null;
        for (Book bookObject : collectionBooks.getBooks()) {
            if (bookObject.getTitle().equalsIgnoreCase(bookName.trim())) {
                bookIdentifier = bookObject.getIsbn();
            }
        }

        return given()
                .pathParams("isbn", bookIdentifier)
                .when()
                .get(EndPoints.GET_BOOK)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Book.class, ObjectMapperType.GSON);
    }

    public void addBook(User user, CollectionBooks collectionBooks, String bookName) {

        logger.info("Adding book to User method ... ");

        List<BookIndentifiers> booksList = new ArrayList<>();
        for (Book bookObject : collectionBooks.getBooks()) {
            if (bookObject.getTitle().equalsIgnoreCase(bookName.trim())) {
                bookIndentifier.setBookIdentifier(bookObject.getIsbn());
            }
        }
        booksList.add(bookIndentifier);
        user.setCollectionOfIsbns(booksList);

        given()
                .body(user, ObjectMapperType.GSON)
                .when()
                .post(EndPoints.ADD_BOOKS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED);
    }

}
