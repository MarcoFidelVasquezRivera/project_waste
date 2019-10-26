package model;

public class Inert extends Waste{
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						ATTRIBUTES
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private String tips;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						 METHODS
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	public Inert(String identifier, String name, String origin, String color, int daysDecompositionTime, String tips){
		
		super(identifier,name,origin,color,daysDecompositionTime);
		this.tips=tips;

	}//method end


	public String getTips(){
		return tips;
	}//method end


	public double getHarmfulFactor(){
		double harmfulFactor=0;

		if(getOrigin().equalsIgnoreCase("industrial")){
			
			harmfulFactor=0.1;
		}
		else if(getOrigin().equalsIgnoreCase("dimiciliario")){
			
			harmfulFactor=0.05;
		}
		else if(getOrigin().equalsIgnoreCase("municipal")){
			
			harmfulFactor=0.12;
		}
		else if(getOrigin().equalsIgnoreCase("construccion")){
			
			harmfulFactor=0.08;
		}
		else if(getOrigin().equalsIgnoreCase("hospitalario")){

			harmfulFactor=0.15;
		}//condiotional end

		return harmfulFactor;
	}//method end


	public String getUsableWaste(){

		return "this waste is inert, cant not be usable";
	}//method end


	@Override
	public String toString(){
		return super.toString()+"\nTips: "+tips;
	}

}//CLASS END