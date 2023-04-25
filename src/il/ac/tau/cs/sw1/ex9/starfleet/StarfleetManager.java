package il.ac.tau.cs.sw1.ex9.starfleet;


import java.util.*;


public class StarfleetManager {

	/**
	 * Returns a list containing string representation of all fleet ships, sorted in descending order by
	 * fire power, and then in descending order by commission year, and finally in ascending order by
	 * name
	 */
	public static List<String> getShipDescriptionsSortedByFirePowerAndCommissionYear (Collection<Spaceship> fleet) {
		List<mySpaceShip> sortedLst = new ArrayList<>();
		for(Iterator<Spaceship> iter = fleet.iterator(); iter.hasNext();){
			sortedLst.add((mySpaceShip) iter.next());
		}
		Collections.sort(sortedLst);
		List<String> listOfRep = new ArrayList<>();
		for (int i = 0; i < sortedLst.size(); i++){
			listOfRep.add(sortedLst.get(i).toString());
		}
		return listOfRep;
	}

	/**
	 * Returns a map containing ship type names as keys (the class name) and the number of instances created for each type as values
	 */
	public static Map<String, Integer> getInstanceNumberPerClass(Collection<Spaceship> fleet) {
		Map<String,Integer> instanceSum = new HashMap<>();
		String name;
		for(Iterator<Spaceship> iter = fleet.iterator(); iter.hasNext();){
			name = iter.next().getClass().getSimpleName();
			if(instanceSum.containsKey(name)){
				instanceSum.put(name,instanceSum.get(name) + 1);
			}
			else {
				instanceSum.put(name,1);
			}
		}
		return instanceSum;

	}


	/**
	 * Returns the total annual maintenance cost of the fleet (which is the sum of maintenance costs of all the fleet's ships)
	 */
	public static int getTotalMaintenanceCost (Collection<Spaceship> fleet) {
		int totalCost = 0;
		for(Iterator<Spaceship> iter = fleet.iterator(); iter.hasNext();){
			Spaceship curr = iter.next();
			if(curr instanceof StealthCruiser cruiser){
				totalCost += cruiser.getAnnualMaintenanceCost();
			}
			else {
				totalCost += curr.getAnnualMaintenanceCost();
			}
		}
		return totalCost;
	}


	/**
	 * Returns a set containing the names of all the fleet's weapons installed on any ship
	 */
	public static Set<String> getFleetWeaponNames(Collection<Spaceship> fleet) {
		Set<String> WepSet = new HashSet<>();
		List<Weapon> lst;
		for(Iterator<Spaceship> iter = fleet.iterator(); iter.hasNext();){
			Spaceship curr = iter.next();
			if(curr instanceof myFighter){
				lst = ((myFighter) curr).getWeapons();
				for(int i = 0; i < lst.size();i++){
					WepSet.add(lst.get(i).getName());
				}
			}
			if(curr instanceof Bomber){
				lst = ((Bomber) curr).getWeapon();
				for(int i = 0; i < lst.size();i++){
					WepSet.add(lst.get(i).getName());
				}
			}
		}
		return WepSet;

	}

	/*
	 * Returns the total number of crew-members serving on board of the given fleet's ships.
	 */
	public static int getTotalNumberOfFleetCrewMembers(Collection<Spaceship> fleet) {
		int totalCrew = 0;
		for(Iterator<Spaceship> iter = fleet.iterator(); iter.hasNext();){
			totalCrew += iter.next().getCrewMembers().size();
		}
		return totalCrew;
	}

	/*
	 * Returns the average age of all officers serving on board of the given fleet's ships. 
	 */
	public static float getAverageAgeOfFleetOfficers(Collection<Spaceship> fleet) {
		Set<? extends CrewMember> crew;
		float avg = 0;
		int cnt = 0;
		for(Iterator<Spaceship> iter = fleet.iterator(); iter.hasNext();){
			crew = iter.next().getCrewMembers();
			for(Iterator<? extends CrewMember> crewIter = crew.iterator();crewIter.hasNext();){
				if(crewIter.next() instanceof Officer officer){
					avg += officer.age;
					cnt += 1;
				}
			}
		}
		return avg/cnt;
	}

	/*
	 * Returns a map mapping the highest ranking officer on each ship (as keys), to his ship (as values).
	 */
	public static Map<Officer, Spaceship> getHighestRankingOfficerPerShip(Collection<Spaceship> fleet) {
		Map<Officer,Spaceship> map = new HashMap<>();
		List<Officer> tmp;
		Spaceship current;
		for(Iterator<Spaceship> iter = fleet.iterator(); iter.hasNext();){
			current = iter.next();
			tmp = new ArrayList<>();
			Set<? extends CrewMember> crewMem = current.getCrewMembers();
			for(Iterator<? extends CrewMember> crewMapIter = crewMem.iterator();crewMapIter.hasNext();){
				if(crewMapIter.next() instanceof Officer o){
					tmp.add(o);
				}
			}
			tmp.sort(new myOfficerComparator());
			if(tmp.size() != 0) {
				map.put(tmp.get(tmp.size() - 1), current);
			}
		}
		return map;
	}

	/*
	 * Returns a List of entries representing ranks and their occurrences.
	 * Each entry represents a pair composed of an officer rank, and the number of its occurrences among starfleet personnel.
	 * The returned list is sorted ascendingly based on the number of occurrences.
	 */
	public static List<Map.Entry<OfficerRank, Integer>> getOfficerRanksSortedByPopularity(Collection<Spaceship> fleet) {
		Map<OfficerRank,Integer> rankMap = new HashMap<>();
		Spaceship current;
		for(Iterator<Spaceship> iter = fleet.iterator(); iter.hasNext();){
			current = iter.next();
			Set<? extends CrewMember> crewMem = current.getCrewMembers();
			for(Iterator<? extends CrewMember> crewMapIter = crewMem.iterator();crewMapIter.hasNext();){
				if(crewMapIter.next() instanceof Officer o){
					if(rankMap.containsKey(o.rank)){
						rankMap.put(o.rank,rankMap.get(o.rank) + 1);
					}
					else {
						rankMap.put(o.rank,1);
					}
				}
			}
		}
		List<Map.Entry<OfficerRank,Integer>> lst = rankMap.entrySet().stream().toList();
		List<Map.Entry<OfficerRank, Integer>> mutableOne = new ArrayList<>(lst);
		mutableOne.sort(new myMapEntryRankComparator());
		return mutableOne;
	}

}
