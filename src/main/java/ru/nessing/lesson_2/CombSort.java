package ru.nessing.lesson_2;

public class CombSort {
    // To find gap between elements
    static int getNextGap(int gap) {
        // Shrink gap by Shrink factor
        gap = (gap * 10) / 13;
        if (gap < 1)
            return 1;
        return gap;
    }

    // Function to sort arr[] using Comb Sort
    void sort(int arr[]) {
        int n = arr.length;

        // initialize gap
        int gap = n;

        // Initialize swapped as true to make sure that
        // loop runs
        boolean swapped = true;

        // Keep running while gap is more than 1 and last
        // iteration caused a swap
        while (gap != 1 || swapped == true) {
            // Find next gap
            gap = getNextGap(gap);

            // Initialize swapped as false so that we can
            // check if swap happened or not
            swapped = false;

            // Compare all elements with current gap
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    // Swap arr[i] and arr[i+gap]
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;

                    // Set swapped
                    swapped = true;
                }
            }
        }
    }

    static void sortPrice(Notebook arr[]) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;

        while (gap != 1 || swapped == true) {
            gap = getNextGap(gap);
            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                if (arr[i].getPrice() > arr[i + gap].getPrice()) {
                    Notebook temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;

                    swapped = true;
                }
            }
        }
    }

    static void sortMemory(Notebook arr[]) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;

        while (gap != 1 || swapped == true) {
            gap = getNextGap(gap);
            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                if (arr[i].getPrice() == arr[i + gap].getPrice()) {
                    if (arr[i].getMemory() > arr[i + gap].getMemory()) {
                        Notebook temp = arr[i];
                        arr[i] = arr[i + gap];
                        arr[i + gap] = temp;

                        swapped = true;
                    }
                }
            }
        }
    }

    static void sortName(Notebook arr[]) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;

        while (gap != 1 || swapped == true) {
            gap = getNextGap(gap);
            swapped = false;

            for (int i = 0; i < n - gap; i++) {
                if (arr[i].getPrice() == arr[i + gap].getPrice()) {
                    if (arr[i].getMemory() == arr[i + gap].getMemory()) {
                        if (arr[i].getPosition() > arr[i + gap].getPosition()) {
                            Notebook temp = arr[i];
                            arr[i] = arr[i + gap];
                            arr[i + gap] = temp;

                            swapped = true;
                        }
                    }
                }
            }
        }
    }
}
