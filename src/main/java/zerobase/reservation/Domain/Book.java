package zerobase.reservation.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "reserve")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uniqId;

    private String userid;
    private String userPhone;
    private String storeName;
    private int storeId;
    private int mngId;

    @Column(name = "book_date")
    private LocalDateTime bookDate;
}
