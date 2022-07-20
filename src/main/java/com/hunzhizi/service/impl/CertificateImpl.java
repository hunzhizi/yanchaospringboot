package com.hunzhizi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hunzhizi.dao.CertificateDao;
import com.hunzhizi.dao.UserDao;
import com.hunzhizi.domain.Certificate;
import com.hunzhizi.domain.User;
import com.hunzhizi.service.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 魂之子
 * @program: yanChao
 * @create: 2022-05-09 14:26
 * @description:
 */
@Service
public class CertificateImpl implements CertificateService {
    @Resource
    private CertificateDao certificateDao;
    @Resource
    private UserDao userDao;

    @Override
    public boolean addCertificate(Certificate certificate) {
        return certificateDao.createCertificate(certificate);
    }

    @Override
    public boolean certificate(boolean success, Certificate certificate) {
        boolean flag;
        if (success) {
            User user = new User();
            user.setUserId(certificate.getUserId());
            user.setRecognized(true);
            flag = userDao.update(user);
        } else {
            flag = certificateDao.delCertificate(certificate.getCertificateId());
            //TODO 删除 + 通知
            //通知之后可能会用redis处理
        }
        return flag;
    }

    @Override
    public PageInfo<Certificate> getAllCertificate(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Certificate> allCertificate = certificateDao.getAllCertificate();
        return new PageInfo<>(allCertificate);
    }
}
