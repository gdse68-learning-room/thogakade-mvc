package lk.ijse.thogakade.dto;

/*
    @author DanujaV
    @created 10/31/23 - 9:28 AM   
*/

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto {
    private String code;
    private String description;
    private double unitPrice;
    private int qtyOnHand;
}
