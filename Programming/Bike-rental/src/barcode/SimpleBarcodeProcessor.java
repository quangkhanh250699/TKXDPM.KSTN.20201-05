package barcode;

public class SimpleBarcodeProcessor implements BarcodeProcessor {

    @Override
    public int processBarcode(String barcode) {
        return Integer.parseInt(barcode);
    }
}
