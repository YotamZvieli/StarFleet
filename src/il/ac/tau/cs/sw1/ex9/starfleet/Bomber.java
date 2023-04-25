package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends mySpaceShip{
	int numberOfTec;
	List<Weapon> weapons;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name,commissionYear,maximalSpeed ,crewMembers);
		float calc = 0;
		for(int i = 0; i < weapons.size(); i++){
			this.FirePower += weapons.get(i).getFirePower();
			calc += weapons.get(i).getAnnualMaintenanceCost();
		}
		this.numberOfTec = numberOfTechnicians;
		this.weapons = weapons;
		this.annualMaintenanceCost = (int) (5000 + Math.round(calc*(1-0.1*numberOfTechnicians)));

	}
	public String toString(){
		return "Bomber" + "\n" + super.toString() + "\tAnnualMaintenanceCost=" + this.annualMaintenanceCost + "\n\tWeaponArray=" + weapons + "\n\tNumberOfTechnicians=" + numberOfTec;
	}

	int getNumberOfTechnicians(){
		return this.numberOfTec;
	}
	public List<Weapon> getWeapon(){
		return this.weapons;
	}


}
