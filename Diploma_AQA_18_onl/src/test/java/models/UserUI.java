package models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserUI {
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

}