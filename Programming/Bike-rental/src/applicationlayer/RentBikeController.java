package applicationlayer;

import barcode.BarcodeProcessor;
import barcode.BarcodeProcessorFactory;
import checkout.CreditCard;
import datalayer.acessor.BikeAccessor;
import datalayer.model.Bike;

public class RentBikeController {

    private BarcodeProcessor barcodeProcessor;
    private BikeAccessor bikeAccessor;

    public RentBikeController() {
        this.barcodeProcessor = BarcodeProcessorFactory.getBarcodeProcessor();
        this.bikeAccessor = new BikeAccessor();
    }

    public Bike requestBike(String barcode) {
        int bikeId = this.barcodeProcessor.processBarcode(barcode);
        return bikeAccessor.get(bikeId);
    }

    public void requestRentBike(Bike bike, CreditCard creditCard) {
        return;
    }
}
