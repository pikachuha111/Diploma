package models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CollectionBooks {

    List<Book> books = new ArrayList<>();
}
