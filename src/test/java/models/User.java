package models;

import lombok.*;

import java.util.List;

@Data
public class User {

    private String userName;

    private String password;

    private String userId;

    private String result;

    private List<BookIndentifiers> collectionOfIsbns;

}
