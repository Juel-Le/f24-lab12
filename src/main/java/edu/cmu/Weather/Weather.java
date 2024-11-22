package edu.cmu.Weather;

public class Weather {
    private WeatherService weatherService;
    private Scale scale;

    public enum Scale {
        INCHES, MILLIMETERS
    }

    /**
     * Sets the length scale for rainfall.
     *
     * @param inches if true, sets the scale to inches; if false, sets the scale to millimeters.
     */
    public void setLengthScale(Scale scale) {
        this.scale = scale;
    }

    /**
     * Retrieves the rainfall measurement over the last 24 hours from the weather service in the preferred scale.
     * 
     * @return the rainfall amount. If the measurement is in inches, it returns the value as is.
     *         If the measurement is not in inches, it converts the value to millimeters.
     */
    public double getRainfall() {
        double wsRainfall = weatherService.getRainfall();
        if (scale == Scale.MILLIMETERS) {
            wsRainfall *= 25.4;
        }
        return wsRainfall;
    }
}
