package br.com.erudio.entrypoint.v1;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import br.com.erudio.repository.interfaces.IReportRepository;


@Controller
@Secured("ROLE_USER")
@RequestMapping("/api/v1/report")
@Api(value = "/report", description = "Building a report in PDF!")
public class ReportEntryPoint {

	@Autowired
	private IReportRepository reportRepository;
	
	@RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
	@ApiOperation(value = "Building a report in PDF!", notes = "Building a report in PDF!")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Houston we have a problem")})
    public @ResponseBody ResponseEntity<Void> makeReport() throws Exception {
		File file = reportRepository.makeReport();
		//return Response.ok().entity(file).header("Content-Disposition", "attachment; filename=output.pdf").build();
    	return ResponseEntity.status(HttpStatus.OK).build();
    }
}