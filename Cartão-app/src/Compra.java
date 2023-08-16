class Compra implements Comparable<Compra> {

    private String descricao;
    private double valor;

    public Compra(String descricao, double valor) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição da compra inválida.");
        }

        if (valor <= 0) {
            throw new IllegalArgumentException("Valor da compra deve ser maior que zero.");
        }

        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Compra descricao = " + descricao + ", valor = " + valor + " R$";
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return Double.compare(this.valor, outraCompra.valor);
    }
}