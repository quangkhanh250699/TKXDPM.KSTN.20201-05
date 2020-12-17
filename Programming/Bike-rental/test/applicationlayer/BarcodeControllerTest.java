package applicationlayer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BarcodeControllerTest {

    private BarcodeController barcodeController;

    @BeforeEach
    void setUp() {
        barcodeController = new BarcodeController();
    }

    @ParameterizedTest
    @CsvSource({
            "1234,true",
            "as12,false"
    })
    void validateBarcode(String barcode, boolean expected) {

        boolean isValid = barcodeController.validateBarcode(barcode);

        assertEquals(expected, isValid);
    }
}