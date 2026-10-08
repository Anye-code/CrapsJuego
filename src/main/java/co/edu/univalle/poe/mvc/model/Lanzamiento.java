package co.edu.univalle.poe.mvc.model;

public class Lanzamiento {
    //Atributos:
    private int valorDado1; //guarda el valor del dado1
    private int valorDado2;

    //Metodo constructor: //para asignar en esas dos variables, los dos valores que se asignen
    public Lanzamiento(int valorDado1, int valorDado2){

        //apuntador a la clase: se referencia a atributos o a metodos:
        this.valorDado1 = valorDado1 //a ese atributo de clase se le asigna el parametro de entrada que reciba el metodo que esta manejado con ese identificador valorDado1

    } //metodo constructor (se sabe porque lleva el mismo nombre de la clase - dos parametros de entrada de tipo entero, se puede darle los nombres

    //metodo para calcular la suma
    public int calcularSuma() {
        return valorDado1 + valorDado2; //retorna la suma de ambas caras de los dos dados
    }

    //metodos get para devolver atributos de clase
    //devolver los valores de los dados(que salió en cada cara del dado para actualizar la interfaz)
    public int getValorDado1(){
        return valorDado1;
    }

    public int getValorDado2(){
        return valorDado2;
    }

}

//cuando se genera la clase lanzamiento
//se le da los valores que genera el dado y la clase se encarga de asignarlos a los atributos


//la clase se encarga de guardar los valores generados para cada cara del dado, retornar la suma y devuelve el valor generado en cada caso