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

    private String userName;

    @SerializedName("password")
    private String userPassword;

}
