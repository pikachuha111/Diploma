package models;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class BookIndentifiers {
    @SerializedName("isbn")
    private String bookIdentifier;
}
