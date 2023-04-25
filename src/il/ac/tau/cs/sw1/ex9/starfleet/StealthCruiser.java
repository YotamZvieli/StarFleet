package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class StealthCruiser extends myFighter {
	protected static int instanceOfStealth = 0;
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers,weapons);
		instanceOfStealth += 1;
		int [] WeaponsDetails = this.calcWeapons(weapons);
		this.annualMaintenanceCost = (int) (2500 + Math.floor(1000*maximalSpeed) + WeaponsDetails[0]);

	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		this(name,commissionYear,maximalSpeed,crewMembers, Arrays.asList(new Weapon("Laser Cannons",10,100)));
		Weapon wep = new  Weapon ("Laser Cannons",10,100);

	}
	public String toString(){
		return "StealthCruiser" + "\n" + super.toString();
	}

	public int getAnnualMaintenanceCost(){
		return this.annualMaintenanceCost + 50*StealthCruiser.instanceOfStealth;
	}

}
