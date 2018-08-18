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

    @Query("create (n:User{userId:{userId},userName:{userName},born:{born},sex:{sex},age:{age},phone:{phone}}) RETURN n ")
    List<UserNode> addUserNodeList(@Param("userId") String userId,@Param("userName") String userName,
    		@Param("born")String born,@Param("sex") String sex, @Param("age")int age, @Param("phone")String phone);
    
    @Query("MATCH (n:User) RETURN n where n.userId= {userId}")
    UserNode getUserNode(@Param("userId") String userId);
    
}
