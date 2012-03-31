package eu.choreos;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import eu.choreos.model.WeatherResult;

@WebService
public class GlobalWeatherWS {
	
	@WebMethod
	public WeatherResult getWeather(@WebParam(name="countryName") String country, @WebParam(name="cityName") String city ){
		WeatherResult result = new WeatherResult();
		
		result.setDate("Mar 30, 2012");
		result.setTime("03:00 PM");
		result.setLocation("Sao Paulo/Congonhas Airport, Brazil");
		result.setTemperature("21C");
		result.setRelativeHumidity("77%");
		
		return result;
	}

}
