/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grupsfils;

/**
 *
 * @author kevmar
 */
public class GrupsFils {

	public static void main(String[] args) {
		
		ThreadGroup sg = new ThreadGroup("subgrup 1");
		
		Thread fil1 = new Thread(sg, "Fil 1");
		Thread fil2 = new Thread(sg, "Fil 2");

		sg = new ThreadGroup("subgrup 2");
		
		Thread fil3 = new Thread(sg, "Fil 1_1");

		sg = Thread.currentThread().getThreadGroup();
		
		int agc = sg.activeGroupCount();
		System.out.println("Grup de fil actiu " + sg.getName() + ". Grups actius: " + agc);
		
		sg.list();

	}
	
}