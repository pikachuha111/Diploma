package models;

import lombok.*;

import static com.codeborne.selenide.Selenide.$;

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
