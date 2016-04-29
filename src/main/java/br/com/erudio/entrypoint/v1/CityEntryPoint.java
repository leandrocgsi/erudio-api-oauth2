package br.com.erudio.entrypoint.v1;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import br.com.erudio.converter.ObjectParser;
import br.com.erudio.model.City;
import br.com.erudio.repository.interfaces.ICityRepository;
import br.com.erudio.vo.CityVO;

@Controller
@Secured("ROLE_USER")
@Api(value = "city", description = "Exposes endpoints of service City.")
@RequestMapping("/api/v1/city")
class CityEntryPoint {

	@Autowired
    private ICityRepository cityRepository;
    
	@RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "POST", value = "Saving a city")
	public @ResponseBody CityVO save(@RequestBody CityVO city) {
		city.setInsertDate(new Date());
		city.setActive(true);
		City savedCity = cityRepository.save(ObjectParser.parseObjectInputToObjectOutput(city, City.class));
		CityVO cityVO = ObjectParser.parseObjectInputToObjectOutput(savedCity, CityVO.class);
		addHATEOASSupport(cityVO);
		return cityVO;
	}

	@RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "PUT", value = "Updating a city")
	public @ResponseBody CityVO update(@RequestBody CityVO city) {
		city.setUpdatedDate(new Date());
		City updatedCity = cityRepository.update(ObjectParser.parseObjectInputToObjectOutput(city, City.class));
		CityVO cityVO = ObjectParser.parseObjectInputToObjectOutput(updatedCity, CityVO.class);
		addHATEOASSupport(cityVO);
		return cityVO;
	}
    
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "DELETE", value = "Deleting a city by id")
    public @ResponseBody ResponseEntity<Void> delete(@PathVariable Integer id) {
		cityRepository.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find a city by id")
	public @ResponseBody CityVO findById(@PathVariable Integer id) {
		City city = cityRepository.findById(id);
		CityVO cityVO = ObjectParser.parseObjectInputToObjectOutput(city, CityVO.class);
		addHATEOASSupport(cityVO);
		return cityVO;
	}
	
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find a city by name")
    public @ResponseBody CityVO findCityVOByName(@PathVariable String name) {
        City city = cityRepository.findByName(name);
		CityVO cityVO = ObjectParser.parseObjectInputToObjectOutput(city, CityVO.class);
		addHATEOASSupport(cityVO);
		return cityVO;
    }
    
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find all cities")
    public @ResponseBody List<CityVO> findAll() {
        List<City> allCities = cityRepository.findAll();
		List<CityVO> citiesVO = ObjectParser.parserListObjectInputToObjectOutput(allCities, CityVO.class);
		for (CityVO cityVO : citiesVO) addHATEOASSupport(cityVO);
		return citiesVO;
    }

	private void addHATEOASSupport(CityVO cityVO) {
		cityVO.add(linkTo(methodOn(CityEntryPoint.class).findById(cityVO.getIdCity())).withSelfRel());
	}
}