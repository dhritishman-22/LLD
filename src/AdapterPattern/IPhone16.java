package AdapterPattern;

public class IPhone16 implements Iphone {

    Charger iphone14toIphone16Adapter;

    public IPhone16(Charger iphone14toIphone16Adapter) {
        this.iphone14toIphone16Adapter = iphone14toIphone16Adapter;
    }

    @Override
    public void onCharge() {
        iphone14toIphone16Adapter.charge();
    }
}
