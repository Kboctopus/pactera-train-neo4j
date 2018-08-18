package com.pactera.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pactera.model.node.UserNode;
import com.pactera.model.relationship.InviteRelation;
import com.pactera.service.Neo4jService;

@RestController
@RequestMapping("/neo4j")
public class Neo4jController {

	@Autowired
    private Neo4jService neo4jService;
	
	/**
	 * 添加userNode
	 * @param userNode
	 * @return
	 */
	@RequestMapping("/addUserNode")
	public int addUserNode(UserNode userNode){
		return neo4jService.addUser(userNode);
    }
	
	/**
	 * 添加userNode
	 * @param userNode
	 * @return
	 */
	@RequestMapping("/addUserNodeList")
	public int addUserList(List<UserNode> unList){
		return neo4jService.addUserList(unList);
	}
	/**
	 * 通过UserId获取UserNode
	 * @param userId
	 * @return
	 */
	@RequestMapping("/getUserNode")
	public UserNode getUserNode(String userId){
        return neo4jService.getUser(userId);
    }
	
	/**
	 * 获取UserNodeList
	 * @return
	 */
	@RequestMapping("/getUserNodeList")
	public List<UserNode> getUserNodeList(){
        return neo4jService.getUserList();
    }
	
	/**
	 * 添加邀友关系
	 * @param firstUserId
	 * @param secondUserId
	 * @return
	 */
	@RequestMapping("/addUserRelation")
	public  List<InviteRelation> addUserRelation(String firstUserId, String secondUserId){
		return neo4jService.addUserRelation(firstUserId,secondUserId);
	}
	
	/**
	 * 查询邀友关系
	 * @param firstUserId
	 * @param secondUserId
	 * @return
	 */
	public List<InviteRelation> findUserRelationByEachId(String firstUserId, String secondUserId){
		return neo4jService.findUserRelationByEachId(firstUserId,secondUserId);
	}
	
	
}
