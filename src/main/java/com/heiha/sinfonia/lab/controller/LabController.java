package com.heiha.sinfonia.lab.controller;

import com.heiha.sinfonia.lab.util.MD5Util;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/8/29 15:24<br>
 * <b>Author:</b> heiha<br>
 */
@RestController
@RequestMapping("/v1/lab")
public class LabController {
    @GetMapping("/info")
    public ResponseEntity<String> info() {
        StringBuffer sb = new StringBuffer();
        sb.append("sinfonia lab info");
        return ResponseEntity.ok(sb.toString());
    }

    @PostMapping("/md5")
    public ResponseEntity<String> upload(@RequestBody MultipartFile multipartFile)
            throws IOException, NoSuchAlgorithmException {
        return ResponseEntity.ok(MD5Util.digest(multipartFile.getBytes()));
    }

    @GetMapping(value = "/domain/{domain:.+}",
//            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.ALL_VALUE}
    )
    public ResponseEntity<String> domain(@PathVariable String domain) {
        return ResponseEntity.ok(domain);
    }
}
