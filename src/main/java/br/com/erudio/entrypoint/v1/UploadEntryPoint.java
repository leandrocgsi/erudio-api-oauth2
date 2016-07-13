package br.com.erudio.entrypoint.v1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    
    @Autowired
    private IImportRepository importRepository;
    
    FileUtils fileUtils = new FileUtils();

    @ResponseStatus(value = HttpStatus.OK)
    @ApiOperation(value = "Uploading file!", notes = "Uploading file!")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 500, message = "Houston we have a problem") })
    @RequestMapping(method = RequestMethod.POST, value = "/")
    public String handleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws Exception {

        if (!file.isEmpty()) {
            try {
                importRepository.importFile(file);
//                Files.copy(file.getInputStream(), Paths.get(ROOT, file.getOriginalFilename()));
                redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
            } catch (IOException|RuntimeException e) {
                e.printStackTrace();
                redirectAttributes.addFlashAttribute("message", "Failued to upload " + file.getOriginalFilename() + " => " + e.getMessage());
            }
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to upload " + file.getOriginalFilename() + " because it was empty");
        }

        return "redirect:/";
    }
}