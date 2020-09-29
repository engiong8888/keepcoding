package cn.keep.coding.push.provider.dev.model;

import cn.keep.coding.database.annotation.Table;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;

/**
 * @ClassName MemberDO
 * @Description TODO
 * @Author cheng
 * @Date 2020/9/29 14:44
 * @Version 1.0
 */
@Table(name = "member")
@JsonNaming(value = PropertyNamingStrategy.SnakeCaseStrategy.class)
public class MemberDO implements Serializable {

    private  Integer id;
    private String phone;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MemberDO{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
