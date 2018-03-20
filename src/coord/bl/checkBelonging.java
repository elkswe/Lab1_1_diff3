package coord.bl;

public final class checkBelonging {

    private checkBelonging() {
    }

    public static boolean check(double x, double y) {
        return !((x > 4 || x < -4 || y > 5 || y < 0) &&
                (x > 6 || x < -6 || y > 0 || y < -3)
        );
    }

    public static boolean correctData(String fieldText) {
        return (!fieldText.equals("") && !fieldText.equals("-"));
    }
}
