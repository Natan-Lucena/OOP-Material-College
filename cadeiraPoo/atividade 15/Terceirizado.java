public class Terceirizado extends Empregado {
    private Double despesaAdicional;

    
    public Terceirizado(String nome, Integer horas, 
        Double valorPorHora, Double despesaAdicional) 
    {
        setNome(nome);
        setHoras(horas);
        setValorPorHora(valorPorHora);
        setDespesaAdicional(despesaAdicional);
    }

    public Double getDespesaAdicional() {
        return despesaAdicional;
    }

    public void setDespesaAdicional(Double despesaAdicional) {
        this.despesaAdicional = despesaAdicional;
    }

    @Override
    public Double pagamento() {
        return (getValorPorHora() * getHoras()) + (1.1 * this.despesaAdicional);
    }

    @Override
    public String toString() {
        return super.toString() + ", Despesa adicional: " + despesaAdicional;
    }
}