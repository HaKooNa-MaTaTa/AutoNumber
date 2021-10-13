package com.igonincompany.autonumber.utils;

import com.igonincompany.autonumber.models.LetterEnum;

public class OperWithNumbers {

    public static final int MAX_NUMBER_VALUE = 999;

    /**
        Метод возвращает строковое число:
        a - количество разрядов числа
        b - верхняя граница рандома
     **/
    public String randomNumber(int a, int b) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < a; i++) {
            stringBuilder.append((int) (Math.random() * b));
        }
        return stringBuilder.toString();
    }

    /**
        Метод определяет, что именно нужно итерировать:
        0 - номер выглядит так Х999ХХ
        1 - итерируется первая буква, все остальное принимает минимальное значение
        2 - итерируется предпоследня буква, число и последняя буква принимают минимальное значение
        3 - итерируется последняя буква, число принимает минимальное значение
        4 - итерируется числовое значение
     **/
    public int check(String number) {
        char[] array = number.toCharArray();
        int value = Integer.valueOf(array[1] + "" + array[2] + "" + array[3]);
        int result = -1;

        if (value == MAX_NUMBER_VALUE) {
            if (array[5] == LetterEnum.MAX_LETTER) {
                if (array[4] == LetterEnum.MAX_LETTER) {
                    if (array[0] == LetterEnum.MAX_LETTER) {
                        return result = 0;
                    } else {
                        return result = 1;
                    }
                }
                return result = 2;
            }
            return result = 3;
        } else {
            return result = 4;
        }
    }
}
