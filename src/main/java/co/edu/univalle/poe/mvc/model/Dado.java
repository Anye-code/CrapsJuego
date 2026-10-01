package co.edu.univalle.poe.mvc.model;

import java.util.Random;
/*Clase que representa un dado de 6 caras y genera un numero aleatorio entre 1 y 6 cada vez que se requiera un lanzamiento de los dados */
public class Dado {
    private final int NUMERO_CARAS = 6;        //constante, final=no se modifica, numero_caras=nombre de la constante

    private Random random;

    public Dado(){
        random = new Random();

    }
    public int lanzar(){
        return random.nextInt(NUMERO_CARAS)+1; //ya no sale (bound:6)
    }
}

// practica de programacion, no se dejan num fijos dentro del codigo
// 0 1 2 3 4 5
/* 1 2 3 4 5 6  */