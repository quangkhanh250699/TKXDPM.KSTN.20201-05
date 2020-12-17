package applicationlayer;

public class BarcodeController {

    public boolean validateBarcode(String barcode) {
        try {
            Integer.parseInt(barcode);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
