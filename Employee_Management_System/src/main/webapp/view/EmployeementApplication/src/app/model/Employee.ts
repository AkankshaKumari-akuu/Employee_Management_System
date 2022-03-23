
/*
 * MODEL Class 
 * @AKANKSHA
 */


export class Employee {

	id:  Number ;
	name: String ;
    dateOfJoining: String;
	basicpay:Number ;
	da:Number ;
	hra: Number ;
	gross: Number;
	tax:Number ;
	net: Number;

	constructor(id:number,name: String ,dateOfJoining: String , basicpay:Number , da:Number ,hra: Number ,gross: Number ,tax:Number ,net: Number ) {
	
	this.id = id;
	this.name = name;
	this.dateOfJoining = dateOfJoining;
	this.basicpay = basicpay;
	this.da = da;
	this.hra = hra;
	this.gross = gross;
	this.tax = tax;
	this.net = net;
}

}