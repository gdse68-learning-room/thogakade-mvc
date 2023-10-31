package lk.ijse.thogakade.dto.tm;

/*
    @author DanujaV
    @created 10/24/23 - 4:28 PM   
*/

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
/*@Getter
@Setter
@ToString*/
public class CustomerTm {
    private String id;
    private String name;
    private String address;
    private String tel;
}
