package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper  extends myFighter{

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers, List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed, crewMembers, weapons);
		int [] WeaponsDetails = this.calcWeapons(weapons);
		this.annualMaintenanceCost = 4000 + 500*this.CrewMembers.size() + (int) (Math.floor((this.maximalSpeed*500)) + WeaponsDetails[0]);

	}
	public String toString(){
		return "ColonialViper" + "\n" + super.toString();
	}
}
