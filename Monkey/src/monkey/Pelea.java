/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package monkey;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bielc
 */
public class Pelea {

    // los metodos "repetidos"(mismo funcionamiento para el otro jugador)
    //solo los he explicado una vez ya que son practicamente iguales
    
    boolean jugador = true; //Es un boolean para ver quien juga primero en la ronda
    int guybrush = 0;// son los marcadores de puntos
    int lechuck = 0;
    int eleccion;// y estos son los indices de los arrays de string
    int indice;
    int asaltos = 1;// contador de asaltos

    String[] insultosGuybrush
            = {"¡Eres demasiado bobo para mi nivel de inteligencia! ",
                "¡Tienes los modales de un mendigo!",
                "¡Una vez tuve un perro más listo que tu! ",
                "¡He oído que eres un soplón despreciable!"
            };
    String[] insultosLechuck
            = {"¡Luchas como un granjero!",
                "Eres más feo que una mona marrana.",
                "¿Has dejado ya de usar pañales? ",
                "No hay palabras para describir lo asqueroso que eres! "
            };
    String[] respuestaGuybrush
            = {"Oh que apropiado, tú peleas como una vaca.",
                "¿Es que tanto me parezco a tu hermana?",
                "¿Por qué? ¿Acaso querías pedir uno prestado? ",
                "Si que las hay!Solo que son muy complicadas para ti "
            };
    String[] respuestaLechuck
            = {"Estaría acabado si la usases alguna vez.",
                "Quería asegurarme de que estuvieras a gusto conmigo.",
                "AH si?? Debio enseñarte todo lo que sabes!.",
                "Qué pena me da que nadie haya oído hablar de ti "
            };

    Random rm = new Random(); // inicializamos tanto el random como el scanner
    Scanner sc = new Scanner(System.in);

    public void PeleaDeInsultos() {
        intro(); // Los println de introduccion de la historia

        moneda(); // metodo de "cara o cruz" para ver quien empieza
        while (guybrush < 3 && lechuck < 3) {
            asalto();// metodo que hace un print del asalto en el que se esta y donde se suma 1 a la variable asalto
            if (jugador == true) {
                insultar();// metodo donde el jugador insulta
                respuestaLechuck();//metodo donde se da la respuesta dada por la maquina con el random
                buenaLechuck();//metodo donde se comprueba si ha respondido bien
                

            } else {
                // tenemos los mismos metodos pero orientados al enemigo
                insultaLechuck();
                respuestaGuybrush();
                buenaGuybrush();
                
            }
            cambio(); //metodo donde se cambia el jugador para el siguiente asalto

        }
        muletilla(); // metodo donde se hacen prins de frases de derrota depende del perdedor
    }

    
    public void intro() {
        System.out.println("-------------Monkey Island-------------");
        System.out.println("Tu, el asombroso pirata Guybrush Treepwood "
                + "te encuentras en un bar rodeado de los peores piratas "
                + "Isla Mêlée");
        System.out.println("delante tuya esta tu archienemigo el temido "
                + "pirata zombi Lechuck");
        System.out.println("Y hoy sera el dia en que lo venceras"
                + " a una pelea de insultos");
        System.out.println("El comienzo se decide con una simple moneda");
        System.out.println("Cara?- empiezo yo el asombroso guybrush treepwood");
        System.out.println("Cruz -Empieza el odioso de Luchuck");
        System.out.println("se lanza la moneda y cae en...");
        System.out.println("");

    }
    

    public void moneda() {
        indice = rm.nextInt(2);
        // si el random da 0 jugador true si no, jugador false
        if (indice == 0) {
            jugador = true;
            System.out.println("Locutor:"
                    + " Cara! Empieza Guybruuushh Treeepwoood");
        } else {
            jugador = false;
            System.out.println("Locutor:"
                    + " Cruz! empieza el temidooo Leeeechuuuckk");
        }

    }
    

    public void asalto() {

        System.out.println("---------------------------------------------");
        System.out.println("                 Asalto" + asaltos);
        System.out.println("---------------------------------------------");
        asaltos++;
    }
    

    public void insultaLechuck() {
        //depende del random se usa un insulto de la maquina o otro
        indice = rm.nextInt(4);
        System.out.println("");
        System.out.println("Lechuck: " + insultosLechuck[indice]);
        System.out.println("");

    }
    

