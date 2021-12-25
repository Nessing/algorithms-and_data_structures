package ru.nessing.lesson_6;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Tree<Integer>> treeList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            TreeImpl<Integer> tree = new TreeImpl<>();
            for (int j = 0; j < 10; j++) {
                tree.add((int) (Math.random() * 25 * 2 - 25));
            }
            treeList.add(tree);
        }

        int iter = 1;
        for (Tree<Integer> integerTree : treeList) {
            System.out.println(iter++);
            integerTree.display();
        }
    }
}
