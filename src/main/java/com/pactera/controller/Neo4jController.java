package com.pactera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pactera.model.node.RNode;
import com.pactera.model.relationship.REdge;
import com.pactera.service.Neo4jService;

@RestController
@RequestMapping("/neo4j")
public class Neo4jController {

	@Autowired
    private Neo4jService neo4jService;
	
	/**
	 * 添加userNode
	 * @param RNode
	 * @return
	 */
	@RequestMapping("/addRNode")
	public void addRNode(RNode rn){
		neo4jService.addRNode(rn);
    }
	
	/**
	 * 创建关系
	 * @param srcNode
	 * @param tarNode
	 * @return
	 */
	@RequestMapping("/addRelation")
	public void addRelation(RNode srcNode,RNode tarNode){
		neo4jService.addRelation(srcNode,tarNode);
    }
	
	/**
     * 查询节点
     * @param rNode
     * @return
     */
	@RequestMapping("/getRNode")
	public RNode getRNode(RNode rNode){
		return neo4jService.queryNode(rNode);
    }
	
	/**
     * 查询节点关系
     * @param srcNode
     * @param tarNode
     * @return
     */
	@RequestMapping("/getRelation")
	public REdge getRelation(RNode srcNode,RNode tarNode){
		return neo4jService.queryRelation(srcNode,tarNode);
    }
	
	
}
