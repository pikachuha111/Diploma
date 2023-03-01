package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {

    private String userId;

    private String userName; // поле передается при логине

    private String username; // поле после логина(в ответе)

    @SerializedName("password")
    private String userPassword;



}
