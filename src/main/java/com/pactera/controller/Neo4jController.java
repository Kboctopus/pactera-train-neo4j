package com.pactera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pactera.model.node.UserNode;
import com.pactera.service.Neo4jService;

@Controller
public class Neo4jController {

	@Autowired
    private Neo4jService neo4jService;
	
	@RequestMapping("/addUserNode")
	public int addUserNode(UserNode userNode){
		neo4jService.addUser(userNode);
        return 1;
    }
}
