package com.lestsoos.springboot.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.lestsoos.springboot.common.entity.BaseEntity;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Title:
 * Company:lestsoos
 *
* @author LinHuiXin
 * @date Tue Nov 27 11:39:13 CST 2018
 */
@Entity(name = "CLASSES")
@ApiModel("班级")
@EntityListeners(AuditingEntityListener.class)
public class Classes {

  @Id
  @GeneratedValue(generator = "sys-uuid")
  @GenericGenerator(name = "sys-uuid", strategy = "uuid")
  private String id;

  @ApiModelProperty("班级名称")
  @Column(name="name")
  private String name;

  @CreatedDate
  @ApiModelProperty("新增日期")
  @Column(name="addtime")
  @Temporal(TemporalType.TIMESTAMP)
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date addtime;

  @ApiModelProperty("新增人")
  @Column(name="adduser")
  private String adduser;

  @LastModifiedDate
  @ApiModelProperty("修改日期")
  @Column(name="updatetime")
  @Temporal(TemporalType.TIMESTAMP)
  @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss.SSS")
  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
  private Date updatetime;

  @ApiModelProperty("修改人")
  @Column(name="updateuser")
  private String updateuser;

  @ApiModelProperty("状态:1 可用 2 ")
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
