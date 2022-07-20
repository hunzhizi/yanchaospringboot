package com.hunzhizi.dao;

import com.hunzhizi.domain.Certificate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 13:17
 * @description:
 */
@Mapper
public interface CertificateDao {
    boolean createCertificate(Certificate certificate);

    boolean delCertificate(Integer certificateId);

    List<Certificate> getAllCertificate();
}
