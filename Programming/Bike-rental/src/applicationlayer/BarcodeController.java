package applicationlayer;

/**
 * This class manages operations related barcode.
 */
public class BarcodeController {

    /**
     * This class take the responsibility to make sure that barcode is right format given.
     * @param barcode String entered by user
     * @return true if barcode only contains numbers.
     */
    public boolean validateBarcode(String barcode) {
        try {
            Integer.parseInt(barcode);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
