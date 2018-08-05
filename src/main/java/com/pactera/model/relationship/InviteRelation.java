package com.pactera.model.relationship;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.pactera.model.node.UserNode;

/**
 * 用户邀请关系
 * @author wangg
 *
 */
@RelationshipEntity(type = "InviteRelation")
public class InviteRelation {

	@GraphId
    private Long id;

    @StartNode
    private UserNode startNode;

    @EndNode
    private UserNode endNode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserNode getStartNode() {
        return startNode;
    }

    public void setStartNode(UserNode startNode) {
        this.startNode = startNode;
    }

    public UserNode getEndNode() {
        return endNode;
    }

    public void setEndNode(UserNode endNode) {
        this.endNode = endNode;
    }
}
