package zerobase.reservation.DTO;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.Column;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
//@NoArgsConstructor
@ToString
public class StoreListDto {
    private int id;
    private String name;
    private String place;

//@Column(columnDefinition = "0")
    @ColumnDefault("0")
    @Builder.Default
    private Integer star=0;

    public StoreListDto() {
        star = 0;
    }

}
