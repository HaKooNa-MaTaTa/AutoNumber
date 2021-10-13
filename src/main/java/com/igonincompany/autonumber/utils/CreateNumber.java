package com.igonincompany.autonumber.utils;


import com.igonincompany.autonumber.models.LetterEnum;
import com.igonincompany.autonumber.models.Number;

public class CreateNumber {

    public static final String RANDOM = "random";
    public static final String NEXT = "next";

    OperWithNumbers operWithNumbers = new OperWithNumbers();

    public String createNumber(String req) {
        Number number = Number.getInstance();
        StringBuilder stringBuilder = new StringBuilder();

        if (req.equals(RANDOM)) {
            stringBuilder.append(LetterEnum.randomLetter());
            stringBuilder.append(operWithNumbers.randomNumber(3, 10));
            stringBuilder.append(LetterEnum.randomLetter());
            stringBuilder.append(LetterEnum.randomLetter());
            stringBuilder.append(Number.REGION);

            number.setNumber(stringBuilder.toString());
            if (!number.getNumbers().contains(number.getNumber())) {
                number.getNumbers().add(number.getNumber());
                return number.getNumber();
            } else {
                return createNumber(req);
            }
        } else {
            if (number.getNumber() == null) {
                createNumber(RANDOM);
            }
            char[] array = number.getNumber().toCharArray();

            switch (operWithNumbers.check(number.getNumber())) {
                case 0:
                    stringBuilder.append("А000АА");
                    stringBuilder.append(Number.REGION);
                    number.setNumber(stringBuilder.toString());
                    if (number.getNumbers().contains(number.getNumber())) {
                        number.getNumbers().add(number.getNumber());
                    } else {
                        createNumber(NEXT);
                    }
                    break;

                case 1:
                    stringBuilder.append(LetterEnum.nextLetter(array[0]));
                    stringBuilder.append(operWithNumbers.randomNumber(3,0));
                    stringBuilder.append(LetterEnum.MIN_LETTER);
                    stringBuilder.append(LetterEnum.MIN_LETTER);
                    stringBuilder.append(Number.REGION);
                    number.setNumber(stringBuilder.toString());
                    if (!number.getNumbers().contains(number.getNumber())) {
                        number.getNumbers().add(number.getNumber());
                    } else {
                        createNumber(NEXT);
                    }
                    break;

                case 2:
                    stringBuilder.append(array[0]);
                    stringBuilder.append(operWithNumbers.randomNumber(3,0));
                    stringBuilder.append(LetterEnum.nextLetter(array[4]));
                    stringBuilder.append(LetterEnum.MIN_LETTER);
                    stringBuilder.append(Number.REGION);
                    number.setNumber(stringBuilder.toString());
                    if (!number.getNumbers().contains(number.getNumber())) {
                        number.getNumbers().add(number.getNumber());
                    } else {
                        createNumber(NEXT);
                    }
                    break;

                case 3:
                    stringBuilder.append(array[0]);
                    stringBuilder.append(operWithNumbers.randomNumber(3,0));
                    stringBuilder.append(array[4]);
                    stringBuilder.append(LetterEnum.nextLetter(array[5]));
                    stringBuilder.append(Number.REGION);
                    number.setNumber(stringBuilder.toString());
                    if (!number.getNumbers().contains(number.getNumber())) {
                        number.getNumbers().add(number.getNumber());
                    } else {
                        createNumber(NEXT);
                    }
                    break;

                case 4:
                    int value = Integer.valueOf(array[1] + "" + array[2] + "" + array[3]);
                    ++value;
                    stringBuilder.append(array[0]);
                    if (value < 10) {
                        stringBuilder.append("00");
                    } else if (value < 100) {
                        stringBuilder.append("0");
                    }
                    stringBuilder.append(value);
                    stringBuilder.append(array[4]);
                    stringBuilder.append(array[5]);
                    stringBuilder.append(Number.REGION);
                    number.setNumber(stringBuilder.toString());
                    if (!number.getNumbers().contains(number.getNumber())) {
                        number.getNumbers().add(number.getNumber());
                    } else {
                        createNumber(NEXT);
                    }
                    break;
            }

            return number.getNumber();
        }
    }
}
