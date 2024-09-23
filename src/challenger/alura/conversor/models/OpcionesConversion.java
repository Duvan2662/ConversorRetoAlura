package challenger.alura.conversor.models;

public class OpcionesConversion {
    private String convertirDe;
    private String convertirA;

    public OpcionesConversion(String codeA, String codeDe) {
        this.convertirDe = codeDe;
        this.convertirA = codeA;
    }

    public String getConvertirDe() {
        return convertirDe;
    }

    public String getConvertirA() {
        return convertirA;
    }
}
