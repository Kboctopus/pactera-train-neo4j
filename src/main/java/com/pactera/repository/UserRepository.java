package com.pactera.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.pactera.model.node.UserNode;

@Component
public interface UserRepository extends GraphRepository<UserNode> {

    @Query("MATCH (n:User) RETURN n ")
    List<UserNode> getUserNodeList();

    @Query("create (n:User{age:{age},name:{name}}) RETURN n ")
    List<UserNode> addUserNodeList(@Param("name") String name, @Param("age")int age);
}
