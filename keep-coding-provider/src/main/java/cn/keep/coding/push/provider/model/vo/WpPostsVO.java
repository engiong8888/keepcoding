package cn.keep.coding.push.provider.model.vo;

import cn.keep.coding.database.annotation.Table;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * @ClassName WpPosts
 * @Description wp_posts表
 * @mail
 * @Author cheng
 * @Date 2020/11/10 17:55
 * @Version 1.0
 */
@Table(name="wp_posts")
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class WpPostsVO implements Serializable {

    private BigInteger id;

}
