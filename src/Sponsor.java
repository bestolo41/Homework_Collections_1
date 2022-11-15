import java.util.Objects;

public class Sponsor {
    private String name;
    private int amountOfSupport;

    public Sponsor(String name) {
        setName(name);
    }


    private void setName(String name) {
        if (name != null || !name.isEmpty() || !name.isBlank()) this.name = name;
        else throw new RuntimeException("Введите корректное имя спонсора");
    }
    public String getName() {
        return name;
    }

    public int getAmountOfSupport() {
        return amountOfSupport;
    }

    public void sponsorTheRace(Car car, int amountOfSupport) {
        car.addSponsor(this, amountOfSupport);
    }

    public void stopSponsorTheRace(Car car) {
        car.removeSponsor(this);
    }

    public void setAmountOfSupport(int amountOfSupport) {
        if (amountOfSupport >= 0) this.amountOfSupport = amountOfSupport;
        else throw new RuntimeException("Сумма поддержки не может быть отрицательной");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sponsor sponsor = (Sponsor) o;
        return Objects.equals(name, sponsor.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Спонсор: " + getName() + "\n" +
                "Сумма спонсирования: " + getAmountOfSupport() + "\n";
    }
}
