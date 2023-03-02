package models;

import com.google.gson.annotations.SerializedName;
import lombok.*;
@Data
public class UserLogin {

    private String userName;

    private String password;

    private String userID;


}
