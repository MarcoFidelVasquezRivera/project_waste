package ui;

import java.util.Scanner;
import model.*;

public class Main{
	public static Scanner reader=new Scanner(System.in);
	public static Scanner readerTwo=new Scanner(System.in);
	public static Scanner readerThree=new Scanner(System.in);
	public static Reciclemos reciclemos;


	public Main(){
		reciclemos= new Reciclemos();
	}//method end

	public static void main(String[]args){
		Main main=new Main();
		String identifier="";
		String name="";
		String origin="";
		String color="";
		int daysDecompositionTime=0;
		boolean suitableComposting=false;
		String type="";
		String descriptionHome="";
		String descriptionIndustry="";
		String tips="";
		String productIdentifier="";
		String productName="";
		String productDescription="";
		int operation=0;
		boolean exit=false;
		String message="";
		main.init();
		
		System.out.println("welcome");
		while(exit==false){

			main.showMenu();
			operation=reader.nextInt();

			while(operation<1 || operation>10){
				System.out.println("please enter a number between 1 and 10");
				operation=reader.nextInt();

			}//loop end


			switch(operation){

				case 1:	main.menuOptionOne();
						break;



				case 2:	main.addProduct();
						break;



				case 3:	System.out.println(main.reciclemos.wasteEnteredReport());
						break;



				case 4: System.out.println("please enter the name of the waste \n");
						name=readerThree.nextLine();
						message=main.reciclemos.lookWasteName(name);
						System.out.println(message);
						break;


				case 5:	System.out.println("please enter the identifier of the product where is saved the waste \n");
						productIdentifier=readerThree.nextLine();
						message=main.reciclemos.lookWasteProduct(productIdentifier);
						System.out.println(message);
						break;



				case 6:	System.out.println(main.reciclemos.productList());
						break;



				case 7:



				case 8:



				case 9:


				case 10: exit=true;



			}//swirch end
		}//loop end

		System.out.println("thank you for your use");
	}//method end

	public void showMenu(){
		System.out.println("\n");
		System.out.println("please enter the option you want to do");
		System.out.println("1:add a new waste");
		System.out.println("2:add a new product and its waste");
		System.out.println("3:show a report about the waste entered");
		System.out.println("4:look information of waste by name");
		System.out.println("5:look intormation of waste by identifier of its product");
		System.out.println("6:show products entered");
		System.out.println("7:calculate harmful effect of a waste");
		System.out.println("8:calculate if a waste is usable");
		System.out.println("9:show waste of product in order by harmful effect");
		System.out.println("10:exit");

	}//method end


