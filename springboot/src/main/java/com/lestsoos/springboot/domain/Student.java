package com.lestsoos.springboot.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.lestsoos.springboot.common.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Title:
 * Company:lestsoos
 *
* @author LinHuiXin
 * @date Thu Nov 22 18:39:08 CST 2018
 */
@Entity(name = "STUDENT")
@ApiModel("学生")

public class Student  extends BaseEntity {

  @ApiModelProperty("学生ID")
  @Id
  @GeneratedValue(generator = "sys-uuid")
  @GenericGenerator(name = "sys-uuid", strategy = "uuid")
  private String id;

  @ApiModelProperty("姓名")
  @Column(name="name")
  private String name;

  @ApiModelProperty("性别:1 男 0 女")
  @Column(name="sex")
  private String sex;

  @ApiModelProperty("出生日期")
  @Column(name="birthday")
  @Temporal(TemporalType.TIMESTAMP)
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date birthday;

  @ApiModelProperty("班级ID")
  @Column(name="classid")
  private String classid;

  @ApiModelProperty("新增日期")
  @Column(name="addtime")
  @Temporal(TemporalType.TIMESTAMP)
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date addtime;

  @ApiModelProperty("新增人")
  @Column(name="adduser")
  private String adduser;

  @ApiModelProperty("修改日期")
  @Column(name="updatetime")
  @Temporal(TemporalType.TIMESTAMP)
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date updatetime;

  @ApiModelProperty("修改人")
  @Column(name="updateuser")
  private String updateuser;

  @ApiModelProperty("状态:1 可用 2")
  @Column(name="staus")
  private String staus;



  public String getId() {
    return this.id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return this.sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public Date getBirthday() {
    return this.birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getClassid() {
    return this.classid;
  }

  public void setClassid(String classid) {
    this.classid = classid;
  }

  public Date getAddtime() {
    return this.addtime;
  }

  public void setAddtime(Date addtime) {
    this.addtime = addtime;
  }

  public String getAdduser() {
    return this.adduser;
  }

  public void setAdduser(String adduser) {
    this.adduser = adduser;
  }

  public Date getUpdatetime() {
    return this.updatetime;
  }

  public void setUpdatetime(Date updatetime) {
    this.updatetime = updatetime;
  }

  public String getUpdateuser() {
    return this.updateuser;
  }

  public void setUpdateuser(String updateuser) {
    this.updateuser = updateuser;
  }

  public String getStaus() {
    return this.staus;
  }

  public void setStaus(String staus) {
    this.staus = staus;
  }
}
