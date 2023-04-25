package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public abstract class myFighter extends mySpaceShip {
    List<Weapon> Weapons;
    List<Weapon> getWeapons(){
        return Weapons;
    }
    public myFighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
        super(name,commissionYear,maximalSpeed,crewMembers);
        this.Weapons = weapons;
        int [] WeaponsDetails = this.calcWeapons(weapons);
        this.FirePower += WeaponsDetails[1];
    }
    public List<Weapon> getWeapon(){
        return this.Weapons;
    }

    public String toString(){
        return super.toString() + "\tAnnualMaintenanceCost=" + this.getAnnualMaintenanceCost() + "\n\tWeaponArray=" + this.Weapons;

    }

}
