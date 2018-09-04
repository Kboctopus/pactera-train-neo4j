package com.pactera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.model.node.RNode;
import com.pactera.model.relationship.REdge;
import com.pactera.repository.Neo4JDao;

@Service("neo4JServiceImpl")
public class Neo4JServiceImpl implements Neo4jService{


    @Autowired
    private Neo4JDao neo4JDao;

    /**
     * 添加RNode
     * @param jsonStr
     * @return
     */
    public void addRNode(RNode rn){
        try {
			neo4JDao.createNode(rn);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    /**
     * 创建关系
     * @param srcNode
     * @param tarNode
     * @return
     */
    public void addRelation(RNode srcNode,RNode tarNode){
    	try {
			neo4JDao.createRelation(srcNode,tarNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /**
     * 查询节点
     * @param rNode
     * @return
     */
    public RNode queryNode(RNode rNode) {
    	RNode rn = null;
    	try {
    		rn = neo4JDao.queryNode(rNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return rn;
    }
    
    
    /**
     * 查询节点关系
     * @param srcNode
     * @param tarNode
     * @return
     */
    public REdge queryRelation(RNode srcNode,RNode tarNode){
    	REdge re = null;
    	try {
    		re = neo4JDao.queryRelation(srcNode,tarNode);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	return re;
    }
}
