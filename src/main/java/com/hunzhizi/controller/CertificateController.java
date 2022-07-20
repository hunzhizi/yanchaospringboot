package com.hunzhizi.controller;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.controller.results.Code;
import com.hunzhizi.controller.results.Result;
import com.hunzhizi.domain.Certificate;
import com.hunzhizi.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 15:43
 * @description:
 */
@RestController
@RequestMapping("/certificate")
public class CertificateController {
    @Autowired
    private CertificateService certificateService;

    @PostMapping
    public Result addCertificate(@RequestBody Certificate certificate) {
        boolean flag = certificateService.addCertificate(certificate);
        return flag ?
                new Result(Code.CERTIFICATE_SAVE_OK) :
                new Result(Code.CERTIFICATE_SAVE_ERR);
    }

    @DeleteMapping("/fail")
    public Result certificateFail(@RequestBody Certificate certificate) {
        boolean flag = certificateService.certificate(false, certificate);
        return flag ?
                new Result(Code.CERTIFICATE_UPDATE_OK) :
                new Result(Code.CERTIFICATE_UPDATE_ERR);
    }

    @DeleteMapping("/success")
    public Result certificateSuccess(@RequestBody Certificate certificate) {
        boolean flag = certificateService.certificate(true, certificate);
        return flag ?
                new Result(Code.CERTIFICATE_UPDATE_OK) :
                new Result(Code.CERTIFICATE_UPDATE_ERR);
    }

    @GetMapping("/{pageNum}/{pageSize}")
    public Result getAllCertificate(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        PageInfo<Certificate> allCertificate = certificateService.getAllCertificate(pageNum, pageSize);
        return new Result(Code.CERTIFICATE_GET_OK, allCertificate);
    }
}
