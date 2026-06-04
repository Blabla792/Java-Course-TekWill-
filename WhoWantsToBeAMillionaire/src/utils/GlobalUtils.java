package utils;

import java.util.Random;
import java.util.Scanner;

public final class GlobalUtils {
    public static final Random RANDOM = new Random();
    public static final Scanner SCANNER = new Scanner(System.in);

    private GlobalUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
