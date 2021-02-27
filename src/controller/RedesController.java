package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public void ip(String so) {
		if (so.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec("ipconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					if (linha.contains("Adaptador")) {
						String Adaptador = linha;
						linha = buffer.readLine();
						try{
							while (!linha.contains("Adaptador")){
								if (linha.contains("IPv4")) {
									String[] IPv4 = linha.split(":");
									System.out.println(Adaptador + " : " +IPv4[1]);
									linha = buffer.readLine();
								}
								else {
									linha = buffer.readLine();
								}
							}
						}
						catch(java.lang.NullPointerException e) {
							linha = buffer.readLine();
						}
					}	
					else {
						linha = buffer.readLine();
					}
				}
				buffer.close();
				leitor.close();
				fluxo.close();	
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		else if (so.contains("Linux")) {
			try {
				Process p = Runtime.getRuntime().exec("ifconfig");
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					if (linha.contains("Adaptador")) {
						String Adaptador = linha;
						try{
							while (!linha.contains("Adaptador")){
								if (linha.contains("IPv4")) {
									String[] IPv4 = linha.split(":");
									System.out.println(Adaptador + " : " +IPv4[1]);
								}
								linha = buffer.readLine();
							}
						}
						catch(java.lang.NullPointerException e) {
							linha = buffer.readLine();
						}
					}	
					linha = buffer.readLine();
				}
				buffer.close();
				leitor.close();
				fluxo.close();	
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void ping(String so) {
		if (so.contains("Windows")) {
			String comando = ("ping -4 -n 10 www.uol.com.br");
			try {
				Process p = Runtime.getRuntime().exec(comando);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					if (linha.contains("dia")) {
						String[] Fim = linha.split(",");
						String[] Media = Fim[2].split("=");
						System.out.print(comando + ": Media " + Media[1]);
						linha = buffer.readLine();
					}
					else {
						linha = buffer.readLine();
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(so.contains("Linux")) {
			String comando = ("ping -4 -c 10 www.uol.com.br");
			try {
				Process p = Runtime.getRuntime().exec(comando);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while(linha != null) {
					if (linha.contains("dia")) {
						String[] Fim = linha.split(",");
						String[] Media = Fim[2].split("=");
						System.out.print(comando + ": Media " + Media[1]);
						linha = buffer.readLine();
					}
					else {
						linha = buffer.readLine();
					}
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}