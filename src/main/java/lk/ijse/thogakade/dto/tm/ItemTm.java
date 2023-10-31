package lk.ijse.thogakade.dto.tm;

/*
    @author DanujaV
    @created 10/31/23 - 10:02 AM   
*/

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemTm {
    private String code;
    private String description;
    private int unitPrice;
    private int qtyOnHand;
    private int x;
    private Button btn;
}
