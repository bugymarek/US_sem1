package Test;

import Splay.SplayTree;

public class Main {

    public static void main(String[] args) {
        SplayTree<Person> splayTree = new SplayTree<>();

        Test<Person> test = new Test<>(splayTree);
        //test.checkDelete();
        test.checkInsertbasic();
    }
}
