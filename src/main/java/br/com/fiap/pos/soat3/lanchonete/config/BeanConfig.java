package br.com.fiap.pos.soat3.lanchonete.config;

import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.cliente.BuscaClientePorCPFUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.cliente.CadastraClienteUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.AtualizaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.CriaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.DeletaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.RecuperaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.categoria.RecuperaCategoriaAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.cliente.BuscaClientePorCPFAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.cliente.SalvaClienteAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.AtualizaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.DeletaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.RecuperaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.SalvaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.cliente.BuscaClientePorCPFUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.cliente.CadastraClienteUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.produto.AtualizaProdutoUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.produto.CriaProdutoUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.produto.DeletaProdutoUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.produto.RecuperaProdutoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CriaProdutoUseCasePort criaProdutoUseCase(SalvaProdutoAdapterPort salvaProdutoAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort){
        return new CriaProdutoUseCase(salvaProdutoAdapterPort, recuperaCategoriaAdapterPort);
    }

    @Bean
    public AtualizaProdutoUseCasePort atualizaProdutoUseCase(AtualizaProdutoAdapterPort atualizaProdutoAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort){
        return new AtualizaProdutoUseCase(atualizaProdutoAdapterPort, recuperaCategoriaAdapterPort);
    }

    @Bean
    public DeletaProdutoUseCasePort deletaProdutoAdapterPort(DeletaProdutoAdapterPort deletaProdutoAdapterPort){
        return new DeletaProdutoUseCase(deletaProdutoAdapterPort);
    }
    
    @Bean
    public RecuperaProdutoUseCasePort recuperaProdutoUseCase(RecuperaProdutoAdapterPort recuperaProdutoAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort){
        return new RecuperaProdutoUseCase(recuperaProdutoAdapterPort, recuperaCategoriaAdapterPort);
    }

    @Bean
    public CadastraClienteUseCasePort cadastraClienteUseCase(SalvaClienteAdapterPort salvaClienteAdapterPort) {
        return new CadastraClienteUseCase(salvaClienteAdapterPort);
    }

    @Bean
    public BuscaClientePorCPFUseCasePort buscaClientePorCPFUseCase(BuscaClientePorCPFAdapterPort buscaClientePorCPFAdapterPort) {
        return new BuscaClientePorCPFUseCase(buscaClientePorCPFAdapterPort);
    }
    
}
