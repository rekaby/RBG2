package parser.visual.io;

import java.io.IOException;
import java.util.ArrayList;

import parser.DependencyInstance;
import parser.Options;
import parser.visual.ContextInstance;
import parser.visual.ContextRelation;
import parser.visual.ContextRelationType;


public class BasicVisualReader extends ContextReader {

	public BasicVisualReader(Options options) {
		this.options = options;
	}
	
	@Override
	public ContextInstance nextInstance() throws IOException {
		
	    ArrayList<String[]> lstLines = new ArrayList<String[]>();
	    ContextInstance contextInstance=new ContextInstance();
	    
	    String line = reader.readLine().trim();
	    while (line != null && !line.equals("") && !line.startsWith("*")) {
	    	lstLines.add(line.split("\t"));
	    	line = reader.readLine();
	    }
	    System.out.println("LINE------"+lstLines.size());
	   // if (lstLines.size() == 0) return null;//TODO
	    
	    //int length = lstLines.size();
	    
	    //Object Relation Verb
	    for (int i = 0; i < lstLines.size(); ++i) {
	    	String[] parts = lstLines.get(i);
	    	if (parts.length<3) {//relation should have minimum 3 entities
				continue;
			}
	    	String verb , object;
	    	ContextRelationType relation=null;
	    	ContextRelation contextRelation;
	    	
	    	object = parts[0];
	    	verb = parts[2];
	    	contextRelation=null;// new ContextRelation(verb, object);
	    	for (ContextRelationType type : ContextRelationType.values()) {
	            if (parts[1].equalsIgnoreCase(type.name())) {
	            	if(type!=ContextRelationType.$own$)
	            	{contextRelation= new ContextRelation(verb, object,type);}
	            	else//reverse coz context is written in reverse way for Owner relation
	            	{contextRelation= new ContextRelation( object,verb,type);}
	            	relation=type;
	            	break;
	            }
	          }
	    	addRelation(contextInstance,contextRelation,relation);
	    	
	    }
	    return contextInstance;
	}
	private void addRelation(ContextInstance contextInstance, ContextRelation contextRelation,ContextRelationType relationType)
	{
		
    	
    	if(relationType==ContextRelationType.$Agent$)
    	{
    		contextInstance.addAgentRelation(contextRelation);
    	}
    	if(relationType==ContextRelationType.$Theme$)
    	{
	    	contextInstance.addThemeRelation(contextRelation);
    	}
    	if(relationType==ContextRelationType.$Instrument$)
    	{
	    	contextInstance.addInstrumentRelation(contextRelation);
    	}
    	if(relationType==ContextRelationType.$own$)
    	{
	    	contextInstance.addOwnershipRelation(contextRelation);
    	}
	}

}
