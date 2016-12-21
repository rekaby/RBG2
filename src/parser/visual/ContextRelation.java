package parser.visual;

import java.util.ArrayList;

public class ContextRelation {

	String verb=""; //action of Agent, Theme, INST and Owner in Own relation 
	String entity="";//object in Agent, Theme, Instrument, and Child (Owned)in owner relation
	ContextRelationType type;
	private String getVerb() {
		return verb;
	}
	private void setVerb(String verb) {
		this.verb = verb;
	}
	private String getEntity() {
		return entity;
	}
	private void setEntity(String object) {
		entity = object;
	}
	public ContextRelationType getType() {
		return type;
	}
	public void setType(ContextRelationType type) {
		this.type = type;
	}
	public ContextRelation(String verb, String object,ContextRelationType type) {
		super();
		this.verb = verb;
		entity = object;
		this.type=type;
		System.out.println("New Relation:"+object+ " "+ verb+" "+ type.name());
	}
	/*public ContextRelation(String verb, String object) {
		super();
		this.verb = verb;
		entity = object;
		System.out.println("New Relation:"+object+ " "+ verb);
	}*/
	public boolean hasAction(String[] statement, int index) {//check that the verb which has one or more tokens is same verb there in the statement
		
		String[] lstTokens ;
		int count=0;
		
		try {
			lstTokens=verb.trim().split(" ");
			for (int i = 0,j=index; i < lstTokens.length && j<statement.length; i++, j++) {
				if (lstTokens[i].equalsIgnoreCase(statement[j])) {
					count++;
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		/*if (count== lstTokens.length) {
			System.out.println("Action Match "+verb +" "+index+" "+type);	
		}*/
	  return count== lstTokens.length? true:false;  
	}
	public boolean hasEntity(String[] statement, int index) {
		
		String[] lstTokens ;
		int count=0;
		
		try {
			lstTokens=entity.trim().split(" ");
			for (int i = 0,j=index; i < lstTokens.length && j<statement.length; i++, j++) {
				if (lstTokens[i].equalsIgnoreCase(statement[j])) {
					count++;
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		/*if (count== lstTokens.length) {
			System.out.println("Object Match "+entity +" "+index+" "+type);	
		}*/
	  return count== lstTokens.length? true:false;  
	}
	public boolean hasOwner(String[] statement, int index) {
		return hasAction(statement, index);
	}
	public boolean hasOwned(String[] statement, int index) {
		return hasEntity(statement, index);
	}
}
