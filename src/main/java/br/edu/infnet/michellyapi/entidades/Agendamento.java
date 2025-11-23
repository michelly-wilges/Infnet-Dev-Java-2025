package br.edu.infnet.michellyapi.entidades;

import br.edu.infnet.michellyapi.enums.FormaPagamento;
import br.edu.infnet.michellyapi.enums.StatusAgendamento;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Agendamento {

    private Long id;
    private Cliente cliente;
    private Funcionario funcionario;
    private Servico servico;
    private LocalDateTime dataHora;
    private FormaPagamento pagamento;
    private StatusAgendamento status;
    private static Long contadorId = 1L;

    public Agendamento() {
        this.id = contadorId++;
    }

    public Agendamento(Cliente cliente, Funcionario funcionario, Servico servico) {
        this();
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.servico = servico;
        this.status = StatusAgendamento.PENDENTE;
    }

    public Agendamento(Cliente cliente, Funcionario funcionario, Servico servico,
                       LocalDateTime dataHora, FormaPagamento pagamento) {
        this(cliente, funcionario, servico);
        this.dataHora = dataHora;
        this.pagamento = pagamento;
    }

    public double calcularValorTotal() {
        return servico.getValorServico();
    }

    public double calcularValorTotal(double percentualDesconto) {
        double valor = servico.getValorServico();
        return valor - (valor * percentualDesconto / 100);
    }

    public void confirmar() {
        if (this.status == StatusAgendamento.PENDENTE) {
            this.status = StatusAgendamento.CONFIRMADO;
            System.out.println("Agendamento confirmado!");
        } else {
            System.out.println("Agendamento não pode ser confirmado. Status atual: " + status);
        }
    }

    public void cancelar() {
        this.status = StatusAgendamento.CANCELADO;
        System.out.println("Agendamento cancelado!");
    }

    public boolean estaPendente() {
        return this.status == StatusAgendamento.PENDENTE;
    }

    public boolean estaConfirmado() {
        return this.status == StatusAgendamento.CONFIRMADO;
    }

    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        if (dataHora.isBefore(LocalDateTime.now())) {
            System.out.println("ATENÇÃO: Não é possível agendar para datas passadas!");
            return;
        }
        this.dataHora = dataHora;
    }

    public FormaPagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(FormaPagamento pagamento) {
        this.pagamento = pagamento;
    }

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return "======================================================\n" +
                                      "AGENDAMENTO " + id + "\n" +
                "======================================================\n" +
                "Cliente: " + cliente.getNomeCliente() + "\n" +
                "Funcionário: " + funcionario.getNomeFuncionario() + "\n" +
                "Serviço: " + servico.getNomeServico() + "\n" +
                "Data/Hora: " + (dataHora != null ? dataHora.format(formatter) : "A definir") + "\n" +
                "Valor: R$ " + String.format("%.2f", calcularValorTotal()) + "\n" +
                "Pagamento: " + (pagamento != null ? pagamento : "A definir") + "\n" +
                "Status: " + status + "\n" +
                "======================================================";
    }
}
