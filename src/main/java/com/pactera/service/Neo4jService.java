package com.pactera.service;

import com.pactera.model.node.RNode;
import com.pactera.model.relationship.REdge;

/**
 * service interface
 * @author wanggl
 *
 */
public interface Neo4jService {

    /**
     * 添加RNode
     * @param jsonStr
     * @return
     */
    public void addRNode(RNode rn);
    /**
     * 创建关系
     * @param srcNode
     * @param tarNode
     * @return
     */
    public void addRelation(RNode srcNode,RNode tarNode);
    
    /**
     * 查询节点
     * @param rNode
     * @return
     */
    public RNode queryNode(RNode rNode);
    
    
    /**
     * 查询节点关系
     * @param srcNode
     * @param tarNode
     * @return
     */
    public REdge queryRelation(RNode srcNode,RNode tarNode);
    
}