package com.pactera.model.relationship;

import com.pactera.model.node.RNode;
import com.pactera.model.base.RObject;

/**
 * 边 == 关系
 * @author wanggl
 */
public class REdge extends RObject{

	
	private Long relationID; //关系的ID  ==  聚合、连接、属于、包括等，这些关系可能是枚举字典，因此记录关系ID是有必要的
	private String name; //关系名称
	private RNode  rNode; //关系指向哪一个节点 == 可能这个节点还有关系【节点关系递增下去】
	
	public Long getRelationID() {
		return relationID;
	}
	public void setRelationID(Long relationID) {
		this.relationID = relationID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RNode getrNode() {
		return rNode;
	}
	public void setrNode(RNode rNode) {
		this.rNode = rNode;
	}
	
}
