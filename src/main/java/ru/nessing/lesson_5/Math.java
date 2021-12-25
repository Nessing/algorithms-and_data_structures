package ru.nessing.lesson_5;

public class Math {
    private static int buf;

    public static int sqrt(int num, int sqr) {
        if (num == 0 || sqr == 0) throw new IllegalArgumentException("число и степень не должны быть равны нулю");

        if (buf == 0) {
            buf = num;
        }

        if (sqr <= 1) {
            return num;
        }
        num = num * buf;
        num = sqrt(num, sqr - 1);
        return num;
    }
}
