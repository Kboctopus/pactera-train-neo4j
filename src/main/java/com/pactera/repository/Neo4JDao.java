package com.pactera.repository;

import com.pactera.model.node.RNode;
import com.pactera.model.relationship.REdge;

/**
 * 节点/节点关系查询dao
 * @author wanggl
 *
 */
public interface Neo4JDao {

	/**
	 * 创建节点
	 * @param rNode
	 * @throws Exception
	 */
	public void createNode(RNode rNode) throws Exception;
	
	/**
	 * 创建关系
	 * @param srcNode
	 * @param tarNode
	 * @throws Exception
	 */
	public void createRelation(RNode srcNode,RNode tarNode) throws Exception;
		
	/**
	 * 查询节点
	 * 
	 * @param rNode
	 * @return
	 */
	public RNode queryNode(RNode rNode);

	/**
	 * 查询关系
	 * @param rNode
	 * @return
	 */
	public REdge queryRelation(RNode srcNode,RNode tarNode);
}
