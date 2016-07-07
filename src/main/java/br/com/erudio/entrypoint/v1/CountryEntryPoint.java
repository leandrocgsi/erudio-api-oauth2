package br.com.erudio.entrypoint.v1;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import br.com.erudio.model.Country;
import br.com.erudio.repository.interfaces.ICountryRepository;
import br.com.erudio.vo.CountryVO;

@Controller
@Secured("ROLE_USER")
@Api(value = "city", description = "Exposes endpoints of service City.")
@RequestMapping("/api/v1/country")
public class CountryEntryPoint {

	@Autowired
    private ICountryRepository countryRepository;
    
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find a country by id")
	public @ResponseBody CountryVO findById(@PathVariable Integer id) {
		Country country = countryRepository.findById(id);
		CountryVO countryVO = parseCountry(country);
		addHATEOASSupport(countryVO);
		return countryVO;
	}
	
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find a country by name")
    public @ResponseBody CountryVO findCountryVOByName(@PathVariable String name) {
        Country country = countryRepository.findByName(name);
		CountryVO countryVO = parseCountry(country);
		addHATEOASSupport(countryVO);
		return countryVO;
    }
	
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find a country by name")
    public @ResponseBody List<CountryVO> findByStateName(@PathVariable String stateName) {
		List<Country> countries = countryRepository.findByStateName(stateName);
		List<CountryVO> citiesVO = parseCountries(countries);
		for (CountryVO countryVO : citiesVO) addHATEOASSupport(countryVO);
		return citiesVO;
    }
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find all cities")
    public @ResponseBody List<CountryVO> findAll() {
        List<Country> allCountries = countryRepository.findAll();
		List<CountryVO> citiesVO = parseCountries(allCountries);
		for (CountryVO countryVO : citiesVO) addHATEOASSupport(countryVO);
		return citiesVO;
    }

	private List<CountryVO> parseCountries(List<Country> allCountries) {
		ArrayList<CountryVO> countries = new ArrayList<>();
		for (Country country : allCountries) {
			CountryVO countryVO = parseCountry(country);
			countries.add(countryVO);
		}
		return countries;
	}

	private CountryVO parseCountry(Country country) {
		CountryVO countryVO = new CountryVO();
		countryVO.setIdCountry(country.getIdCountry());
		countryVO.setLocaleMessageKey(country.getLocaleMessageKey());
		countryVO.setName(country.getName());
		
		String[] states = country.getStates().split("\\|");
		
		countryVO.setStates(Arrays.asList(states));
		return countryVO;
	}

		/*@Test
		public void test(){
			String[] ary = "Andorra la Vella|Bengo|Benguela|Bie|Cabinda|Canillo|Cuando Cubango|Cuanza Norte|Cuanza Sul|Cunene|Encamp|Escaldes-Engordany|Huambo|Huila|La Massana|Luanda|Lunda Norte|Lunda Sul|Malanje|Moxico|Namibe|Ordino|Sant Julia de Loria|Uige|Zaire".split("\\|");
			for (String string : ary) {
				System.out.println(string);
			}
			List<String> myList = new ArrayList<String>(Arrays.asList(ary));
		}*/
	private void addHATEOASSupport(CountryVO countryVO) {
		countryVO.add(linkTo(methodOn(CountryEntryPoint.class).findById(countryVO.getIdCountry())).withSelfRel());
	}
}