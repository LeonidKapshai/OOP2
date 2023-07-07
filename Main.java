import java.io.IOException;
import io.Loader;
import io.Saver;
import genTree.GenTree;
import genTree.Gender;
import genTree.Human;

public class Main {
    public static void main(String[] args) {
        GenTree tree = new GenTree();
        int id = 1;

        // id = 1
        Human sashka = new Human(id, "Kapshai", "Sashka", "Sergeevich", Gender.man);
        sashka.setBirthDate(10, 01, 2023);
        id += 1;
        tree.addHuman(sashka);

        // id = 2
        Human anton = new Human(id, "Losev", "Anton", "Viktorovich", Gender.man);
        anton.setBirthDate(31, 07, 1992);
        id += 1;
        tree.addHuman(anton);
        tree.addParentToId(anton, 1);

        // id = 3
        Human nastya = new Human(id, "Loseva", "Nastia", "Sergeevna", Gender.woman);
        nastya.setBirthDate(18, 10, 1993);
        id += 1;
        tree.addHuman(nastya);
        tree.addParentToId(nastya, 1);

        // id = 4
        Human yuri = new Human(id, "Losev", "Yuri", "Sergeevich", Gender.man);
        yuri.setBirthDate(02, 02, 1958);
        yuri.setDeathDate(23, 06, 2012);
        id += 1;
        tree.addHuman(yuri);
        tree.addParentToId(yuri, 3);

        // id = 5
        Human sveta = new Human(id, "Losev", "Svetlana", "Leonidovna", Gender.woman);
        sveta.setBirthDate(14, 04, 1962);
        id += 1;
        tree.addHuman(sveta);
        tree.addParentToId(sveta, 3);

        // id = 6
        Human viktor = new Human(id, "Losev", "Viktor", "Sergeevich", Gender.man);
        viktor.setBirthDate(16, 05, 1972);
        id += 1;
        tree.addHuman(viktor);
        tree.addParentToId(viktor, 2);

        // id = 7
        Human tanya = new Human(id, "Losev", "Tatiana", "Aleksandrovna", Gender.woman);
        tanya.setBirthDate(26, 04, 1973);
        id += 1;
        tree.addHuman(tanya);
        tree.addParentToId(tanya, 2);

        // id = 8
        Human ivan = new Human(id, "Losev", "Ivan", "Sergeevich", Gender.man);
        ivan.setBirthDate(18, 10, 1993);
        id += 1;
        tree.addHuman(ivan);
        tree.addChildToId(ivan, 4);
        tree.addChildToId(ivan, 5);

        Saver saver = new Saver();
        try {
            saver.saveData(tree, "MyGenTree");
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }

        try {
            saver.saveData(sveta, "Svetlana");
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }


        Loader loader = new Loader();
        try {
            GenTree restTree = (GenTree)loader.loadData("MyGenTree.genTree");
            restTree.showAllHumans();
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        catch (ClassNotFoundException clsnfe) {
            System.out.println(clsnfe.getMessage());
        }

        try {
            Human restHuman = (Human)loader.loadData("Svetlana.human");
            restHuman.showFullInfo();
        }
        catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
        catch (ClassNotFoundException clsnfe) {
            System.out.println(clsnfe.getMessage());
        }
    }
}