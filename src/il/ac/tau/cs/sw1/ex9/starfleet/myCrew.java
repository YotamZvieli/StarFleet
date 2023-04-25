package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Objects;

public abstract class myCrew implements CrewMember {
    final String name;
    int age;
    int yearsInService;
    public myCrew(int age, int yearsInService, String name){
        this.age = age;
        this.yearsInService = yearsInService;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        myCrew myCrew = (myCrew) o;
        return name.equals(myCrew.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public int getYearsInService() {
        return yearsInService;
    }

    @Override
    public String getName() {
        return name;
    }
}
