public class TemperatureConverter {
    public static final String INVALID_TEMPERATURE = "Temperature invalido" ;
    public static final float KELVIN_CONSTANT = 273.15F;
    private static final String INVALID_CONVERSION_TYPE = "Invalid conversion type";

    public enum ConversionType{
        CELSIUS_TO_KELVIN,
        KELVIN_TO_CELSIUS,
    }
    public float convert(float temperature, ConversionType conversionType) {
        if (conversionType == null)
            throw new IllegalArgumentException(INVALID_CONVERSION_TYPE);
        if (conversionType == ConversionType.KELVIN_TO_CELSIUS) {
            if ( temperature < 0 )
                throw new IllegalArgumentException(INVALID_TEMPERATURE);
            return  temperature - KELVIN_CONSTANT;
        }
        else if (conversionType == ConversionType.CELSIUS_TO_KELVIN) {
            if ( temperature < -KELVIN_CONSTANT )
                throw new IllegalArgumentException(INVALID_TEMPERATURE);
            return  temperature + KELVIN_CONSTANT;
        }
        return  temperature;
    }
}
