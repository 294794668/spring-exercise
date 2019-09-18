package pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author pengfei.cheng
 * @description 人类
 * @date 2019-09-18 15:09
 */
//@Data
@Getter
@Setter
@ToString
public class Person implements Serializable {

    private String id;

    private String name;

    private String gender;

}
