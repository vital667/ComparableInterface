import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class People implements Comparable<People> {

    private char sex;
    private String name;
    private String surName;
    private int age;

    public People(char sex, String name, String surName, int age) {
        this.sex = sex;
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    @Override
    public String toString() {
        return name + " " + surName + " "+age+" (" + sex + ")";
    }

    @Override
    public int compareTo(People o) {
        int check = surName.compareTo(o.surName);
        if (check == 0) return name.compareTo(o.name);
        return check;
    }


    public static void main(String[] args) {
        List<People> people = new ArrayList<>();
        people.add(new People('K', "Asia", "Kowalska",25));
        people.add(new People('M', "Marcin", "Kot",22));
        people.add(new People('M', "Sławek", "Abacki",19));
        people.add(new People('K', "Kasia", "Borowik",40));
        people.add(new People('K', "Dorota", "Borowik",18));
        people.add(new People('M', "Tomek", "Daszek",34));
        people.add(new People('M', "Ania", "Daszek",29));

        System.out.println("Unsorted:");
        for (People i : people)
            System.out.println(i);

        Collections.sort(people);
        System.out.println();

        System.out.println("Sorted:");
        for (People i : people)
            System.out.println(i);

        Collections.sort(people,comparatorByAge());
        System.out.println();

        System.out.println("Sorted by Comparator by age:");
        for (People i : people)
            System.out.println(i);
    }


    static Comparator<People> comparatorByAge(){
        return new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                if (o1.age==o2.age) return 0;
                return (o1.age> o2.age)?1:-1;
            }
        };
    }
}



