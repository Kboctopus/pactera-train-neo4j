package com.pactera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.pactera.model.node.UserNode;
import com.pactera.model.relationship.InviteRelation;
import com.pactera.repository.UserRelationRepository;
import com.pactera.repository.UserRepository;

@Service
public class Neo4jService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRelationRepository userRelationRepository;

    /**
     * 添加UserNode
     * @param userNode
     * @return
     */
    public int addUser(UserNode userNode){
        userRepository.addUserNodeList(userNode.getUserId(),userNode.getUserName(),
        		userNode.getBorn(),userNode.getSex(),userNode.getAge(),userNode.getPhone());
        return 1;
    }

    /**
     * 批量添加userNode
     * @param userNodeList
     * @return
     */
    public int addUserList(List<UserNode> userNodeList){
    	if(userNodeList != null && !userNodeList.isEmpty()){
    		for(UserNode un : userNodeList){
    			userRepository.addUserNodeList(un.getUserId(),un.getUserName(),
    					un.getBorn(),un.getSex(),un.getAge(),un.getPhone());
    		}
    	}
        return 1;
    }
    /**
     * 通过userId获取UserNode
     * @param userId
     */
	public UserNode getUser(String userId) {
		return userRepository.getUserNode(userId);
	}
	/**
	 * 获取UserNodeList
	 * @return
	 */
	public List<UserNode> getUserList(){
		return userRepository.getUserNodeList();
	}
	
	/**
	 * 添加邀友关系
	 * @param firstUserId
	 * @param secondUserId
	 * @return
	 */
	public  List<InviteRelation> addUserRelation(String firstUserId, String secondUserId){
		return userRelationRepository.addUserRelation(firstUserId,secondUserId);
	}
	/**
	 * 查询邀友关系
	 * @param firstUserId
	 * @param secondUserId
	 * @return
	 */
	public List<InviteRelation> findUserRelationByEachId(String firstUserId, String secondUserId){
		return userRelationRepository.findUserRelationByEachId(firstUserId,secondUserId);
	}
}