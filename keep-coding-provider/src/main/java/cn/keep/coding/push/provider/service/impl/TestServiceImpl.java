package cn.keep.coding.push.provider.service.impl;

import cn.keep.coding.database.DaoSupport;
import cn.keep.coding.push.provider.dev.model.MemberDO;
import cn.keep.coding.push.provider.service.TestService;
import cn.keep.coding.push.provider.test.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName TestServiceImpl
 * @Description TODO
 * @Author cheng
 * @mail engiong8888@sina.cn
 * @Date 2020/9/29
 * @Version 1.0
 */
@Service
public class TestServiceImpl implements TestService {


    @Qualifier("testDaoSupport")
    @Autowired
    private DaoSupport testDaoSupport;

    @Qualifier("devDaoSupport")
    @Autowired
    private DaoSupport devDaoSupport;


    @Override
    public void queryOne() {

        Integer id = 1;
        String sql = "select * from user where id =?";
       List<UserDO> list = this.testDaoSupport.queryForList(sql, UserDO.class, id);
        System.out.println(list.get(0).toString());

        String sql2 = "select * from member where id =?";
        List<MemberDO> list2 = this.devDaoSupport.queryForList(sql2, MemberDO.class, id);
        System.out.println(list2.get(0).toString());
//
//        MemberDO member = this.devDaoSupport.queryForObject(MemberDO.class, id);
//        System.out.println(member);
    }
}
