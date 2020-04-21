import java.util.Date;
import java.util.Vector;

public class VectorList {
    public static void main(String[] args) {
        Vector vector = new Vector();
        Date date = new Date();
        vector.add(new Integer(1));
        vector.add(new Float(3.45f));
        vector.add(new Double(7.75));
        vector.add(new Boolean(true));
        vector.add(date);
        System.out.println(vector.size());
        for (int i = 0; i < vector.size() ; i++) {
            System.out.println(vector.get(i));
        }
        if (vector.contains(date)) {
            System.out.println(date.toString());
        }

    }
}