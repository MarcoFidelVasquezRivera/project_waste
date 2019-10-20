package model;

public class Product{
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						ATTRIBUTES
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private String identifier;
	private String name;
	private String description;
	private ArrayList<Waste> waste;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						  METHODS
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public Product(String identifier, String name, Steing description){

		this.identifier=identifier;
		this.name=name,
		this.description=description;
		waste=new ArrayList<Waste>(); 

	}//method end


	public String getIdentifier(){
		return identifier;
	}//method end


	public String getName(){
		return name;
	}//method end


	public String getDescription(){
		return description;
	}//method end


	public ArrayList<Waste> getWaste(){
		return waste;
	}//method end


	public void setWaste(AArrayList<Waste> waste){
		this.waste=waste;
	}//method end

}//CLASS END