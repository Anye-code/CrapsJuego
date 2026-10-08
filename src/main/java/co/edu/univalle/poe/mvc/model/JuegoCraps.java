package co.edu.univalle.poe.mvc.model;

public class JuegoCraps {
    //Atributos (declarar el objeto):
    private Dado dado1;           //de tipo dado
    private Dado dado2;
    private EstadoPartida estadoPartida;
    private int punto;           //variable tipo int llamada punto

    //metodo constructor(crear el objeto):
    public JuegoCraps() {
        dado1 = new Dado();    //un objeto existe siempre y cuando yo invoque a su constructor (new dado() es aqui) new=llamar a un constructor
        dado2 = new Dado();

        iniciarPartida();
    }

    public void iniciarPartida() {   //ejecuta instrucciones, es procedimental void=no hay retorno
        punto = 0;    //punto no existe
        estadoPartida = EstadoPartida.EN_CURSO;
    }

    public Lanzamiento lanzarDados() {     //devuelve un objeto tipo lanzamiento
        int valorDado1 = dado1.lanzar();     //coje cada dado y lo lanza, se pone int porque la clase lanzamiento necesita conocer los dos valores de entrada
        int valorDado2 = dado2.lanzar();

        Lanzamiento lanzamiento = new Lanzamiento(valorDado1, valorDado2);    //simular el lanzamiento
        aplicarReglas(lanzamiento.calcularSuma());     //metodo aplicarReglas (debo saber la suma) -> objeto lanzamiento -> metodo calcularSuma
        return lanzamiento;     //retorna un objeto de tipo lanzamiento
    }

    private void aplicarReglas(int suma){
        if(!hayPuntoEstablecido()){      //validacion o si algo se cumple o no. hayPuntoEstablecido()==false
            evaluarPrimerLanzamiento(suma);   //metodo que se encarga de evaluar y se le entrega la suma
        }else{
            evaluarLanzamientoPosterior(suma);
        }
    }

    private void evaluarPrimerLanzamiento(int suma){
        if(suma == 7 || suma == 11) {
            estadoPartida = EstadoPartida.GANADA;
        }else{
            if(suma == 2 || suma == 3 || suma == 12) {
                estadoPartida = EstadoPartida.PERDIDA;
            }else{
                punto = suma;   //estableci punto y que sea igual a suma, punto!=0 y punto=suma
            }
        }
    }

    private void evaluarLanzamientoPosterior(int suma){   //tiene parametro de entrada que es la suma, ya que necesita saber cuanto sumo
        if(suma == punto){
            estadoPartida = EstadoPartida.GANADA;
        }else{
            if(suma == 7){
                estadoPartida = EstadoPartida.PERDIDA;
            }
        }
    }

    public boolean hayPuntoEstablecido(){   //retorna un boleano=si o no
        return punto != 0;   //retorna el resultado de si punto es diferente de 0=Ture. Si es igual a 0 devuelve False
    }

    public boolean puedeLanzar(){
        return estadoPartida == EstadoPartida.EN_CURSO;    //si esta en curso => puede seguir haciendo lanzamientos
        //si lo que esta en estado partida es en curso, devuelve true =>puede lanzar
    }

    public boolean partidaTerminada(){
        return estadoPartida == EstadoPartida.GANADA || estadoPartida == EstadoPartida.PERDIDA;   //ya sea que haya ganado o perdido, cualquiera es indicador de que la partida ya esta terminada
    }

    public EstadoPartida getEstadoPartida() {
        return estadoPartida;
    }

    public int getPunto() {
        return punto;
    }
}
