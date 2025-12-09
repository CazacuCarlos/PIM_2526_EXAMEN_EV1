import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TemperatureConverterTest {
private final TemperatureConverter converter = new TemperatureConverter();


    @Test
    public void testKelvinToCelsius() {
        assertEquals(-273.15F, converter.convert(0,
        TemperatureConverter.ConversionType.KELVIN_TO_CELSIUS), 0.01F);
        assertEquals(0, converter.convert(273.15F,
        TemperatureConverter.ConversionType.KELVIN_TO_CELSIUS), 0.01F);
        assertEquals(100, converter.convert(373.15F,
        TemperatureConverter.ConversionType.KELVIN_TO_CELSIUS), 0.01F);
    }



    @Test
    public void testCelsiusToKelvin() {
        assertEquals(0, converter.convert(-273.15F,
        TemperatureConverter.ConversionType.CELSIUS_TO_KELVIN), 0.01F);
        assertEquals(273.15F, converter.convert(0,
        TemperatureConverter.ConversionType.CELSIUS_TO_KELVIN), 0.01F);
        assertEquals(373.15F, converter.convert(100,
        TemperatureConverter.ConversionType.CELSIUS_TO_KELVIN), 0.01F);
    }



    @Test
    public void testInvalidKelvinTemperature() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        converter.convert(-1, TemperatureConverter.ConversionType.KELVIN_TO_CELSIUS);
        });
        assertEquals(TemperatureConverter.INVALID_TEMPERATURE, exception.getMessage());
    }




    @Test
    public void testInvalidCelsiusTemperature() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        converter.convert(-274, TemperatureConverter.ConversionType.CELSIUS_TO_KELVIN);
        });
        assertEquals(TemperatureConverter.INVALID_TEMPERATURE, exception.getMessage());
    }




    @Test
    public void testInvalidConversionType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
        converter.convert(100, null);
        });
        assertEquals(TemperatureConverter.INVALID_CONVERSION_TYPE, exception.getMessage());
    }
}
