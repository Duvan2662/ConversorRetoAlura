package challenger.alura.conversor.main;


import challenger.alura.conversor.models.Mensaje;
import challenger.alura.conversor.models.ServicesConversion;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        var mensajes = new Mensaje();
        int opc;
        double valorAConverir;
        ServicesConversion conexion = new ServicesConversion();


        while(true){
            System.out.println(mensajes.getMenu());
            opc = teclado.nextInt();
            if (opc > 7 || opc<0) {
                System.out.println("Opción no válida");
            } else if (opc != 7) {
                System.out.println(mensajes.getValorAConverir());
                valorAConverir = teclado.nextDouble();
                conexion.convertir(valorAConverir,opc);
                conexion.resultadoConversion();
                System.out.println(mensajes.mensajeConversion(opc,valorAConverir,conexion.getResultado(),conexion.getArregloMenu()));
            } else {
                break;
            }
        }


    }
}