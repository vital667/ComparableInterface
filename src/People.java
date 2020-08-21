import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class People implements Comparable<People> {

    private char sex;
    private String name;
    private String surName;

    public People(char sex, String name, String surName) {
        this.sex = sex;
        this.name = name;
        this.surName = surName;
    }

    @Override
    public String toString() {
        return name + " " + surName + " (" + sex + ")";
    }

    @Override
    public int compareTo(People o) {
        int check = surName.compareTo(o.surName);
        if (check == 0) return name.compareTo(o.name);
        return check;
    }


    public static void main(String[] args) {
        List<People> people = new ArrayList<>();
        people.add(new People('K', "Asia", "Kowalska"));
        people.add(new People('M', "Marcin", "Kot"));
        people.add(new People('M', "Sławek", "Abacki"));
        people.add(new People('K', "Kasia", "Borowik"));
        people.add(new People('K', "Dorota", "Borowik"));
        people.add(new People('M', "Tomek", "Daszek"));
        people.add(new People('M', "Ania", "Daszek"));

        System.out.println("Unsorted:");
        for (People i : people)
            System.out.println(i);

        Collections.sort(people);
        System.out.println();

        System.out.println("Sorted:");
        for (People i : people)
            System.out.println(i);
    }
}



