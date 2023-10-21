package br.com.fiap.pos.soat3.lanchonete.config;

import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.*;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.*;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.*;
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
