package br.edu.infnet.michellyapi.entidades;

public class Funcionario {
    private String nomeFuncionario;
    private String telefoneFuncionario;
    private String cargoFuncionario;
    private Integer comissaoFuncionario;

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public String getCargoFuncionario() {
        return cargoFuncionario;
    }

    public Integer getComissaoFuncionario() {
        return comissaoFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }

    public void setCargoFuncionario(String cargoFuncionario) {
        this.cargoFuncionario = cargoFuncionario;
    }

    public void setComissaoFuncionario(Integer comissaoFuncionario) {
        this.comissaoFuncionario = comissaoFuncionario;
    }
}
