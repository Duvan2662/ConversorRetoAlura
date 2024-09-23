package challenger.alura.conversor.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

public class ServicesConversion {
    private String baseUrl;
    private String apiKey;
    private ArrayList<OpcionesConversion> arregloMenu = new ArrayList<>();
    private String responseBody;
    private Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
    private double resultado;



    public ServicesConversion() {
        String estadosUnidos = "USD";
        String[] codes = {"COP","ARS","BRL"};

        this.baseUrl = "https://v6.exchangerate-api.com/v6/";
        this.apiKey = "49298450aeb6b1a5f0382de8";
        for (int i = 0; i <codes.length ; i++) {
            OpcionesConversion opcion = new OpcionesConversion(codes[i],estadosUnidos);
            this.arregloMenu.add(opcion);
            if (i == codes.length-1) {
                for (int j = 0; j < codes.length; j++) {
                    OpcionesConversion opcion2 = new OpcionesConversion(estadosUnidos,codes[j]);
                    this.arregloMenu.add(opcion2);
                }
            }
        }
    }


    public void convertir(double valor, int opc) throws IOException, InterruptedException {
        opc -=1;
        OpcionesConversion opcionConversion = this.arregloMenu.get(opc);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl+apiKey+"/pair/"+opcionConversion.getConvertirDe()+"/"+opcionConversion.getConvertirA()+"/"+valor))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        this.responseBody = response.body();
    }


    public void resultadoConversion () {
        ConversionOmdb myconversionOmdb = this.gson.fromJson(this.responseBody,ConversionOmdb.class);
        var conversion = new Conversion(myconversionOmdb);
        this.resultado =  conversion.getConversionResult();
    }


    public double getResultado() {
        return resultado;
    }

    public ArrayList<OpcionesConversion> getArregloMenu() {
        return arregloMenu;
    }
}
