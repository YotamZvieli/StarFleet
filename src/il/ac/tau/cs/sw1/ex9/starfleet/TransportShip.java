package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.Set;

public class TransportShip extends mySpaceShip{

	int cargo;
	int passengers;
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		super(name,commissionYear,maximalSpeed,crewMembers);
		this.cargo = cargoCapacity;
		this.passengers = passengerCapacity;
		this.annualMaintenanceCost = 3000 + 5*cargo + 3*passengers;
	}
	public String toString(){
		return "TransportShip" + "\n" + super.toString() + "\t"+ "AnnualMaintenanceCost=" +this.annualMaintenanceCost +"\n\t"+ "CargoCapacity=" + this.cargo +"\n\t"+ "PassengerCapacity=" + this.passengers;
	}
	int getCargoCapacity(){
		return this.cargo;
	}
	int getPassengerCapacity(){
		return this.passengers;
	}

}
