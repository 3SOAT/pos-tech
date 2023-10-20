package br.com.fiap.pos.soat3.lanchonete.domain.usecase;

import br.com.fiap.pos.soat3.lanchonete.domain.domain.Cliente;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.BuscaClientePorCPFUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.BuscaClientePorCPFAdapterPort;

public class BuscaClientePorCPFUseCase implements BuscaClientePorCPFUseCasePort {

    private final BuscaClientePorCPFAdapterPort buscaClientePorCPFAdapterPort;

    public BuscaClientePorCPFUseCase(BuscaClientePorCPFAdapterPort buscaClientePorCPFAdapterPort) {
        this.buscaClientePorCPFAdapterPort = buscaClientePorCPFAdapterPort;
    }

    @Override
    public Cliente execute(String cpf) {
        return buscaClientePorCPFAdapterPort.buscaCliente(cpf);
    }
}
