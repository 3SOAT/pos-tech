package br.com.fiap.pos.soat3.lanchonete.infrastructure.config;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.PagamentoGateway;
import br.com.fiap.pos.soat3.lanchonete.application.gateways.RealizaPagamentoMockGateway;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.pagamento.RealizaPagamentoInteractor;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento.PagamentoDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pagamento.PagamentoEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pagamento.PagamentoRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido.PedidoRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.produto.ProdutoRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pagamento.PagamentoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagamentoBeanConfig {

    @Bean
    PagamentoEntityMapper pagamentoEntityMapper() {
        return new PagamentoEntityMapper();
    }

    @Bean
    PagamentoRepositoryGateway pagamentoRepositoryGateway(PagamentoRepository pagamentoRepository,
                                                          PedidoRepositoryGateway pedidoRepositoryGateway,
                                                          ProdutoRepositoryGateway produtoRepositoryGateway,
                                                          PagamentoEntityMapper pagamentoEntityMapper,
                                                          RealizaPagamentoMockGateway realizaPagamentoMockGateway) {
        return new PagamentoRepositoryGateway(pagamentoRepository, pedidoRepositoryGateway, produtoRepositoryGateway, pagamentoEntityMapper, realizaPagamentoMockGateway);
    }

    @Bean
    RealizaPagamentoInteractor realizaPagamentoUseCase(PagamentoGateway pagamentoGateway) {
        return new RealizaPagamentoInteractor(pagamentoGateway);
    }

    @Bean
    PagamentoDTOMapper pagamentoDTOMapper() {
        return new PagamentoDTOMapper();
    }

}
