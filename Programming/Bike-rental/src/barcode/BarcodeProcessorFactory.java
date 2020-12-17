package barcode;

public class BarcodeProcessorFactory {
    public static final BarcodeProcessor getBarcodeProcessor() {
        return new SimpleBarcodeProcessor();
    }
}
