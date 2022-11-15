import java.util.Objects;

public class PassengerCar extends Car<Mechanic<PassengerCar>> implements Competing {

    private BodyType bodyType;
    public PassengerCar(String brand, String model, double engineVolume, String bodyType, boolean serviceability) {
        super(brand, model, engineVolume, serviceability);
        this.bodyType = BodyType.findByBodyType(bodyType);

    }

    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хетчбэк"),
        COUPE("Купе"),
        STATION_WAGON("Универсал"),
        SUV("Внедорожник"),
        CROSSOVER("Кроссовер"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");

        public static BodyType findByBodyType(String bodyType) {
            for (BodyType type : values()) {
                if (type.getBodyType().equals(bodyType)) return type;
            }
            return null;
        }

        public static String identifyBodyType(PassengerCar car) {
            return car.bodyType != null ? car.bodyType.bodyType : "Нет информации";
        }
        private final String bodyType;

        BodyType(String bodyType) {
            this.bodyType = bodyType;
        }



        public String getBodyType() {
            return bodyType;
        }
    }


    //    public void inviteMechanic(Mechanic<PassengerCar> mechanic) {
//        if (!getMechanics().contains(mechanic)) getMechanics().add(mechanic);
//    }



    @Override
    public void pitStop() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " ушел на пит-стоп");
    }

    @Override
    public void bestLapTime() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " показал лучшее время круга t");
    }

    @Override
    public void maxSpeed() {
        System.out.println("Автомобиль " + getBrand() + " " + getModel() + " развил максимальную скорость v");
    }

//    @Override
//    public void inviteMechanic(Mechanic<PassengerCar> mechanic) {
//        if (!getMechanics().contains(mechanic)) getMechanics().add(mechanic);
//    }

    @Override
    public void makeDiagnostic() throws DiagnosisFailedExcepton {
        if (this.isServiceability()) System.out.println("Диагностика пройдена");
        else throw new DiagnosisFailedExcepton("Автомобиль " + getBrand() + " " + getModel() +
                " неисправен. Диагностика не пройдена");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PassengerCar that = (PassengerCar) o;
        return bodyType == that.bodyType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyType);
    }

    @Override
    public String toString() {
        return super.toString() + "Кузов: " + BodyType.identifyBodyType(this) + "\n";
    }
}
