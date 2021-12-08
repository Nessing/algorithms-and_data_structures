package ru.nessing.lesson_3.first;

public class BinarySearch {
    public static int binarySearchMissedElement(int[] arr) {
        int first = 0;
        int last = arr.length - 1;
        int mid = (first + last) / 2;

        while (first <= last) {
            if (arr[mid] == mid + 1) {
                first = mid + 1;
            } else if (arr[mid] < mid + 1) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            return first + 1;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int key) {
        int iteration = 0;
        int first = 0;
        int last = arr.length - 1;
        int mid = (first + last) / 2;

        while (first <= last) {
            iteration++;
            if (arr[mid] < key) {
                first = mid + 1;
            } else if (arr[mid] == key) {
                System.out.println(iteration);
                return mid;
            } else {
                last = mid - 1;
            }
            mid = (first + last) / 2;
        }
        if (first > last) {
            return -1;
        }
        return -1;
    }

    public static int interpolationSearch(int[] data, int item) {
        int iteration = 0;
        int highEnd = (data.length - 1);
        int lowEnd = 0;

        while (item >= data[lowEnd] && item <= data[highEnd] && lowEnd <= highEnd) {
            iteration++;

            int probe = lowEnd + (highEnd - lowEnd) * (item - data[lowEnd]) / (data[highEnd] - data[lowEnd]);

            if (highEnd == lowEnd) {
                if (data[lowEnd] == item) {
                    System.out.println("iter: " + iteration);
                    return lowEnd;
                } else {
                    System.out.println("iter: " + iteration);
                    return -1;
                }
            }

            if (data[probe] == item) {
                System.out.println("iter: " + iteration);
                return probe;
            }

            if (data[probe] < item) {
                lowEnd = probe + 1;
            } else {
                highEnd = probe - 1;
            }
        }
        System.out.println("iter: " + iteration);
        return -1;
    }

}
