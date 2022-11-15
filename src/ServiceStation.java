import java.util.LinkedList;
import java.util.Queue;

public abstract class ServiceStation {
    private static Queue<Car> queue = new LinkedList<>();

    public static void addCarToQueue(Car car) {
        if (!(car instanceof Bus)) queue.offer(car);
        System.out.println(queue);
    }

    public static void carryOutTechnicalInspectionOf() {
        try {
            queue.poll().makeDiagnostic();
        } catch (DiagnosisFailedExcepton e) {
            System.out.println(e.getMessage());
        }
    }
}
