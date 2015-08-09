package me.rnatest.controller;

import me.rnatest.entity.Catalog;
import me.rnatest.entity.Cd;
import me.rnatest.service.DocService;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


@Controller
public class MainController {

    Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "index2";
    }

    @RequestMapping("/uploadlayout")
    public String getUploadPage() {
        return "uploadlayout";
    }

    @RequestMapping("/downloadlayout")
    public String getDownloadPage() {
        return "downloadlayout";
    }

    @RequestMapping("/listlayout")
    public String getListPage() {
        return "listlayout";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public @ResponseBody void handleFileUpload(@RequestParam(value="file", required=true) MultipartFile file) {
        log.info(file.getOriginalFilename()+ " was uploaded");

        DocService.add(file);
    }

    @RequestMapping(value = "/download", method = RequestMethod.POST)
    public @ResponseBody void handleFileDownload(HttpServletResponse response) throws IOException {
        response.setContentType("application/xml");
        response.setHeader("Content-Disposition", "attachment; filename=doc.xml");
        byte[] data = DocService.cat2Ba(DocService.getDoc());
        response.setContentLength(data.length);
        ServletOutputStream out = response.getOutputStream();
        out.write(data);
        out.flush();
        out.close();
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public @ResponseBody List<Cd> handleList() throws IOException {
        Catalog cat = DocService.getDoc();
        log.info("listing cds "+cat.cds);
        return cat.cds;
    }
}
