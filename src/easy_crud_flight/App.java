package easy_crud_flight;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;




public class App {
	
	static Scanner sc = new Scanner(System.in);
	static Scanner sc1 = new Scanner(System.in);
	public static void main(String[] args) {
		
		ArrayList<Vol> c = new ArrayList<Vol>();
		
		
        int ch;  
        do {  
            System.out.println("\n ***Easy CRUD***");  
            System.out.println("1. Crear Vol"+ "\n" + "2. Veure vol" + "\n" + "3. Donar de baixa un vol" + "\n" + "4. Modificar un vol" + "\n" + "5. Exit");  
            System.out.println("------ Selecciona: ------"); 
            
            ch = sc.nextInt();
            switch (ch) {
            // Crear vol
             case 1:
               crearVol(demanaDistancia(), demanaNumeroVol(), demanaCompanyia(), demanaPassatgers(), demanaMotors(), c);
               break;
             // Veure vol
             case 2:
 				System.out.println("Introdueix el Numero de Vol que desitja consultar: ");
 				veureVol(demanaNumeroVol(), c);
            	break; 
             // Donar de baixa Vol       
             case 3: 
	        	System.out.println("Introdueix el Numero de Vol que desitja esborrar: "); 
	        	baixaVol(demanaNumeroVol(), c);
	        	break; 	 
            // Modificar Vol
             case 4:
 				System.out.println("Introdueix el Numero de vol que desitja modificar: ");
 				modificarVol(demanaNumeroVol(), c);
               break;
             // Exit: tanquem el programa
             case 5:  
               System.out.println("Fins aviat!");  
               break;  
                }  
            } 
            while (ch != 5);   
        }
	// Donar d'alta un vol: 
	// Ha de rebre les dades i afegir-lo a l'array
	public static void crearVol(int distancia, int numeroVol, String companyia, int passatgers, int motors, ArrayList<Vol> c) {
		Vol a = new Vol (distancia, numeroVol, companyia, passatgers, motors);
		c.add(a);
	}
	// Baixa vol: 
	/*Ha de rebre el numero de Vol que es vol donar de baixa.
	 Si el vol està dins l'array, l'eliminem i mostrem un missatge
	 En cas contrari avisem que el vol no es troba a la nostra aplicacio*/
	public static void baixaVol(int numeroVol, ArrayList<Vol> c) {
		Iterator<Vol> i = c.iterator();
		boolean troba = false;
		while(i.hasNext()) {
			Vol a = i.next();
			if(a.getNumeroVol() == (numeroVol)) {
				i.remove();
				System.out.println("Esborrat.");
				troba = true;
			}
		}
		if(!troba) {
			System.out.println("El vol no es troba a l'aplicacio.");
		}
	}
	// metode per mostrar informacio
	/*Ha de rebre el numero de vol que es dona de baixa
	 Si el vol està dins l'array, mostrem tots els seus atributs i
	 també cridem calculaPetjadaCarboni()
	 en cas contrari mostrem un missatge amb l'error*/
	public static void veureVol(int numeroVol, ArrayList<Vol> c) {
		boolean troba = false;
		for(Vol a : c) {
			if(a.getNumeroVol() == numeroVol) {
				System.out.println("Distancia: " + a.getDistancia()
	  			 +"\n" +"Numero del vol: " + a.getNumeroVol()
	  			 +"\n" +"Companyia: " + a.getCompanyia()
	  			 +"\n" +"Passatgers: " + a.getPassatgers()
	  			 +"\n" +"Motors: " + a.getMotors()+"\n");
				 a.calculaPetjadaCarboni(); 
				 troba = true;
			}else {
				System.out.println("No es troba a la base de dades.");
			}
		}  
	}
	// metode per modificar
	/*Ha de rebre el numero de vol que es vol modificar
	  Si vol es dins l'array, demanarem quin atribut es vol modificar
	  farem la modificacio pertinent i mostrarem un missatge
	  En cas contrari mostrarem un missatge informatiu */
	public static void modificarVol(int numeroVol, ArrayList<Vol> c) {
		boolean troba = true;
		for(Vol a : c) {
			if(a.getNumeroVol() == numeroVol) {
				System.out.println("Selecciona quin atribut vols modificar: Distancia, Numero de Vol, Companyia, Passatgers o Motors.");
				String atribut = sc.next();
				
				switch (atribut) {
				case "Distancia":
					a.setDistancia(demanaDistancia());
					break;
				case "Numero de vol":
					a.setNumeroVol(demanaNumeroVol());
					break;
				case "Companyia":
					a.setCompanyia(demanaCompanyia());
					break;
				case "Passatgers":
					a.setPassatgers(demanaPassatgers());
					break;
				case "Motors":
					a.setMotors(demanaMotors());
					break;
				}
			}else {
				System.out.println("La teva consulta no es troba a la base de dades");
				troba = false;
			}
		}
	}
	//Demana dades
	static int demanaDistancia() {
		System.out.println("Introdueix una distancia superior a 1000 km: ");
		int distancia = sc.nextInt();
		return distancia;
	}
	static int demanaNumeroVol() {
		System.out.println("Numero de Vol: ");
		int numeroVol = sc.nextInt();
		return numeroVol;
	}
	static String demanaCompanyia() {
		System.out.println("Companyia: ");
		String companyia = sc.next();
		return companyia;
	}
	static int demanaPassatgers() {
		System.out.println("Passatgers: ");
		int passatgers = sc.nextInt();
		return passatgers;
	}
	static int demanaMotors() {
		System.out.println("Motors: ");
		int motors = sc.nextInt();
		return motors;
	}
}
