public class TestFor {
    public static void main(final String[] args) {
        int i = 0, j = 5;
        for ( ; (i<3) && (j++ < 10); i++) {
            System.out.print(" " + i + " " + j);
        }

        System.out.print(" " + i + " " + j);

    }
}
