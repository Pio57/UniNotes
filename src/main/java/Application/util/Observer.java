package Application.util;

/**
 * Interfaccia utilizzata per implementare il
 * Design Pattern Observer.
 */
public interface Observer
{
     /**
      * Metodo invocato quando c'è una modifica
      * dello stato del Subject.
      */
     void update();
}