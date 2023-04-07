package serializable;

import lombok.Data;
import java.io.Serializable;

@Data
public class Bus  extends Vehical implements  Serializable {
    private int noOfWheel;
    private String VehicalNo;

}
