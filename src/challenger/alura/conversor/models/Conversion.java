package challenger.alura.conversor.models;

public class Conversion {
    private double conversionResult;

    public Conversion(ConversionOmdb myconversionOmdb) {
        this.conversionResult = myconversionOmdb.conversion_result();
    }

    public double getConversionResult() {
        return conversionResult;
    }
}
