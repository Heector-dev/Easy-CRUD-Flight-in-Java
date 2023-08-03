package easy_crud_flight;


import java.util.Scanner;


public class Vol {
	
	
	
	//Atributs
	public int distancia;
	public int numeroVol;
	public String companyia;
	public int passatgers;
	public int motors;
	public float co2_emes;
	
	// constructor complet amb tots els parametres
	public Vol(int distancia, int numeroVol, String companyia , int passatgers, int motors) {
		this.distancia = distancia;
		this.numeroVol = numeroVol;
		this.companyia = companyia;
		this.passatgers = passatgers;
		this.motors = motors;
	}
	
	// no serveix de res posar un constructor buit
	// constructor sin argumentos
	public Vol() {
		
	}
	
	
	Scanner sc = new Scanner(System.in);
	Scanner sc1 = new Scanner(System.in);
	

	public void calculaPetjadaCarboni() {
	   float co2 = 0.1f * distancia;
	   co2_emes = co2 * motors;
	   System.out.println("CO2 emes: " + co2_emes);
    }
	
	// getters i setters
	public float getDistancia() {
		return distancia;
	}
	
	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}
	
	public int getNumeroVol() {
		return numeroVol;
	}
	
	public void setNumeroVol(int numeroVol) {
		this.numeroVol = numeroVol;
	}
	
	public String getCompanyia() {
		return companyia;
	}
	
	public void setCompanyia(String companyia) {
		this.companyia = companyia;
	}
	
	public int getPassatgers() {
		return passatgers;
	}
	
	public void setPassatgers(int passatgers) {
		this.passatgers = passatgers;
	}
	
	public int getMotors() {
		return motors;
	}
	
	public void setMotors(int motors) {
		this.motors = motors;
	}
	
	public float getCo2_emes() {
		return co2_emes;
	}
	
	public void setCo2_emes(float co2_emes) {
		this.co2_emes = co2_emes;
	}
}