package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends myFighter{

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers, List<Weapon> weapons) {
		super(name,commissionYear,maximalSpeed,crewMembers,weapons);
		int[] calcWeapons = calcWeapons(weapons);
		this.annualMaintenanceCost = 3500 + calcWeapons[0] + 500*this.CrewMembers.size() + (int) Math.floor(1200*maximalSpeed);
	}
	public String toString(){
		return "CylonRaider" + "\n" + super.toString();
	}

	

}
