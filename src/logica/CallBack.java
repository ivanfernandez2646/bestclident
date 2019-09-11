package logica;

public interface CallBack {
    
    //Método genérico de CallBack que no permite paso de parámetros
    default void panelDeLlamada(){};
    
    //Método genérico de CallBack que permite paso de un objeto
    default void panelDeLlamada(Object o){};
    
    default void panelSalvapantallas(){};
}
