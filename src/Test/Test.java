package Test;

import Splay.SplayTree;

import java.util.ArrayList;
import java.util.Random;

public class Test <T extends Comparable<T>>  {

    private SplayTree<T> splayTree;

    Test(SplayTree<T> splayTree) {
        this.splayTree = splayTree;
    }

    public void checkInsertbasic(){
        splayTree = (SplayTree<T>) new SplayTree<Person>();
        Person person = new Person(8, "Marek", "Bugaj");
        splayTree.insert((T) person);

        person = new Person(5, "Andrej", "Bugaj");
        splayTree.insert((T) person);

        person = new Person(2, "Andrej", "Bugaj");
        splayTree.insert((T) person);

        person = new Person(5, "Andrej", "Bugaj");
        splayTree.insert((T) person);

        person = new Person(2, "Andrej", "Bugaj");
        splayTree.insert((T) person);

        System.out.println("koniec");
    }

    public boolean checkInsert() {
        Random randomGenerator = new Random();//seed: 63 - prvkov : 10  // seed: 1 - prvkov : 5
        ArrayList<Person> arr = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            randomGenerator.setSeed(i);
            System.out.println("Seed:******************************************************************************** " + i);
            arr = new ArrayList<>();
            splayTree = (SplayTree<T>) new SplayTree<Person>();

            for (int j = 0; j < 3000000; j++) {
                int Id = randomGenerator.nextInt(10000000);
                Person person = new Person(Id, "Marek", "Bugaj");
                //arr.add(person);
                System.out.println("Vkladam: " + person);
                boolean result = splayTree.insert((T) person);
                if (!result){
                    System.out.println("Prvok s rovnakym klucom sa uz v strome nachadza");
                }
            }

//            for (int k = 0; k < arr.size(); k++) {
//                Person personArr = arr.get(k);
//                T personTree = splayTree.find((T) personArr);
//                if (personTree != null) {
//                    System.out.println("true: DataArr: (" + personArr.getRC() + ")   " + "DataTree: (" + personTree.toString() + ")");
//                    //System.out.println("Seed: " + i);
//                } else {
//                    System.out.println("false, prvok sa v strome nenasiel: " + personTree.toString());
//                    return false;
//                }
//            }
        }
        return true;
    }
}
