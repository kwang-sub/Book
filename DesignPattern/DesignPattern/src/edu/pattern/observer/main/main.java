package edu.pattern.observer.main;

import edu.pattern.observer.display.CurrentConditionsDisplay;
import edu.pattern.observer.display.StatisticsDisplay;
import edu.pattern.observer.subject.WeatherData;

public class main {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(22.5f, 10f, 14f);
        weatherData.setMeasurements(25.5f, 10f, 14f);
        weatherData.setMeasurements(23.5f, 10f, 14f);
    }
}
