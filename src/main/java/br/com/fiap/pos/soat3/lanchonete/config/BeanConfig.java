package br.com.fiap.pos.soat3.lanchonete.config;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.*;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.categoria.CadastraCategoriaInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.cliente.BuscaClientePorCPFInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.cliente.CadastraClienteInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.pagamento.RealizaPagamentoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.AlteraProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.BuscaPorCategoriaInteractor;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.produto.CadastraProdutoInteractor;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria.CategoriaDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.cliente.ClienteDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.pagamento.PagamentoDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.ProdutoDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.categoria.CategoriaEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.categoria.CategoriaRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.cliente.ClienteEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.cliente.ClienteRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pagamento.PagamentoEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pagamento.PagamentoRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido.PedidoEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.pedido.PedidoRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.produto.ProdutoEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.produto.ProdutoRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.categoria.CategoriaRepository;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.cliente.ClienteRepository;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pagamento.PagamentoRepository;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.pedido.PedidoRepository;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.produto.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    CadastraProdutoInteractor cadastraProdutoUseCase(ProdutoGateway produtoGateway){
        return new CadastraProdutoInteractor(produtoGateway);
    }

    @Bean
    AlteraProdutoInteractor alteraProdutoUseCase(ProdutoGateway produtoGateway){
        return new AlteraProdutoInteractor(produtoGateway);
    }

    @Bean
    CategoriaEntityMapper categoriaEntityMapper() {
        return new CategoriaEntityMapper();
    }

    @Bean
    CategoriaGateway categoriaGateway(CategoriaRepository categoriaRepository, CategoriaEntityMapper categoriaEntityMapper) {
        return new CategoriaRepositoryGateway(categoriaRepository, categoriaEntityMapper);
    }
    @Bean
    CadastraCategoriaInteractor cadastraCategoriaUseCase(CategoriaGateway categoriaGateway){
        return new CadastraCategoriaInteractor(categoriaGateway);
    }

    @Bean
    CategoriaDTOMapper userDTOMapper() {
        return new CategoriaDTOMapper();
    }

    @Bean
    ProdutoEntityMapper produtoEntityMapper() {
        return new ProdutoEntityMapper();
    }

    @Bean
    ProdutoGateway produtoGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper) {
        return new ProdutoRepositoryGateway(produtoRepository, produtoEntityMapper);
    }
    @Bean
    BuscaPorCategoriaInteractor buscaPorCategoriaUseCase(ProdutoGateway produtoGateway){
        return new BuscaPorCategoriaInteractor(produtoGateway);
    }

    @Bean
    ProdutoDTOMapper produtoDTOMapper() {
        return new ProdutoDTOMapper();
    }

    @Bean
    ClienteEntityMapper clienteEntityMapper() {
        return new ClienteEntityMapper();
    }

    @Bean
    ClienteGateway clienteGateway(ClienteRepository clienteRepository, ClienteEntityMapper clienteEntityMapper) {
        return new ClienteRepositoryGateway(clienteRepository, clienteEntityMapper);
    }
    @Bean
    CadastraClienteInteractor cadastraClienteUseCase(ClienteGateway clienteGateway){
        return new CadastraClienteInteractor(clienteGateway);
    }
    @Bean
    BuscaClientePorCPFInteractor buscaClientePorCPFUseCase(ClienteGateway clienteGateway){
        return new BuscaClientePorCPFInteractor(clienteGateway);
    }

    @Bean
    ClienteDTOMapper clienteDTOMapper() {
        return new ClienteDTOMapper();
    }

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
    ProdutoRepositoryGateway produtoRepositoryGateway(ProdutoRepository produtoRepository, ProdutoEntityMapper produtoEntityMapper) {
        return new ProdutoRepositoryGateway(produtoRepository, produtoEntityMapper);
    }

    @Bean
    PedidoEntityMapper pedidoEntityMapper() {
        return new PedidoEntityMapper();
    }

    @Bean
    PedidoRepositoryGateway pedidoRepositoryGateway(PedidoRepository pedidoRepository, PedidoEntityMapper pedidoEntityMapper) {
        return new PedidoRepositoryGateway(pedidoRepository, pedidoEntityMapper);
    }
    @Bean
    RealizaPagamentoInteractor realizaPagamentoUseCase(PagamentoGateway pagamentoGateway){
        return new RealizaPagamentoInteractor(pagamentoGateway);
    }

    @Bean
    PagamentoDTOMapper pagamentoDTOMapper() {
        return new PagamentoDTOMapper();
    }
}
