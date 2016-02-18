package br.com.erudio.entrypoint.v1;

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

import br.com.erudio.model.City;
import br.com.erudio.repository.interfaces.ICityRepository;

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
	public @ResponseBody City save(@RequestBody City city) {
		return cityRepository.save(city);
	}

	@RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "PUT", value = "Updating a city")
	public @ResponseBody City update(@RequestBody City city) {
		return cityRepository.update(city);
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
	public @ResponseBody City findById(@PathVariable Integer id) {
		return cityRepository.findById(id);
	}
	
	@RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find a city by name")
    public @ResponseBody City findCityByName(@PathVariable String name) {
        return cityRepository.findByName(name);
    }
    
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(httpMethod = "GET", value = "Find all cities")
    public @ResponseBody List<City> findAll() {
        return cityRepository.findAll();
    }
}