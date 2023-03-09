package models;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HumanUI {
    private String firstName;
    private String lastName;
    private String country;
    private String birthYear;
}
