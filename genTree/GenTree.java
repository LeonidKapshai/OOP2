package genTree;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import interfaces.Loadable;
import interfaces.Saveable;

public class GenTree implements Saveable, Loadable {
    private static String fileExt;

    private Set<Human> humans;
    private int size;

    static {
        fileExt = ".genTree";
    }

    public GenTree() {
        humans = new HashSet<Human>();
        size = 0;
    }

    public int size() {
        return size;
    }

    public void showAllHumans() {
        if (size < 1) {
            System.out.println("GenTree is empty");
        }
        else {
            for (Human human: humans) {
                human.showFullInfo();
            }
        }
    }

    public ArrayList<Human> findHumansByFullName(String firstName,
                                                 String midName,
                                                 String lastName) {
        String fullName = String.format("%s %s %s", firstName, midName, lastName);
        ArrayList<Human> result = new ArrayList<Human>();
        for (Human human: humans) {
            if (human.getFullName().equals(fullName)) {
                result.add(human);
            }
        }
        return result;
    }

    public Human getHumanById(int id) {
        for (Human human: humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public void addHuman(Human human) {
        humans.add(human);
        size += 1;
    }

    public void addChildToId(Human child, int id) {
        if (size > 0) {
            Human parent = getHumanById(id);
            if (parent != null) {
                parent.addChild(child);
            }
            else {
                
            }
        }
        else {
        }
    }

    public void addParentToId(Human parent, int id) {
        if (size > 0) {
            Human child = getHumanById(id);
            if (child != null) {
                if (parent.getGender() == Gender.man) {
                    child.setFather(parent);
                }
                else {
                    child.setMother(parent);
                }
            }
            else {
            }
        }
        else {
        }
    }

    @Override
    public String getFileExt() {
        return fileExt;
    }
}