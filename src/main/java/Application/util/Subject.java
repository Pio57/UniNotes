package Application.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe utilizzata per implementare il
 * Design Pattern Observer.
 */
public class Subject {
    /**
     * Lista degli Observer.
     */
    private List observers = new ArrayList();

    public List getObservers() {
        return observers;
    }

    /**
     * Metodo per aggiungere un nuovo Observer.
     * @param o il nuovo Observer.
     */
    public void addObserver(Observer o)
    {
        observers.add(o);
    }

    /**
     * Metodo per rimuovere un Observer.
     * @param o l'observer da rimuovere.
     */
    public void removeObserver(Observer o)
    {
        observers.remove(o);
    }

    /**
     * Metodo per avvisare tutti gli Observer.
     */
    public void notifyObservers()
    {
        Observer o;
        Iterator i = observers.iterator();
        while(i.hasNext())
        {
            o = (Observer) i.next();
            o.update();
        }
    }
}
