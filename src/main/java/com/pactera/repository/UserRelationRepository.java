package com.pactera.repository;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.pactera.model.relationship.InviteRelation;

@Component
public interface UserRelationRepository extends GraphRepository<InviteRelation> {

    @Query("match p=(n:User)<-[r:UserRelation]->(n1:User) where n.userId={firstUserId} and n1.userId={secondUserId} return p")
    List<InviteRelation> findUserRelationByEachId(@Param("firstUserId") String firstUserId, @Param("secondUserId") String secondUserId);

    @Query("match (fu:User),(su:User) where fu.userId={firstUserId} and su.userId={secondUserId} create p=(fu)-[r:UserRelation]->(su) return p")
    List<InviteRelation> addUserRelation(@Param("firstUserId") String firstUserId, @Param("secondUserId") String secondUserId);

}