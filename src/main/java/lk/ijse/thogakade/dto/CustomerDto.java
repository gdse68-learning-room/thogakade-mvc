package lk.ijse.thogakade.dto;

/*
    @author DanujaV
    @created 10/24/23 - 11:14 AM   
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
    private String id;
    private String name;
    private String address;
    private String tel;
}
