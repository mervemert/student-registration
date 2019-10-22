package tr.com.test.student.registration.util;

public class ValidateUtil {
    public static boolean isEmpty(Object object) {
        return object == null || object.equals("");
    }

    public static boolean isNotEmpty(Object object) {
        return object != null && !object.equals("");
    }
}
