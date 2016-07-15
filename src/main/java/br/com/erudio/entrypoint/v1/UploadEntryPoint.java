package br.com.erudio.entrypoint.v1;

import java.io.InputStream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import br.com.erudio.repository.interfaces.IImportRepository;
import br.com.erudio.utils.FileUtils;

@Controller
@Secured("ROLE_USER")
@RequestMapping("/api/v1/upload")
@Api(value = "/upload", description = "Uploading file!")
public class UploadEntryPoint {

    public static final String ROOT = "upload-dir";

    private static final Logger logger = Logger.getLogger(UploadEntryPoint.class);

    @Autowired
    private IImportRepository importRepository;

    FileUtils fileUtils = new FileUtils();

    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Uploading file!", notes = "Uploading file!")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500,
                                                                                   message = "Houston we have a problem") })
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public void handleFileUpload(@RequestParam("file") MultipartFile file) throws Exception {

        if (!file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename().toLowerCase();
                InputStream inputStream = file.getInputStream();

                importRepository.importFile(inputStream, fileName);
            } catch (RuntimeException e) {
                logger.error("Error while uploading.", e);
                throw e;
            } catch (Exception e) {
                logger.error("Error while uploading.", e);
                throw new RuntimeException(e);
            }
        }
    }
}