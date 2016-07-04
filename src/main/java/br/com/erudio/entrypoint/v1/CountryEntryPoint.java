package br.com.erudio.entrypoint.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
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
    
	/*@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "POST", value = "Saving a country")
	public @ResponseBody CountryVO save(@RequestBody CountryVO country) {
		country.setInsertDate(new Date());
		country.setIdUserInsert(0);
		country.setActive(true);
		Country savedCountry = countryRepository.save(ObjectParser.parseObjectInputToObjectOutput(country, Country.class));
		CountryVO countryVO = ObjectParser.parseObjectInputToObjectOutput(savedCountry, CountryVO.class);
		addHATEOASSupport(countryVO);
		return countryVO;
	}

	@RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "PUT", value = "Updating a country")
	public @ResponseBody CountryVO update(@RequestBody CountryVO country) {
		country.setUpdatedDate(new Date());
		country.setIdUserUpdate(0);
		Country updatedCountry = countryRepository.update(ObjectParser.parseObjectInputToObjectOutput(country, Country.class));
		CountryVO countryVO = ObjectParser.parseObjectInputToObjectOutput(updatedCountry, CountryVO.class);
		addHATEOASSupport(countryVO);
		return cityVO;
	}
    
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "DELETE", value = "Deleting a country by id")
    public @ResponseBody ResponseEntity<Void> delete(@PathVariable Integer id) {
		countryReposiountryy.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find a country by id")
	public @ResponseBody CountryVO findById(@PathVariable Integer id) {
		Country country = countryRepository.findById(id);
		CountryVO countryVO = ObjectParser.parseObjectInputToObjectOutput(country, CountryVO.class);
		addHATEOASSupport(countryVO);
		return countryVO;
	}
	
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find a country by name")
    public @ResponseBody CountryVO findCountryVOByName(@PathVariable String name) {
        Country country = countryRepository.findByName(name);
		CountryVO countryVO = ObjectParser.parseObjectInputToObjectOutput(country, CountryVO.class);
		addHATEOASSupport(countryVO);
		return countryVO;
    }*/
    
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find all cities")
    public @ResponseBody List<CountryVO> findAll() {
        List<Country> allCountries = countryRepository.findAll();
		List<CountryVO> citiesVO = parseCountries(allCountries);
//		for (CountryVO countryVO : citiesVO) addHATEOASSupport(countryVO);
		return citiesVO;
    }

	private List<CountryVO> parseCountries(List<Country> allCountries) {
		ArrayList<CountryVO> countries = new ArrayList<>();
		for (Country country : allCountries) {
			CountryVO countryVO = new CountryVO();
			countryVO.setIdCountry(country.getIdCountry());
			countryVO.setLocaleMessageKey(country.getLocaleMessageKey());
			countryVO.setName(country.getName());
			countryVO.setStates(country.getStates());
		}
		return countries;
	}

		@Test
		public void test(){
			String[] ary = "Andorra la Vella|Bengo|Benguela|Bie|Cabinda|Canillo|Cuando Cubango|Cuanza Norte|Cuanza Sul|Cunene|Encamp|Escaldes-Engordany|Huambo|Huila|La Massana|Luanda|Lunda Norte|Lunda Sul|Malanje|Moxico|Namibe|Ordino|Sant Julia de Loria|Uige|Zaire".split("\\|");
			for (String string : ary) {
				System.out.println(string);
			}
			List<String> myList = new ArrayList<String>(Arrays.asList(ary));
		}
	/*private void addHATEOASSupport(CountryVO countryVO) {
		countryVO.add(linkTo(methodOn(CountryEntryPoint.class).findById(countryVO.getIdCountry())).withSelfRel());
	}*/
}