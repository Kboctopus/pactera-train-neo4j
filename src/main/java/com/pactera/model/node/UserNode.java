package com.pactera.model.node;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * 用户实体节点
 * @author wangg
 *
 */
@NodeEntity(label = "User")
public class UserNode {

	@GraphId
	private Long nodeId;
	
	@Property(name = "userId")
	private String userId;  	//用户编号
	@Property(name = "userName")
	private String userName;	//用户姓名
	@Property(name = "born")
	private String born;		//出生日期
	@Property(name = "sex")
	private String sex;			//性别
	@Property(name = "age")
	private int  age;			//年龄
	@Property(name = "phone")
	private String phone;		//手机号码
	public Long getNodeId() {
		return nodeId;
	}
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getBorn() {
		return born;
	}
	public void setBorn(String born) {
		this.born = born;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
