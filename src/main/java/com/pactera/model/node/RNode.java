package com.pactera.model.node;

import com.pactera.model.base.RObject;
import com.pactera.model.relationship.REdge;

/**
 * 节点
 * @author wanggl
 */
public class RNode extends RObject{
    
	/**
	 * 节点的uuid == 对应其他数据库中的主键
	 */
	private Long uuid;
	
	/**
	 * 节点里面是否包含有边 == 关系
	 */
	private REdge edge;

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public REdge getEdge() {
		return edge;
	}

	public void setEdge(REdge edge) {
		this.edge = edge;
	}
}
