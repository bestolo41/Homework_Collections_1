import java.util.Objects;

public class Mechanic<C extends Car> {
    private String name;
    private String company;

    public Mechanic(String name) {
        setName(name);
    }

    public void performDiagnosticsOf(C car) {
        if (car.getMechanics().contains(this)) {
            try {
                car.makeDiagnostic();
            } catch (DiagnosisFailedExcepton e) {
                System.out.println(e.getMessage());
            }
        } else {
            throw new RuntimeException(getName() + " не является механиком машины " + car.getBrand() + " " + car.getModel());
        }
    }

    public void fixCar(C car) {
        if (car.getMechanics().contains(this)) {
            if (car.isServiceability()) {
                System.out.println("Авто " + car.getBrand() + " " + car.getModel() + " в ремонте не нуждается");
            }
            else {
                car.setServiceability(true);
                System.out.println("Авто " + car.getBrand() + " " + car.getModel() + " отремонтирован");
            }
        } else throw new RuntimeException(getName() + " не является механиком машины " + car.getBrand() + " " + car.getModel());
    }
    public void setName(String name) {
        if (name != null || !name.isBlank() || !name.isEmpty()) this.name = name;
        else throw new RuntimeException("Некорректное имя");
    }

    public void setCompany(String company) {
        if (company != null || !company.isBlank() || !company.isEmpty()) this.company = company;
        else throw new RuntimeException("Некорректное название компании");
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Механик: \n" +
                "\tИмя: " + getName() + "\n" +
                "\tКомпания: " + getCompany() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mechanic<?> mechanic = (Mechanic<?>) o;
        return Objects.equals(name, mechanic.name) && Objects.equals(company, mechanic.company);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, company);
    }
}
