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
import br.com.erudio.dto.PagedSearchDTO;
import br.com.erudio.model.Person;
import br.com.erudio.repository.interfaces.IPersonRepository;
import br.com.erudio.vo.PersonVO;

@Controller
@Secured("ROLE_USER")
@Api(value = "person", description = "Exposes endpoints of service Person.")
@RequestMapping("/api/v1/person")
class PersonEntryPoint {

    @Autowired
    private IPersonRepository personRepository;
    
    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(httpMethod = "POST", value = "Insert a new person")
    public @ResponseBody PersonVO save(@RequestBody Person person) {
        person.setIdUserInsert(0);
        person.setInsertDate(new Date());
        person.setActive(true);
        Person personEntity = ObjectParser.parseObjectInputToObjectOutput(person, Person.class);
        personEntity = personRepository.save(personEntity);
        PersonVO personVO = ObjectParser.parseObjectInputToObjectOutput(personEntity, PersonVO.class);
        addHATEOASSupport(personVO);
        return personVO;
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(httpMethod = "PUT", value = "Update person")
    public @ResponseBody PersonVO update(@RequestBody Person person) {
        person.setIdUserUpdate(0);
        person.setUpdatedDate(new Date());
        Person personEntity = ObjectParser.parseObjectInputToObjectOutput(person, Person.class);
        personEntity = personRepository.update(personEntity);
        PersonVO personVO = ObjectParser.parseObjectInputToObjectOutput(personEntity, PersonVO.class);
        addHATEOASSupport(personVO);
        return personVO;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(httpMethod = "DELETE", value = "Delete persons by id")
    public @ResponseBody ResponseEntity<Void> delete(@PathVariable Integer id) {
        personRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(httpMethod = "GET", value = "Find persons by id")
    public @ResponseBody PersonVO findById(@PathVariable Integer id) {
        Person personEntity = personRepository.findById(id);
        PersonVO personVO = ObjectParser.parseObjectInputToObjectOutput(personEntity, PersonVO.class);
        addHATEOASSupport(personVO);
        return personVO;
    }
    
    @RequestMapping(value = "/findByName/{name}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(httpMethod = "GET", value = "Find persons by name")
    public @ResponseBody PersonVO findPersonByName(@PathVariable String name) {
        Person personEntity = personRepository.findByName(name);
        PersonVO personVO = ObjectParser.parseObjectInputToObjectOutput(personEntity, PersonVO.class);
        addHATEOASSupport(personVO);
        return personVO;
    }
    
    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(httpMethod = "GET", value = "Find all persons")
    public @ResponseBody List<PersonVO> findAll() {
        List<Person> allPersons = personRepository.findAll();
        List<PersonVO> personsVO = ObjectParser.parserListObjectInputToObjectOutput(allPersons, PersonVO.class);
        for (PersonVO personVO : personsVO) addHATEOASSupport(personVO);
        return personsVO;
    }
    
    @RequestMapping(value = "/pagedSearch", method = RequestMethod.POST)
    public @ResponseBody PagedSearchDTO<PersonVO> buscaPaginada(@RequestBody PagedSearchDTO<PersonVO> person) {
        return personRepository.pagedSearch(person);
    }

    private void addHATEOASSupport(PersonVO personVO) {
        personVO.add(linkTo(methodOn(PersonEntryPoint.class).findById(personVO.getIdPerson())).withSelfRel());
    }
}