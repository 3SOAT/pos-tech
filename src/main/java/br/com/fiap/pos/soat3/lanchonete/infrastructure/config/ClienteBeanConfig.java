package br.com.fiap.pos.soat3.lanchonete.infrastructure.config;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.cliente.BuscaClientePorCPFInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.cliente.CadastraClienteInteractor;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.cliente.ClienteDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.cliente.ClienteEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.cliente.ClienteRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.cliente.ClienteRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClienteBeanConfig {

    @Bean
    ClienteEntityMapper clienteEntityMapper() {
        return new ClienteEntityMapper();
    }

    @Bean
    ClienteGateway clienteGateway(ClienteRepository clienteRepository, ClienteEntityMapper clienteEntityMapper) {
        return new ClienteRepositoryGateway(clienteRepository, clienteEntityMapper);
    }

    @Bean
    CadastraClienteInteractor cadastraClienteUseCase(ClienteGateway clienteGateway) {
        return new CadastraClienteInteractor(clienteGateway);
    }

    @Bean
    BuscaClientePorCPFInteractor buscaClientePorCPFUseCase(ClienteGateway clienteGateway) {
        return new BuscaClientePorCPFInteractor(clienteGateway);
    }

    @Bean
    ClienteDTOMapper clienteDTOMapper() {
        return new ClienteDTOMapper();
    }
}
