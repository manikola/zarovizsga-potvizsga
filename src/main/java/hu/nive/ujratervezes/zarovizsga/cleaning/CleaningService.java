package hu.nive.ujratervezes.zarovizsga.cleaning;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();

    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable cleanable){
        cleanables.add(cleanable);
    }

    public int cleanAll() {
        int sum = 0;
        for (Iterator<Cleanable> iterator = cleanables.iterator(); iterator.hasNext();) {
            sum += iterator.next().clean();
            iterator.remove();
        }
        return sum;

        }

    public int cleanOnlyOffices(){
        int sum = 0;
        for (Iterator<Cleanable> iterator = cleanables.iterator(); iterator.hasNext();) {
            Cleanable nextCleanable = iterator.next();
            if (nextCleanable instanceof Office) {
                sum += nextCleanable.clean();
                iterator.remove();
            }
        }
        return sum;
    }

    public List<Cleanable> findByAddressPart(String address){
        List<Cleanable> results = new ArrayList<>();
        for(Cleanable item :cleanables){
            if(item.getAddress().contains(address)){
                results.add(item);
            }
        }
        return results;
    }
    public String getAddresses(){
        StringBuilder sb = new StringBuilder();
        for(Cleanable item :cleanables){
            sb.append(item.getAddress());
            sb.append(", ");
        }sb.delete(sb.length()-2, sb.length());
        return sb.toString();
    }


}