    public void cambio() {

        if (jugador == true) {
            jugador = false;
        } else {
            jugador = true;
        }

    }
    

    public void insultar() {
        //mediante un case se elige uno de los insultos del array 
        System.out.println("");
        System.out.println("Mhhmm que insulto le podria decir...");
        System.out.println("-----------Insultos-----------");
        System.out.println("1 - " + insultosGuybrush[0]);
        System.out.println("2 - " + insultosGuybrush[1]);
        System.out.println("3 - " + insultosGuybrush[2]);
        System.out.println("4 - " + insultosGuybrush[3]);
        System.out.println("------------------------------"); 
        eleccion = sc.nextInt();

        switch (eleccion) {
            case 1:
                System.out.println("Guybrush: " + insultosGuybrush[0]);
                break;
            case 2:
                System.out.println("Guybrush: " + insultosGuybrush[1]);
                break;
            case 3:
                System.out.println("Guybrush: " + insultosGuybrush[2]);
                break;
            case 4:
                System.out.println("Guybrush: " + insultosGuybrush[3]);
                break;

        }
        eleccion = eleccion - 1;// como hemos puesto del 1 al 4 necesitamos 
        //poner este -1 para que al comparar coincida con la posicion del array
    }
    

    public void respuestaLechuck() {

        indice = rm.nextInt(4);
        System.out.println("");
        System.out.println("Lechuck: " + respuestaLechuck[indice]);

    }
    

    public void respuestaGuybrush() {

        System.out.println("Mhhmm como le podria responder...");
        System.out.println("-----------Respuestas-----------");
        System.out.println("1 - " + respuestaGuybrush[0]);
        System.out.println("2 - " + respuestaGuybrush[1]);
        System.out.println("3 - " + respuestaGuybrush[2]);
        System.out.println("4 - " + respuestaGuybrush[3]);
        System.out.println("--------------------------------");
        eleccion = sc.nextInt();

        switch (eleccion) {
            case 1:
                System.out.println("Guybrush: " + respuestaGuybrush[0]);
                break;
            case 2:
                System.out.println("Guybrush: " + respuestaGuybrush[1]);
                break;
            case 3:
                System.out.println("Guybrush: " + respuestaGuybrush[2]);
                break;
            case 4:
                System.out.println("Guybrush: " + respuestaGuybrush[3]);
                break;

        }
        eleccion = eleccion - 1;
    }
    

    public void buenaGuybrush() {
        // si los indices de los arrays coinciden se le suma un punto
        //sino se le suma un punto al otro

        if (eleccion == indice) {
            guybrush++;
            System.out.println("");
            System.out.println("Locutor: Guybrush dio en el clavooo"
                    + " esa seguro que dolio");
        } else {
            lechuck++;
            System.out.println("");
            System.out.println("Locutor: Asi pretendes ganar "
                    + "a tu archienemigo? No me hagas reir");
        }

    }
    

    public void buenaLechuck() {

        if (eleccion == indice) {
            lechuck++;
            System.out.println("");
            System.out.println("Locutor: Leeeechuuuuckk se la devuelveeee"
                    + " no le sera nada facil ganar esta pelea a guybrush");
        } else {
            guybrush++;
            System.out.println("");
            System.out.println("Locutor: Parece ser que la fama de Lechuck"
                    + " esta mas subida de la cuenta...");
        }

    }
    

    public void muletilla() {

        // dependiendo del ganador se printean unas frases o las otras
            if (guybrush == 3) {
                System.out.println("Lechuck: Treepwood volvere para acabar "
                        + "contigo y conseguir el tesoro de monkey island!!");
                System.out.println("Guybrush:¿Cómo es que un tipejo como tú ha "
                        + " llegado a ser el pirata más temido del Caribe?");
                System.out.println("Y asi fue como derrote a mi "
                        + "archienemigo el pirata zombi Lechuck y consegui el "
                        + "tesoro de Monkey Island");
                System.out.println("-------------Victoria-------------");
            } else {
                System.out.println("Guybrush: Mira, un mono de tres cabezas");
                System.out.println(".");
                System.out.println(".");
                System.out.println(".");
                System.out.println("Lechuck: No colara esta vez Treepwood");
                System.out.println("-------------Derrota-------------");
            }
        

    }
}
