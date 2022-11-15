import java.util.ArrayList;
import java.util.Arrays;

public class Racing {
    public static ArrayList<Car> participating = new ArrayList<>(12);

    public static void main(String[] args) throws DiagnosisFailedExcepton {

        PassengerCar lada = new PassengerCar("Lada", "Vesta", 1.6, "Универсал", false);
        PassengerCar kia = new PassengerCar("Kia", "Rio", 1.6, "Седан", true);
        PassengerCar vw = new PassengerCar("VW", "Polo", 1.6, "Седан", true);
        PassengerCar hyundai = new PassengerCar("Hyundai", "Solaris", 1.6, "Хетчбэк", true);

        Truck kamaz = new Truck("KAMAZ", "5490", 11.76, "свыше 12 тонн", true);
        Truck volvo = new Truck("Volvo", "FH16", 12.8,"свыше 12 тонн", false);
        Truck scania = new Truck("Scania", "R440", 12.7,"свыше 12 тонн", true);
        Truck daf = new Truck("DAF", "105 XF", 12.9,"свыше 12 тонн", true);

        Bus mersedes = new Bus("Mersedes", "Tourismo", 11.98,"40–50", true);
        Bus hyundaiBus = new Bus("Hyundai", "Universe", 12.3,"40–50", false);
        Bus daewoo = new Bus("Daewoo", "BH120F Royal Cruiser II", 11.1,"40–50", true);
        Bus higer = new Bus("Higer", "KLQ 6128 LQ", 9.46,"40–50", false);

        participating.add(lada);
        participating.add(kia);
        participating.add(vw);
        participating.add(hyundai);

        participating.add(kamaz);
        participating.add(volvo);
        participating.add(scania);
        participating.add(daf);

        participating.add(mersedes);
        participating.add(hyundaiBus);
        participating.add(daewoo);
        participating.add(higer);

        Sponsor gazprom = new Sponsor("Газпром");
        Sponsor rosneft = new Sponsor("Роснефть");
        Sponsor lukoil = new Sponsor("Лукойл");

        gazprom.sponsorTheRace(lada, 10000);
        gazprom.sponsorTheRace(kia, 20000);
        gazprom.sponsorTheRace(vw, 30000);
        rosneft.sponsorTheRace(lada, 40000);
        rosneft.sponsorTheRace(kia, 50000);
        rosneft.sponsorTheRace(vw, 60000);
        lukoil.sponsorTheRace(lada, 70000);
        lukoil.sponsorTheRace(kia, 80000);
        lukoil.sponsorTheRace(vw, 90000);
        gazprom.sponsorTheRace(lada, 5000);

        DriverB<PassengerCar> john = new DriverB<>("John", 5);
        DriverB<PassengerCar> mike = new DriverB<>("Mike", 5);
        DriverB<PassengerCar> alice = new DriverB<>("Alice", 5);
        DriverB<PassengerCar> jack = new DriverB<>("Jack", 5);

        DriverC<Truck> bob = new DriverC<>("Bob", 5);
        DriverC<Truck> nick = new DriverC<>("Nick", 5);
        DriverC<Truck> rachel = new DriverC<>("Rachel", 5);
        DriverC<Truck> patrick = new DriverC<>("Patrick", 5);

        DriverD<Bus> william = new DriverD<>("William", 5);
        DriverD<Bus> sarah = new DriverD<>("Sarah", 5);
        DriverD<Bus> george = new DriverD<>("George", 5);
        DriverD<Bus> joye = new DriverD<>("Joye", 5);

        lada.putBehindTheWheel(john);
        kia.putBehindTheWheel(mike);
        vw.putBehindTheWheel(alice);
        hyundai.putBehindTheWheel(jack);

        kamaz.putBehindTheWheel(patrick);
        volvo.putBehindTheWheel(bob);
        scania.putBehindTheWheel(nick);
        daf.putBehindTheWheel(rachel);

        mersedes.putBehindTheWheel(william);
        hyundaiBus.putBehindTheWheel(sarah);
        daewoo.putBehindTheWheel(george);
        higer.putBehindTheWheel(joye);

        Mechanic<PassengerCar> ben = new Mechanic<>("Ben");
        Mechanic<PassengerCar> bruce = new Mechanic<>("Bruce");
        Mechanic<Truck> gale = new Mechanic<>("Gale");
        Mechanic<Truck> stephen = new Mechanic<>("Stephen");
        Mechanic<Bus> steve = new Mechanic<>("Steve");
        Mechanic<Bus> frank = new Mechanic<>("Frank");
        Mechanic harry = new Mechanic("Harry");

        lada.inviteMechanic(ben);
        lada.inviteMechanic(ben);
        lada.inviteMechanic(bruce);
        kia.inviteMechanic(ben);
        kia.inviteMechanic(harry);
        vw.inviteMechanic(bruce);
        hyundai.inviteMechanic(harry);

        kamaz.inviteMechanic(gale);
        kamaz.inviteMechanic(harry);
        volvo.inviteMechanic(stephen);
        scania.inviteMechanic(stephen);
        scania.inviteMechanic(harry);
        daf.inviteMechanic(gale);
        daf.inviteMechanic(stephen);

        mersedes.inviteMechanic(steve);
        hyundaiBus.inviteMechanic(frank);
        daewoo.inviteMechanic(harry);
        higer.inviteMechanic(steve);
        higer.inviteMechanic(frank);
        higer.inviteMechanic(harry);


        Shop shop = new Shop();
        shop.increaseQueue("Person1");
        shop.increaseQueue("Person2");
        shop.increaseQueue("Person3");
        shop.increaseQueue("Person4");
        shop.increaseQueue("Person5");
        shop.increaseQueue("Person6");
        shop.increaseQueue("Person7");
        shop.increaseQueue("Person8");
        shop.increaseQueue("Person9");
        shop.increaseQueue("Person10");
        shop.increaseQueue("Person11");
        shop.increaseQueue("Person12");
        shop.increaseQueue("Person13");
        shop.increaseQueue("Person14");
        shop.increaseQueue("Person15");
        shop.openNewCashDesk();
        shop.openNewCashDesk();
        shop.openNewCashDesk();
//        shop.increaseQueue("Person16");
//        shop.increaseQueue("Person17");
//        shop.increaseQueue("Person18");
//        shop.increaseQueue("Person19");
//        shop.increaseQueue("Person20");
//        shop.increaseQueue("Person21");
//        shop.increaseQueue("Person22");
//        shop.increaseQueue("Person23");
//        shop.increaseQueue("Person24");
//        shop.increaseQueue("Person25");
//        shop.increaseQueue("Person26");
//        System.out.println(shop);

        System.out.println(shop.openCashDesks.get(1));
        System.out.println(shop.openCashDesks.get(1).toArray()[2]);

        System.out.println(shop.openCashDesks.get(1));


//        infoAbout(lada);
//        infoAbout(kia);
//        infoAbout(vw);
//        infoAbout(hyundai);
//        infoAbout(kamaz);
//        infoAbout(volvo);
//        infoAbout(scania);
//        infoAbout(daf);
//        infoAbout(mersedes);
//        infoAbout(hyundaiBus);
//        infoAbout(daewoo);
//        infoAbout(higer);
    }

//    public static void infoAbout(Car car) {
//        System.out.println("Автомобиль: " + car.getBrand() + " " + car.getModel() + "\n" +
//                "Водитель: " +
//                car.getDriver() + "\n" +
//                "Спонсоры:");
//        for (Sponsor s : car.getSponsors()) {
//            System.out.println(s.getName() + "\n" +
//                    "Сумма спонсирования: " + s.getAmountOfSupport());
//        }
//        System.out.println("Механики:");
//        for (Mechanic m : car.getMechanics()) {
//            System.out.println(m.getName());
//        }
//        System.out.println();
//    }



}