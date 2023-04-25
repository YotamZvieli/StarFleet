package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myFighter{
	
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers,weapons);
		int [] WeaponsDetails = this.calcWeapons(weapons);
		this.annualMaintenanceCost = (int) (2500 + Math.floor(1000*maximalSpeed) + WeaponsDetails[0]);
	}

	public String toString(){
		return "Fighter" + "\n" + super.toString();
	}
}
