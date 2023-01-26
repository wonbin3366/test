package shop.mtcoding.test.model;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Board {
    private int id;
    private String title;
    private int userId;
    private Timestamp createdAt;
}
