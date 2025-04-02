import DesignPatterns.AbstractFactoryPattern.Computer;
import DesignPatterns.AbstractFactoryPattern.Factory.ComputerFactory;
import DesignPatterns.AbstractFactoryPattern.Factory.PCFactory;
import DesignPatterns.AbstractFactoryPattern.Factory.ServerFactory;
import DesignPatterns.AdapterPattern.IPhone14toIPhone16Adapter;
import DesignPatterns.AdapterPattern.IPhone16;
import DesignPatterns.BuilderPattern.Laptop;
import DesignPatterns.DecoratorPattern.BasicCar;
import DesignPatterns.DecoratorPattern.Car;
import DesignPatterns.DecoratorPattern.LuxuryCar;
import DesignPatterns.DecoratorPattern.SportsCar;
import DesignPatterns.FacadePattern.HelperFacade;
import DesignPatterns.ObservablePattern.Observable.AndroidObservableImpl;
import DesignPatterns.ObservablePattern.Observable.IphoneObservableImpl;
import DesignPatterns.ObservablePattern.Observable.StocksObservable;
import DesignPatterns.ObservablePattern.Observer.EmailAlertObserverImpl;
import DesignPatterns.ObservablePattern.Observer.MobileAlertObserverImpl;
import DesignPatterns.ObservablePattern.Observer.NotificationAlertObserver;
import DesignPatterns.StatePattern.TVContext;
import DesignPatterns.StatePattern.TVStartState;
import DesignPatterns.StatePattern.TVStopState;
import DesignPatterns.StrategyPattern.Item;
import DesignPatterns.StrategyPattern.ShoppingCart;
import DesignPatterns.StrategyPattern.Strategy.CreditCardStrategy;
import DesignPatterns.StrategyPattern.Strategy.PaypalStrategy;

public class Main {

    public static void main(String[] args) {
        // Call the test methods
        testDecoratorPattern();
    }

    public static void testStrategyPattern() {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("001", 10));
        cart.addItem(new Item("002", 15));
        cart.addItem(new Item("003", 20));
        cart.pay(new PaypalStrategy("5hL9h@example.com", "mypwd"));
        cart.pay(new CreditCardStrategy("John Doe", "5555 5555 5555 4444", "123", "12/15"));
    }

    public static void testObserverPattern() {
        StocksObservable androidStocksObservable = new AndroidObservableImpl();
        StocksObservable iphoneStocksObservable = new IphoneObservableImpl();

        NotificationAlertObserver observer1 = new MobileAlertObserverImpl("BlackBird", androidStocksObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("5hL9h@example.com", iphoneStocksObservable);
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl("9hL9h@example.com", androidStocksObservable);
        NotificationAlertObserver observer4 = new MobileAlertObserverImpl("RapidMajesty", iphoneStocksObservable);

        androidStocksObservable.registerObserver(observer1);
        androidStocksObservable.registerObserver(observer2);
        androidStocksObservable.registerObserver(observer3);
        androidStocksObservable.registerObserver(observer4);

        androidStocksObservable.setStockCount(0);
        System.out.println();
        androidStocksObservable.removeObserver(observer3);
        androidStocksObservable.setStockCount(5);
        androidStocksObservable.setStockCount(0);
    }

    public static void testDecoratorPattern() {
        Car sportsCar = new SportsCar(new BasicCar());
        sportsCar.assemble();
        System.out.println("\n*****");
        Car sportsLuxuryCar = new SportsCar(new LuxuryCar(new BasicCar()));
        sportsLuxuryCar.assemble();
    }

    public static void testAbstractFactoryPattern() {
        Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB", "500 GB", "2.4 GHz"));
        Computer server = ComputerFactory.getComputer(new ServerFactory("10 GB", "1 TB", "2.9 GHz"));
        System.out.println("Abstract Factory PC Config::" + pc);
        System.out.println("Abstract Factory Server Config::" + server);
    }

    public static void testStatePattern() {
        TVContext context = new TVContext();
        context.setState(new TVStartState());
        context.doAction();
        context.setState(new TVStopState());
        context.doAction();
    }

    public static void testBuilderPattern() {
        Laptop laptop = new Laptop.ComputerBuilder("500 GB", "2 GB", "2.4 GHz")
                .setBluetoothEnabled(true)
                .setGraphicsCardEnabled(false)
                .build();
        System.out.println("cpu = " + laptop.getCPU() + ", hdd = " + laptop.getHDD() + ", ram = " + laptop.getRAM() + ", isGraphicsCardEnabled = " + laptop.isGraphicsCardEnabled() + ", isBluetoothEnabled = " + laptop.isBluetoothEnabled());
    }

    public static void testAdapterPattern() {
        IPhone16 iPhone16 = new IPhone16(new IPhone14toIPhone16Adapter());
        iPhone16.onCharge();
    }

    public static void testFacadePattern() {
        String tableName="Employee";
        /* using the facade helper reduces complexity and amount of code at the client side */
        HelperFacade.generateReport(HelperFacade.DBTypes.MYSQL, HelperFacade.ReportTypes.HTML, tableName);
        HelperFacade.generateReport(HelperFacade.DBTypes.ORACLE, HelperFacade.ReportTypes.PDF, tableName);
    }
}