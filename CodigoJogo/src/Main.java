import Controler.Tela;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Tela tTela = new Tela();
                tTela.createBufferStrategy(3);
                tTela.setLocationRelativeTo(null);
                tTela.setVisible(true);
                tTela.go();
            }
        });
    }
}
