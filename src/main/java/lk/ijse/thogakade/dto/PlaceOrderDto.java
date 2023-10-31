package lk.ijse.thogakade.dto;

/*
    @author DanujaV
    @created 10/31/23 - 4:02 PM   
*/

import lk.ijse.thogakade.dto.tm.CartTm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PlaceOrderDto {
    private String orderId;
    private String cusId;
    private LocalDate date;
    private List<CartTm> tmList = new ArrayList<>();
}
