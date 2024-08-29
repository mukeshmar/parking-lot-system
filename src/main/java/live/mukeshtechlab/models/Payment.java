package live.mukeshtechlab.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Payment extends BaseModel {
    private int amount;
    private PaymentStatus status;
    private String transactionId; // Payment Gateway Transaction Id
    private Bill bill;
    private PaymentMode paymentMode;
    private Date paymentTime;
}
