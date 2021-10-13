package com.igonincompany.autonumber.models;
import java.util.*;

public enum LetterEnum {
    А, Е, Т, О, Р, Н, У, К, Х, С, В, М;

    private static final List<LetterEnum> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();
    public static final char MIN_LETTER = 'А';
    public static final char MAX_LETTER = 'Х';

    public static LetterEnum randomLetter() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }

    public static LetterEnum nextLetter(char letter) {
        Comparator<LetterEnum> comparator = (l1, l2) -> l1.name().compareTo(l2.name());
        List<LetterEnum> list = new ArrayList<>();
        list.addAll(VALUES);
        Collections.sort(list, comparator);
        int result = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toString().equals(Character.toString(letter))) {
                result = ++i;
                break;
            }
        }
        return list.get(result);
    }
}