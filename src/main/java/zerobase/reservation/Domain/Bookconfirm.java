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
@Entity(name = "bookconfirm")
public class Bookconfirm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uniqSeq;

    private String status;
    private int deptId;
    private int mngId;

    private String userid;
    private String userPhone;
    private String storeName;
    private LocalDateTime bookDate;
}
