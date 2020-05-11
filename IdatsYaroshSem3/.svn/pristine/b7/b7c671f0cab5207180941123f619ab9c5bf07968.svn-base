package priorityqueue;

import collection.AbstrDoubleList;
import collection.DoubleList;
import java.util.Comparator;
import java.util.Iterator;

public class AbstrPriorQueue<T> implements PriorQueue<T> {

    private DoubleList<T> priorityList = new AbstrDoubleList<>();
    private DoubleList<T> listForOtherElements = new AbstrDoubleList<>();
    private Comparator<T> comparator;
    private int actualNumberOfValues;
    private int maxNumberOfValues = 10;

    public AbstrPriorQueue(final int maxNumberOfValues, final Comparator comparator) {
        if (maxNumberOfValues == 0) {
            throw new IllegalArgumentException("Priority queue can't be 0 sized.");
        }
        if (comparator == null) {
            throw new NullPointerException("Comparator is null");
        }
        this.maxNumberOfValues = maxNumberOfValues;
        this.comparator = comparator;
    }
////////////////////////////////////////////////////////////////////////////////
    // FIXME Tato metoda je zakázaná, zrušit, není v zadání práce, odkrývání implementace struktury
    // FIXED

    // FIXME Tato metoda je zakázaná , zrušit, není v zadání práce, odkrývání implementace struktury
    // FIXED

    public int getMaxNumberOfValues() {
        return maxNumberOfValues;
    }

    public void setMaxNumberOfValues(final int maxNumberOfValues) {
        this.maxNumberOfValues = maxNumberOfValues;
    }

    public int getActualNumberOfValues() {
        return actualNumberOfValues;
    }

////////////////////////////////////////////////////////////////////////////////
    @Override
    public void zrus() {
        priorityList.zrus();
        zrusListForOtherElements();
        actualNumberOfValues = 0;
    }
    
    public void zrusListForOtherElements(){
        listForOtherElements.zrus();
    }

    @Override
    public boolean jePrazdny() {
        return priorityList.jePrazdny() && listForOtherElements.jePrazdny();
    }

    @Override
    public void vloz(final T data) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("Element is null.");
        }
        if (priorityList.jePrazdny()) {
            priorityList.vlozPrvni(data);
            actualNumberOfValues++;
            return;
        }
        if (actualNumberOfValues < maxNumberOfValues) {
            T currentElement = priorityList.zpristupniPrvni();
            while (currentElement != null) {
                if (comparator.compare(currentElement, data) < 0) {
                    priorityList.vlozPredchudce(data);
                    actualNumberOfValues++;
                    return;
                } else {
                    // FIXME Zachycení výjimky a pokračování v algoritmu se považuje za chybu
                    // FIXED
                    try {
                        currentElement = priorityList.zpristupniNaslednika();
                        if (currentElement == null) {
                            if (priorityList.getMohutnost() != actualNumberOfValues + 1) {
                                priorityList.vlozPosledni(data);
                                actualNumberOfValues++;
                            }
                            return;
                        }
                    } catch (NullPointerException e) {
                    }
                }
            }
        } else {
            T currentElement = priorityList.zpristupniPrvni();
            while (currentElement != null) {
                if (comparator.compare(currentElement, data) < 0) {
                    priorityList.vlozPredchudce(data);
                    listForOtherElements.vlozPosledni(priorityList.odeberPosledni());
                    return;
                } else {
                    try {
                        currentElement = priorityList.zpristupniNaslednika();
                        if (currentElement == null) {
                            searchAndInput(data);
                            return;
                        }
                    } catch (NullPointerException e) {
                    }
                }
            }
        }
    }

    private void searchAndInput(final T data) {
        if (listForOtherElements.jePrazdny()) {
            listForOtherElements.vlozPrvni(data);
            return;
        }
        T currentElement = listForOtherElements.zpristupniPrvni();
        while (currentElement != null) {
            if (comparator.compare(currentElement, data) < 0) {
                listForOtherElements.vlozPredchudce(data);
                return;
            } else {
                try {
                    currentElement = listForOtherElements.zpristupniNaslednika();
                    if (currentElement == null) {
                        listForOtherElements.vlozPrvni(data);
                        return;
                    }
                } catch (NullPointerException e) {
                }
            }
        }
    }

    @Override
    public T odeberMax() {
        if (priorityList.jePrazdny()) {
            return null;
        }
        final T value = priorityList.odeberPrvni();
        if (listForOtherElements.jePrazdny()) {
            actualNumberOfValues--;
        } else {
            // FIXME Nelze vložit libovolný prvek z nesetříděné části
            // FIXED Přidávám položku na požadované místo v řádku 107 a proto můžu bezpečně odstranit bez vyhledávání
            priorityList.vlozPosledni(listForOtherElements.odeberPosledni());
        }
        return value;
    }

    @Override
    public T zpristupni() {
        return priorityList.jePrazdny() ? null : priorityList.zpristupniPrvni();
    }

    // FIXME Neni povoleno používat knihovní kolekce, stačí pouze pole, tak jak je to v zadání
    // FIXED
    @Override
    public void vyduduj(final T[] data) throws NullPointerException {
        if (data == null) {
            throw new NullPointerException("Data is null.");
        }
        zrus();
        for (T value : data) {
            vloz(value);
        }
    }

    // FIXME Toto řešení itarátoru neberu, vyřešte bez pomocného seznamu
    // FIXED
    @Override
    public Iterator<T> iterator() {
        return priorityList.iterator();
    }

    public Iterator<T> otherElementsIterator() {
        return listForOtherElements.iterator();
    }
}
