package com.mask.demo.service.impl.system;

import com.mask.demo.service.api.system.SysAccessPermissionService;
import com.mask.demo.dao.system.SysAccessPermissionTestMapper;
import com.mask.demo.model.system.SysAccessPermissionTest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by gameloft9 on 2017/12/4.
 */
@Slf4j
@Service
public class SysAccessPermissionServiceImpl implements SysAccessPermissionService {

    @Autowired
    SysAccessPermissionTestMapper sysAccessPermissionTestDao;

    @Override
    public List<SysAccessPermissionTest> getAll(){
        return sysAccessPermissionTestDao.selectAll();
    }


}
