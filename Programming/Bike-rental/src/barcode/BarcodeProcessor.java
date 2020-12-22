package barcode;

/**
 * Interface processes barcodes
 */
public interface BarcodeProcessor {
    /**
     * Turn barcode to int code
     * @param barcode barcode of bike
     * @return bike id
     */
    int processBarcode(String barcode);
}
