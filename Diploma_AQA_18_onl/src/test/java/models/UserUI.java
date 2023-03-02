package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserUI {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

}
