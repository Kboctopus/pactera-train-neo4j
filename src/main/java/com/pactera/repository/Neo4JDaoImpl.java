package com.pactera.repository;

import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Value;
import org.neo4j.driver.v1.types.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pactera.model.node.RNode;
import com.pactera.model.relationship.REdge;

@Repository
public class Neo4JDaoImpl implements Neo4JDao{

	final static ObjectMapper mapper = new ObjectMapper();

	 static {
		 /**
		  * 使用neo4j的session执行条件语句statement，一定要使用这个反序列化对象为json字符串
		  * 下面的设置的作用是，比如对象属性字段name="李二明"，正常反序列化json为 == "name":"李二明"
		  * 如果使用下面的设置后，反序列name就是 == name:"appleyk"
		  * 而session执行语句create (:儿子{"name":"李二明","uuid":3330,"age":12,"height":"165cm"})会报错
		  * 因此,......etc
		  */		 
		 mapper.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
	 }

	@Autowired
	private Session session;
	
	/**
	 * 创建节点
	 * @param rNode
	 * @throws Exception
	 */
	public void createNode(RNode rNode) throws Exception{
		RNode srcNode = queryNode(rNode);
		//查node是否已經存在了，不存在則創建
		if(srcNode == null){
			String propertiesString = mapper.writeValueAsString(rNode.getProperties());
			String cypherSql = String.format("create (:%s%s)", rNode.getLabel(), propertiesString);
			System.out.println(cypherSql);
			session.run(cypherSql);
			System.err.println("创建节点："+rNode.getLabel()+"成功！");
		}else{
			System.err.println("节点已存在，跳过创建");
		}
	}
	
	/**
	 * 创建关系
	 * @param srcNode
	 * @param tarNode
	 * @throws Exception
	 */
	public void createRelation(RNode srcNode,RNode tarNode) throws Exception{
		REdge edge = queryRelation(srcNode,tarNode);
		if(edge == null){
			edge = srcNode.getEdge();
			String propertiesString = mapper.writeValueAsString(edge.getProperties());
			String cypherSql = String.format("match(a),(b) where a.uuid=%d and b.uuid=%d create (a)-[r:%s %s]->(b)", 
					srcNode.getUuid(),tarNode.getUuid(),
					edge.getName(), propertiesString);
			System.out.println(cypherSql);
			session.run(cypherSql);
			System.err.println("创建关系："+edge.getName()+"成功！");
		}else{
			System.err.println("关系已存在，跳过创建");
		}
	}

	
		
	/**
	 * 查询节点
	 * 
	 * @param rNode
	 * @return
	 */
	public RNode queryNode(RNode rNode) {

		RNode node = null;
		String cypherSql = String.format("match(n:%s) where n.uuid = %d return n", rNode.getLabel(), rNode.getUuid());
		StatementResult result = session.run(cypherSql);
		if (result.hasNext()) {
			Record record = result.next();
			for (Value value : record.values()) {
				/**
				 * 结果里面只要类型为节点的值
				 */
				if (value.type().name().equals("NODE")) {
					 Node noe4jNode = value.asNode();
					 node = new RNode();
					 node.setLabel(rNode.getLabel());
					 node.setProperties(noe4jNode.asMap());
					
				}
			}
		}
		return node;
	}

	/**
	 * 查询关系
	 * @param rNode
	 * @return
	 */
	public REdge queryRelation(RNode srcNode,RNode tarNode){
		REdge edge = srcNode.getEdge();
		String cypherSql =String.format("match(n)-[r:%s]-(b) where n.uuid = %d and b.uuid = %d return r", 
				edge.getName(),srcNode.getUuid(),tarNode.getUuid());
		StatementResult result = session.run(cypherSql);
		if(result.hasNext()){
			return edge;
		}
		return null;
	}
    
}

