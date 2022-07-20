package com.hunzhizi.service;

import com.github.pagehelper.PageInfo;
import com.hunzhizi.domain.Certificate;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 14:20
 * @description:
 */
@Transactional
public interface CertificateService {
    boolean addCertificate(Certificate certificate);

    boolean certificate(boolean success, Certificate certificate);

    PageInfo<Certificate> getAllCertificate(Integer pageNum, Integer pageSize);
}
