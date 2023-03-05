package utils;

public class EndPoints {
    public static final String CREATE_USER = "/Account/v1/User";
    public static final String GENERATE_TOKEN_USER = "/Account/v1/GenerateToken";
    public static final String LOGIN_USER = "/Account/v1/Login";
    public static final String GET_USER = "/Account/v1/User/{uuid}";
    public static final String AUTHORIZED_USER = "/Account/v1/Authorized";
    public static final String DELETE_USER = "/Account/v1/User/{uuid}";

    public static final String GET_COLLECTION_BOOKS = "/BookStore/v1/Books";
    public static final String GET_BOOK = "/BookStore/v1/Book?ISBN={isbn}";
    public static final String ADD_BOOKS = "/BookStore/v1/Books";

}
