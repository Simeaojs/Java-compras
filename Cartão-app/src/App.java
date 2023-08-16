import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        try (Scanner leitura = new Scanner(System.in)) {
            double limite = 0;
            try {
                System.out.println("Digite o limite do cartao de credito: ");
                limite = leitura.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Valor inválido para o limite do cartão. Certifique-se de inserir um número.");
                return;
            }

            CartaoDeCredito cartao = new CartaoDeCredito(limite);

            int sair = 1;
            while (sair != 0) {
                System.out.println("Digite a descricao da compra: ");
                String descricao = leitura.next();

                double valor = 0;
                try {
                    System.out.println("Digite o valor da compra: ");
                    valor = Double.parseDouble(leitura.next());
                } catch (NumberFormatException e) {
                    System.out.println("Valor da compra inválido. Certifique-se de inserir um número válido.");
                    return; 
                }

                Compra compra = null;
                try {
                    compra = new Compra(descricao, valor);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    return;
                }

                boolean compraRealizada = cartao.lancaCompra(compra);

                if (compraRealizada) {
                    System.out.println("Compra realizada com sucesso!");
                    System.out.println("Digite 0 para sair ou 1 para continuar: ");
                    try {
                        sair = leitura.nextInt();
                    } catch (InputMismatchException e) {
                        System.out.println("Opção inválida. Certifique-se de inserir 0 ou 1.");
                        sair = 0;
                    }

                } else {
                    System.out.println("Saldo insuficiente!");
                    sair = 0;
                }
            }

            System.out.println("-----------------------------------------");
            System.out.println(" COMPRA REALIZADA: \n");

            for (Compra c : cartao.getCompras()) {
                System.out.println(c.getDescricao() + " - " + c.getValor());
            }

            System.out.println("\n-----------------------------------------");

            System.out.println("\nSaldo do cartao: " + cartao.getSaldo());
        }
    }
}
