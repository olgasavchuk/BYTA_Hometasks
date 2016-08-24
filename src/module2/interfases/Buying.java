package module2.interfases;

import module2.exceptions.EmptyCostException;

public interface Buying {
    int getCost() throws EmptyCostException;
}
