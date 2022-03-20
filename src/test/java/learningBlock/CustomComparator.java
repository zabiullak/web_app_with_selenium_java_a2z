package learningBlock;

import java.util.Comparator;

public class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {

        int value = o1.compareTo(o2);

        if(value>0){
            return -1;
        }
        else if(value<0){
            return 1;
        }
        else{
            return 0;
        }
    }
}
