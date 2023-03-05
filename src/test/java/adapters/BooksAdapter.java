package adapters;

import io.restassured.mapper.ObjectMapperType;
import models.Book;
import models.BookIndentifiers;
import models.CollectionBooks;
import models.User;
import org.apache.http.HttpStatus;
import utils.EndPoints;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BooksAdapter {

    private BookIndentifiers bookIndentifier = new BookIndentifiers();

    public CollectionBooks getCollectionBooks() {

        return given()
                .when()
                .get(EndPoints.GET_COLLECTION_BOOKS)
                .then()
//                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(CollectionBooks.class, ObjectMapperType.GSON);
    }

    public Book getByBookName(CollectionBooks collectionBooks, String bookName) {
        String bookIdentifer = null;
        for (Book bookObject : collectionBooks.getBooks()) {
            if (bookObject.getTitle().equalsIgnoreCase(bookName.trim())) {
                bookIdentifer = bookObject.getIsbn();
            }
        }

        return given()
                .pathParams("isbn", bookIdentifer)
                .when()
                .get(EndPoints.GET_BOOK)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(Book.class, ObjectMapperType.GSON);
    }

    public void addBook(User user, CollectionBooks collectionBooks, String bookName) {
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
                .log().body()
                .when()
                .post(EndPoints.ADD_BOOKS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_CREATED);
    }

}
