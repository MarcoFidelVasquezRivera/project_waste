package model;
import java.util.ArrayList;

public class Product{
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						ATTRIBUTES
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	private String identifier;
	private String name;
	private String description;
	private ArrayList<Waste> produces;
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//						  METHODS
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	public Product(String identifier, String name, String description){

		this.identifier=identifier;
		this.name=name;
		this.description=description; 
		produces=new ArrayList<Waste>();

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


	public void addWaste(Waste waste){
		produces.add(waste);//añade un elemento al arreglo de residuos
	}//methor end


	public ArrayList<Waste> getWaste(){
		return produces;
	}//method end

/**
*<b>Name:</b> getReport.<br>
*this method generate a report of the product.<br>
*@return String whit a message with the information of the product.<br>
*/
	public String getReport(){

		return " "+getName()+"(identifier - "+getIdentifier()+"- description - "+getDescription()+")";
	}//mwthod end

/**
*<b>Name:</b> toString.<br>
*this method return the information of the waste.<br>
*@return String whit a message with the information of the product.<br>
*/
	public String toString(){
		return "Name: "+name+"\nIdentifier: "+identifier+"\nDescription: "+description;
	}

}//CLASS END