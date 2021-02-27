package view;
import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {
	public static void main (String args[]) {
		int escolha = 5;
		RedesController RedCon = new RedesController();
		String so = System.getProperty("os.name");
		
		Object [] opc = {"IP","Ping"};
		while (escolha == 5) {
			escolha = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Opções",0, JOptionPane.DEFAULT_OPTION,null, opc, opc[0]);
			if (escolha == 0) {
				RedCon.ip(so);
			}
			else if (escolha == 1) {
				RedCon.ping(so);
			}
		}
		
	}
}	
