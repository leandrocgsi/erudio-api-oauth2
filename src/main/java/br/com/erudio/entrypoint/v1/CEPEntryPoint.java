package br.com.erudio.entrypoint.v1;

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

import br.com.erudio.converter.ObjectParser;
import br.com.erudio.repository.interfaces.ICEPRepository;
import br.com.erudio.restclient.model.AddressInfo;
import br.com.erudio.vo.AddressInfoVO;

@Controller
@Secured("ROLE_USER")
@RequestMapping("/api/v1/cep")
@Api(value = "/cep", description = "Building a report in PDF!")
public class CEPEntryPoint {

	@Autowired
	private ICEPRepository cepRepository;
	
	@RequestMapping(value = "/{cep}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Find CEP informations!", notes = "Find CEP informations!")
    public @ResponseBody AddressInfoVO findAddressInfoByCEP(@PathVariable String cep) {
		AddressInfo personEntity = cepRepository.findAddressInfoByCEP(cep);
		return ObjectParser.parseObjectInputToObjectOutput(personEntity, AddressInfoVO.class);
    }
}