import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

public class Shop {
    private static final int NUMBER_OF_CASH_DESK = 5;
    private static final int MAX_PEOPLE_IN_QUEUE = 5;

    public int numOpenCashDesk = 0;
    public final ArrayList<Deque<String>> openCashDesks = new ArrayList<>(NUMBER_OF_CASH_DESK);

    public Shop() {
        openNewCashDesk();
    }

    public void increaseQueue(String person) {
        for (int i = numOpenCashDesk - 1; i < openCashDesks.size(); i++) {
            if (openCashDesks.get(i).size() < MAX_PEOPLE_IN_QUEUE) {
                openCashDesks.get(returnIndexOfMinQueue()).offer(person);
                break;
            } else if (i < 4) {
                openNewCashDesk();
                openCashDesks.get(returnIndexOfMinQueue()).offer(person);
                int numTransitioningPeople = MAX_PEOPLE_IN_QUEUE - (((numOpenCashDesk - 1) * MAX_PEOPLE_IN_QUEUE + 1)/numOpenCashDesk);
                int numAllTransitioningPeople = numTransitioningPeople * (numOpenCashDesk - 1);
                String[] shift = new String[numAllTransitioningPeople];
                int count = 0;
                for (int j = 0; j < numTransitioningPeople; j++) {
                    for (int k = 0; k < numOpenCashDesk - 1; k++) {
                        shift[count] = openCashDesks.get(k).pollLast();
                        count++;
                    }
                }
                for (int j = shift.length - 1; j >= 0 ; j--) {
                    openCashDesks.get(returnIndexOfMinQueue()).offer(shift[j]);
                }
                break;
            }
            else System.out.println("Кассы переполнены");
        }
    }

    public void openNewCashDesk() {
        openCashDesks.add(new ArrayDeque<>(MAX_PEOPLE_IN_QUEUE));
        numOpenCashDesk++;
    }

    public int returnIndexOfMinQueue() {
        Queue<String> q = null;
        int min = Integer.MAX_VALUE;
        for (Queue<String> a : openCashDesks) {
            if (a.size() < min) {
                min = a.size();
                q = a;
            }
        }
        return openCashDesks.indexOf(q);
    }

    @Override
    public String toString() {
        String text = "";
        for (Queue q : openCashDesks) {
            text = text + q + "\n";
        }
        return text;
    }
}
