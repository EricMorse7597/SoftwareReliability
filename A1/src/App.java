import java.util.Vector;

public class App {
    // public static void main(String[] args) throws Exception {
    //     Vector<Object> Va = null;
    //     Vector<Object> Vb = new Vector<Object>();
    //     Vector<Object> merge = new Vector<Object>();

    //     // Va.add("test1");
    //     // Va.add(2);
    //     Vb.add(null);
    //     Vb.add(5);

    //     // System.out.println(Va.toString());
    //     System.out.println(Vb.toString());
    //     merge = union(Va, Vb);
    //     System.out.println(merge.toString());
    // }

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

            // Add all elements from the first vector
            result.addAll(a);

            // Add elements from the second vector, only if they are not already in the
            // result
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
