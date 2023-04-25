package il.ac.tau.cs.sw1.ex9.starfleet;

import java.util.List;
import java.util.Set;

public interface Spaceship {
    String getName();
    int getCommissionYear();
    float getMaximalSpeed();
    int getFirePower();
    Set<? extends CrewMember> getCrewMembers();
    int getAnnualMaintenanceCost();
    default int[] calcWeapons(List<Weapon> weapons){
        int firePower = 0;
        int calc = 0;
        for(int i = 0; i < weapons.size(); i++){
            firePower += weapons.get(i).getFirePower();
            calc += weapons.get(i).getAnnualMaintenanceCost();
        }
        int[] toReturn = new int[2];
        toReturn[0] = calc;
        toReturn[1] = firePower;
        return toReturn;

    }

}
