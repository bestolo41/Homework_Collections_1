import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public abstract class Car<T extends Mechanic<?>> {
    private String brand;
    private String model;
    private double engineVolume;
    private boolean serviceability;
    private Driver driver;

    private LinkedList<Sponsor> sponsors = new LinkedList<>();
    private LinkedList<Mechanic<?>> mechanics = new LinkedList<>();
    private int sponsorshipFund = 0;

    public Car(String brand, String model, double engineVolume, boolean serviceability) {

        setBrand(brand);
        setModel(model);
        setEngineVolume(engineVolume);
        setServiceability(serviceability);
    }

    public final void startMotion() {
        System.out.println("Автомобиль начинает движение");
    }

    public final void endMotion() {
        System.out.println("Автомобиль завершает движение");
    }

    public void putBehindTheWheel(Driver driver) {
        if ((driver instanceof DriverB && this instanceof PassengerCar) ||
                (driver instanceof DriverC && this instanceof Truck) ||
                (driver instanceof DriverD && this instanceof Bus)) {
            for (int i = 0; i < Racing.participating.size(); i++) {
                if (Racing.participating.get(i).getDriver() != null && Racing.participating.get(i).getDriver().equals(driver)) {
                    Racing.participating.get(i).setDriver(null);
                    break;
                }
            }
            this.setDriver(driver);
        } else throw new RuntimeException("Категория прав водителя не соответствует категории авто");
    }

    public void inviteMechanic(T mechanic) {
        if (!getMechanics().contains(mechanic)) getMechanics().add(mechanic);
    }



    public String getBrand() {
        return brand;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setServiceability(boolean serviceability) {
        this.serviceability = serviceability;
    }

    public boolean isServiceability() {
        return serviceability;
    }

    private void setDriver(Driver driver) {
        this.driver = driver;
    }

    public final void setBrand(String brand) {
        if (brand == null || brand.isEmpty() || brand.isBlank()) this.brand = "default";
        else this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public final void setModel(String model) {
        if (model == null || model.isEmpty() || model.isBlank()) this.model = "default";
        else this.model = model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public final void setEngineVolume(double engineVolume) {
        if (engineVolume <= 0) this.engineVolume = 1.5;
        else this.engineVolume = engineVolume;
    }



    protected abstract void makeDiagnostic() throws DiagnosisFailedExcepton;

    public void addSponsor(Sponsor sponsor, int amountOfSupport) {
        Sponsor newSponsor = new Sponsor(sponsor.getName());
        newSponsor.setAmountOfSupport(amountOfSupport);
        if (sponsors.contains(sponsor)) {
            int i = sponsors.indexOf(sponsor);
            sponsors.get(i).setAmountOfSupport(sponsors.get(i).getAmountOfSupport() + amountOfSupport);
        } else sponsors.add(newSponsor);
        this.sponsorshipFund = this.sponsorshipFund + amountOfSupport;
    }

    public void removeSponsor(Sponsor sponsor) {
        sponsorshipFund = sponsorshipFund - sponsors.get(sponsors.indexOf(sponsor)).getAmountOfSupport();
        sponsors.remove(sponsor);
    }

    public LinkedList<Sponsor> getSponsors() {
        return sponsors;
    }

    public int getSponsorshipFund() {
        return sponsorshipFund;
    }

    public LinkedList<Mechanic<?>> getMechanics() {
        return mechanics;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume);
    }

    @Override
    public String toString() {
        return "\nМарка: " + getBrand() + "\n" +
                "Модель: " + getModel() + "\n" +
                "Объем двигателя: " + getEngineVolume() + "\n" +
                "Водитель: " + getDriver() + "\n";
    }
}
