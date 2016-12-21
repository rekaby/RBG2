package parser.visual;

import java.util.ArrayList;
import java.util.List;

public class ContextInstance {

	List<ContextRelation> agentRelations= new ArrayList<ContextRelation>();
	List<ContextRelation> themeRelations= new ArrayList<ContextRelation>();
	List<ContextRelation> instrumentRelations= new ArrayList<ContextRelation>();
	List<ContextRelation> ownershipRelations= new ArrayList<ContextRelation>();
	public void addAgentRelation(ContextRelation relation)
	{
		agentRelations.add(relation);
	}
	public void addThemeRelation(ContextRelation relation)
	{
		themeRelations.add(relation);
	}
	public void addInstrumentRelation(ContextRelation relation)
	{
		instrumentRelations.add(relation);
	}
	public void addOwnershipRelation(ContextRelation relation)
	{
		ownershipRelations.add(relation);
	}
	public List<ContextRelation> getAgentRelations() {
		return agentRelations;
	}
	public void setAgentRelations(List<ContextRelation> agentRelations) {
		this.agentRelations = agentRelations;
	}
	public List<ContextRelation> getThemeRelations() {
		return themeRelations;
	}
	public void setThemeRelations(List<ContextRelation> themeRelations) {
		this.themeRelations = themeRelations;
	}
	public List<ContextRelation> getInstrumentRelations() {
		return instrumentRelations;
	}
	public void setInstrumentRelations(List<ContextRelation> instrumentRelations) {
		this.instrumentRelations = instrumentRelations;
	}
	public List<ContextRelation> getOwnershipRelations() {
		return ownershipRelations;
	}
	public void setOwnershipRelations(List<ContextRelation> ownershipRelations) {
		this.ownershipRelations = ownershipRelations;
	}
	
	
}
