package challenger.alura.conversor.models;

import java.util.ArrayList;

public class Mensaje {
    String menu;
    String valorAConverir;
    String conversion;

    public String getMenu() {
        return menu;
    }

    public String getValorAConverir() {
        return valorAConverir;
    }

    public Mensaje() {
        this.menu = """
                ************************************************************
                Sea bienvenido al conversor de moneda 
   
                1) Dólar => Peso Colombiano
                2) Dólar => Peso Argentino
                3) Dolar => Real Brasileño
                4) Peso Colombiano => Dólar
                5) Peso Argentino => Dólar
                6) Real Brasileño => Dólar
                7) Salir  
                Elija una opción válida:
                ************************************************************""";
        this.valorAConverir = """
                Ingrese el valor que desea convertir""";
    }

    public String mensajeConversion (int opc, double aConverir, double convertido, ArrayList<OpcionesConversion> arregloMenu){
        opc -= 1;
        OpcionesConversion opcionConversion = arregloMenu.get(opc);
        this.conversion = """
                "El valor %.2f [%s] corresponde al valor final de => %.2f [%s]"
                """.formatted(aConverir,opcionConversion.getConvertirDe(),convertido,opcionConversion.getConvertirA());
        return this.conversion;
    }

}
