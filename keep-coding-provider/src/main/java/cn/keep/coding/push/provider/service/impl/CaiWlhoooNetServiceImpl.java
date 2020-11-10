package cn.keep.coding.push.provider.service.impl;

import cn.keep.coding.database.DaoSupport;
import cn.keep.coding.push.provider.service.CaiWlhoooNetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName CaiWlhoooNetService
 * @Description www.wlhooo.net
 * @mail
 * @Author cheng
 * @Date 2020/11/10 17:22
 * @Version 1.0
 */
@Service
public class CaiWlhoooNetServiceImpl implements CaiWlhoooNetService {

    @Qualifier("localDaoSupport")
    @Autowired
    private DaoSupport localDaoSupport;


    @Override
    public void collect2Local() {

    }
}
