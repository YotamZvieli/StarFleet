package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public abstract class mySpaceShip implements Spaceship,Comparable<Spaceship>{
    final String name;
    final int CommissionYear;
    int FirePower;
    Set<? extends CrewMember> CrewMembers;
    float maximalSpeed;
    int annualMaintenanceCost;
    public mySpaceShip (String name,int CommissionYear,float maximalSpeed, Set<? extends CrewMember> crewMembers){
        this.name = name;
        this.maximalSpeed = maximalSpeed;
        this.CrewMembers = crewMembers;
        this.CommissionYear = CommissionYear;
        this.FirePower = 10;
    }
    public String toString(){
        String s ="\tName=" + this.name + "\n" +
                "\tCommissionYear=" + this.CommissionYear +"\n" +
                "\tMaximalSpeed=" + this.maximalSpeed +"\n" +
                "\tFirePower=" + this.FirePower +"\n" +
                "\tCrewMembers=" + this.CrewMembers.size() +"\n";
        return s;

    }

    @Override
    public int compareTo(Spaceship o) {
        if(this.getFirePower() > o.getFirePower()){
            return -1;
        }
        else {
            if(this.getFirePower() < o.getFirePower()){
                return 1;
            }
            else {
                if(this.getCommissionYear() > o.getCommissionYear()){
                    return -1;
                }
                else {
                    if(this.getCommissionYear() < o.getCommissionYear()){
                        return 1;
                    }
                    else {
                        return this.getName().compareTo(o.getName());
                    }
                }
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        mySpaceShip that = (mySpaceShip) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getMaximalSpeed() {
        return maximalSpeed;
    }

    @Override
    public int getAnnualMaintenanceCost() {
        return annualMaintenanceCost;
    }

    @Override
    public int getCommissionYear() {
        return CommissionYear;
    }

    @Override
    public int getFirePower() {
        return FirePower;
    }

    @Override
    public Set<? extends CrewMember> getCrewMembers() {
        return CrewMembers;
    }
}