	public void menuOptionOne(){
		String identifier="";
		String name="";
		String origin="";
		int originInt=0;
		String color="";
		int daysDecompositionTime=0;
		boolean suitableComposting=false;
		int suitableInt=0;
		String type="";
		int typeInt=0;
		String descriptionHome="";
		String descriptionIndustry="";
		String tips="";
		int operation=0;
		int typeWasteToEnter=0;
		String productName="";
		String productIdentifier="";
		String productDescription="";
		String message="";

		System.out.println("what do you want to do?");
		System.out.println("1:put the waste in a product that already exist");
		System.out.println("2:create a new product and put the waste there");
		operation=reader.nextInt();


		while(operation<1 || operation>2){
			System.out.println("please enter a number between 1 and 2");
			operation=reader.nextInt();
		}//loop end



		System.out.println("please enter the tipe of waste that you will save");
		System.out.println("1:Biodegradable");
		System.out.println("2:Recyclable");
		System.out.println("3:Inert");
		typeWasteToEnter=reader.nextInt();


		while(typeWasteToEnter<1 || typeWasteToEnter>3){
			System.out.println("please enter a number between 1 and 3");
			typeWasteToEnter=reader.nextInt();
		}//loop end


		System.out.println("please enter the name of the waste");
		name=readerThree.nextLine();
		System.out.println("please enter the identifier of the waste");
		identifier=readerTwo.next();
		System.out.println("please enter the color of the waste");
		color=readerTwo.next();
		System.out.println("please enter the days of decomposition of the waste");
		daysDecompositionTime=reader.nextInt();
		System.out.println("please enter the origin of the waste");
		System.out.println("1:industrial\n2:domiciliario\n3:municipal\n4:construccion\n5:hospitalario");
		originInt=reader.nextInt();

		while(originInt<1 || originInt>5){
			System.out.println("please enter a number between 1 and 5");
			originInt=reader.nextInt();
		}//koop end
		switch(originInt){

			case 1:	origin=Waste.INDUSTRIAL;
					break;

			case 2:	origin=Waste.DOMICILIARIO;
					break;

			case 3: origin=Waste.MUNICIPAL;
					break;

			case 4: origin=Waste.CONSTRUCCION;
					break;

			case 5: origin=Waste.HOSPITALARIO;
					break;

		}//switch end


		switch(typeWasteToEnter){


			case 1:	System.out.println("please enter if the waste is suitable to composting");
					System.out.println("1:yes\n2:no");
					suitableInt=reader.nextInt();

					while(suitableInt<1 || suitableInt>2){
						System.out.println("please enter 1 0r 2");
						suitableInt=reader.nextInt();
					}//loop end

					switch(suitableInt){

						case 1:	suitableComposting=true;
								break;

						case 2:	suitableComposting=false;
								break;

					}//switch end
					break;
						


			case 2:	System.out.println("please enter the type of the waste");
					System.out.println("1:papel \n2:carton \n3:vidrio \n4:metal");
					typeInt=reader.nextInt();

					while(typeInt<1 || typeInt>4){
						System.out.println("please enter a number between 1 and 4");
						typeInt=reader.nextInt();
					}//loop end

					switch(typeInt){

						case 1:	type=Recyclable.PAPER;
								break;

						case 2:	type=Recyclable.PAPERBOARD;
								break;

						case 3:	type=Recyclable.GLASS;
								break;

						case 4:	type=Recyclable.METAL;
								break;

					}//switch end


					System.out.println("please enter the description for home of this waste");
					descriptionHome=readerThree.nextLine();
					System.out.println("please enter the description for industry of this waste");
					descriptionIndustry=readerThree.nextLine();
					break;



			case 3:	System.out.println("please enter the tips for the waste");
					tips=readerThree.nextLine();
					break;

		}//switch end




		if(operation==1){
			System.out.println("please enter the name of the product that produces the waste");
			productName=readerThree.nextLine();

			switch(typeWasteToEnter){
				case 1:	message=reciclemos.addWaste(identifier,name,origin,color,daysDecompositionTime,suitableComposting,productName);
						break;

				case 2:	message=reciclemos.addWaste(identifier,name,origin,color,daysDecompositionTime,type,descriptionHome,descriptionIndustry,productName);
						break;

				case 3:	message=reciclemos.addWaste(identifier,name,origin,color,daysDecompositionTime,tips,productName);
						break;

			}//switch end

		}
		else if(operation==2){
			System.out.println("please enter the name of the product");
			productName=readerThree.nextLine();
			System.out.println("please enter the identifier of the product");
			productIdentifier=readerTwo.next();
			System.out.println("please enter the description of the product");
			productDescription=readerThree.nextLine();

			message=reciclemos.addProduct(productIdentifier, productName, productDescription);
			System.out.println(message);
			switch(typeWasteToEnter){
				case 1:	message=reciclemos.addWaste(identifier,name,origin,color,daysDecompositionTime,suitableComposting,productName);
						break;

				case 2:	message=reciclemos.addWaste(identifier,name,origin,color,daysDecompositionTime,type,descriptionHome,descriptionIndustry,productName);
						break;

				case 3:	message=reciclemos.addWaste(identifier,name,origin,color,daysDecompositionTime,tips,productName);
						break;

			}//switch end

		}//conditional end
		System.out.println(message);
	}//method end


