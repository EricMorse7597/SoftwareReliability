import java.util.Vector;

public class App {

    public static Vector unionOld(Vector a, Vector b) {
        Vector result = new Vector();

        // add elements from vector a
        result.addAll(a);

        // add element fromv ector b only if they are in a
        for (Object element : b) {
            if (!result.contains(element)) {
                result.add(element);
            }
        }

        return result;
    }

    public static Vector<Object> union(Vector<Object> a, Vector<Object> b) {
        try {
            if (a == null) {
                throw new NullPointerException("Vector a must be provided");
            }
            if (b == null) {
                throw new NullPointerException("Vector b must be provided");
            }
            // Create a new vector to hold the union of the two vectors
            Vector<Object> result = new Vector<Object>();

            // Add all elements from the first vector, only if they are not already in the result or null
            for (Object element : a) {
                if (!result.contains(element) && element != null) {
                    result.add(element);
                }
            }

            // Add elements from the second vector, only if they are not already in the result or null
            for (Object element : b) {
                if (!result.contains(element) && element != null) {
                    result.add(element);
                }
            }

            // Return the resulting vector
            return result;
        } catch (Exception e) {
            if (e.getLocalizedMessage() != null) {
                System.out.println(e.getLocalizedMessage());
            } else {
                System.out.println(e.getCause());
            }
            return new Vector<Object>();
        }
    }
}
