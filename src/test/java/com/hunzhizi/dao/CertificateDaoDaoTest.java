package com.hunzhizi.dao;


import com.hunzhizi.domain.Certificate;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 13:28
 * @description:
 */
@SpringBootTest
public class CertificateDaoDaoTest{
    @Autowired
    private CertificateDao certificateDao;

    @Test
    public void createCertificate() {
        Certificate certificate = new Certificate();
        certificate.setUserId(1);
        certificateDao.createCertificate(certificate);
    }

    @Test
    public void delCertificate() {
        certificateDao.delCertificate(1);
    }

    @Test
    public void getAllCertificate() {
        List<Certificate> allCertificate = certificateDao.getAllCertificate();
        Certificate certificate = allCertificate.get(0);
    }

}
