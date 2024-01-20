package lib.util;

public class EnumUtils {
    public static <T extends Enum<T>> T convertIntToEnum(int value, Class<T> type) {
        T[] values = type.getEnumConstants();
        return values[value <= 0 ? 0 : Math.abs(value - 1) % values.length];
    }
}
