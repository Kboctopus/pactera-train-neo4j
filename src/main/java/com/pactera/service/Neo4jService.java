package com.pactera.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pactera.model.node.UserNode;
import com.pactera.repository.UserRelationRepository;
import com.pactera.repository.UserRepository;

@Service
public class Neo4jService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRelationRepository userRelationRepository;

    /**
     * Always use constructor based dependency injection in your beans.
     * Always use assertions for mandatory dependencies.
     */

    public int addUser(UserNode userNode){
        userRepository.addUserNodeList(userNode.getUserName(),userNode.getAge());
        return 1;
    }
}