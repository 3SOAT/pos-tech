package br.com.fiap.pos.soat3.lanchonete.config;

import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.AtualizaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.CriaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.DeletaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.RecuperaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.RecuperaProdutoPorCategoriaUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.AtualizaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.DeletaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RecuperaCategoriaAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RecuperaProdutoPorCategoriaAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.RecuperaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.SalvaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.AtualizaProdutoUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.CriaProdutoUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.DeletaProdutoUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.RecuperaProdutoUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.RecuperaProdutosPorCategoriaUseCase;
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
    public RecuperaProdutoPorCategoriaUseCasePort recuperaProdutoPorCategoriaUseCase(RecuperaProdutoPorCategoriaAdapterPort recuperaProdutoPorCategoriaAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort){
        return new RecuperaProdutosPorCategoriaUseCase(recuperaProdutoPorCategoriaAdapterPort, recuperaCategoriaAdapterPort);
    }
}
