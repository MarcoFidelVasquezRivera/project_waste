package model;

public class Biodegradable extends Waste{
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						ATTRIBUTES
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private boolean suitableComposting;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						 METHODS
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public Biodegradable(String identifier, String name, String origin, String color, int daysDecompositionTime, boolean suitableComposting){
		
		super(identifier,name,origin,color,daysDecompositionTime);
		this.suitableComposting=suitableComposting;

	}//method end


	public boolean getSuitableComposting(){
		return suitableComposting;
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

		if(getSuitableComposting()==true){
			harmfulFactor=harmfulFactor-0.01;

		}//conditionale end

		return harmfulFactor;
	}//method end


	public String getUsableWaste(){
		String message="";

		if(getDaysDecompositionTime()<365 && suitableComposting==true){

			message="this waste is usable";
		}
		else{
			message="this waste is not usable";
		}

		return message;
	}//method end


	@Override
	public String toString(){
		return super.toString()+"\nSuitable composting: "+String.valueOf(suitableComposting);
	}//method end

}//CLASS END