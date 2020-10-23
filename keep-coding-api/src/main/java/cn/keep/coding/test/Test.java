package cn.keep.coding.test;

import cn.keep.coding.utils.WebRequestUtil;

/**
 * @ClassName Test
 * @Description TODO
 * @mail
 * @Author cheng
 * @Date 2020/10/22 16:51
 * @Version 1.0
 */
public class Test {

    public static void main(String[] args) {
        WebRequestUtil.httpsRequest("www.yugonghf.com/yuer/1sui/382.html","GET", null, null );
    }
}