	public void addProduct(){
		String identifier="";
		String name="";
		String origin="";
		int originInt=0;
		String color="";
		int daysDecompositionTime=0;
		boolean suitableComposting=false;
		int suitableInt=0;
		String type="";
		int typeInt=0;
		String descriptionHome="";
		String descriptionIndustry="";
		String tips="";
		int operation=0;
		int typeWasteToEnter=0;
		String productName="";
		String productIdentifier="";
		String productDescription="";
		String message="";
		int numberWaste=0;

		System.out.println("please enter the name of the product");
		productName=readerThree.nextLine();
		System.out.println("please enter the identifier of the product");
		productIdentifier=readerTwo.next();
		System.out.println("please enter the description of the product");
		productDescription=readerThree.nextLine();
		reciclemos.addProduct(productIdentifier, productName, productDescription);


		System.out.println("please enter the numbre of waste that you will save in the product");
		numberWaste=reader.nextInt();

		for(int i=0;i<numberWaste;i++){

			System.out.println("please enter the tipe of waste that you will save");
			System.out.println("1:Biodegradable");
			System.out.println("2:Recyclable");
			System.out.println("3:Inert");
			typeWasteToEnter=reader.nextInt();


			while(typeWasteToEnter<1 || typeWasteToEnter>3){
				System.out.println("please enter a number between 1 and 3");
				typeWasteToEnter=reader.nextInt();
			}//loop end


			System.out.println("please enter the name of the waste");
			name=readerThree.nextLine();
			System.out.println("please enter the identifier of the waste");
			identifier=readerTwo.next();
			System.out.println("please enter the color of the waste");
			color=readerTwo.next();
			System.out.println("please enter the days of decomposition of the waste");
			daysDecompositionTime=reader.nextInt();
			System.out.println("please enter the origin of the waste");
			System.out.println("1:industrial\n2:domiciliario\n3:municipal\n4:construccion\n5:hospitalario");
			originInt=reader.nextInt();

			while(originInt<1 || originInt>5){
				System.out.println("please enter a number between 1 and 5");
				originInt=reader.nextInt();
			}//koop end
			switch(originInt){

				case 1:	origin=Waste.INDUSTRIAL;
						break;

				case 2:	origin=Waste.DOMICILIARIO;
						break;

				case 3: origin=Waste.MUNICIPAL;
						break;

				case 4: origin=Waste.CONSTRUCCION;
						break;

				case 5: origin=Waste.HOSPITALARIO;
						break;

			}//switch end


			switch(typeWasteToEnter){


				case 1:	System.out.println("please enter if the waste is suitable to composting");
						System.out.println("1:yes\n2:no");
						suitableInt=reader.nextInt();

						while(suitableInt<1 || suitableInt>2){
							System.out.println("please enter 1 0r 2");
							suitableInt=reader.nextInt();
						}//loop end

						switch(suitableInt){

							case 1:	suitableComposting=true;
									break;

							case 2:	suitableComposting=false;
									break;

						}//switch end

						message=reciclemos.addWaste(identifier,name,origin,color,daysDecompositionTime,suitableComposting,productName);
						break;
							


				case 2:	System.out.println("please enter the type of the waste");
						System.out.println("1:papel \n2:carton \n3:vidrio \n4:metal");
						typeInt=reader.nextInt();

						while(typeInt<1 || typeInt>4){
							System.out.println("please enter a number between 1 and 4");
							typeInt=reader.nextInt();
						}//loop end

						switch(typeInt){

							case 1:	type=Recyclable.PAPER;
									break;

							case 2:	type=Recyclable.PAPERBOARD;
									break;

							case 3:	type=Recyclable.GLASS;
									break;

							case 4:	type=Recyclable.METAL;
									break;

						}//switch end


						System.out.println("please enter the description for home of this waste");
						descriptionHome=readerThree.nextLine();
						System.out.println("please enter the description for industry of this waste");
						descriptionIndustry=readerThree.nextLine();

						message=reciclemos.addWaste(identifier,name,origin,color,daysDecompositionTime,type,descriptionHome,descriptionIndustry,productName);
						break;



				case 3:	System.out.println("please enter the tips for the waste");
						tips=readerThree.nextLine();

						message=reciclemos.addWaste(identifier,name,origin,color,daysDecompositionTime,tips,productName);
						break;

			}//switch end

			System.out.println(message);
		}//loop end

	}//method end


	public void init(){

		reciclemos.addProduct("1104253","banano","fruta");
		reciclemos.addWaste("1347734","cascara de banano",Waste.DOMICILIARIO,"amarillo",13,true,"banano");

	}//mehtod end


}//CLASS END
