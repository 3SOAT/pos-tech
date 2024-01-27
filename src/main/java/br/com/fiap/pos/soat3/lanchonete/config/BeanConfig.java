package br.com.fiap.pos.soat3.lanchonete.config;

import br.com.fiap.pos.soat3.lanchonete.application.gateways.CategoriaGateway;
import br.com.fiap.pos.soat3.lanchonete.application.gateways.ClienteGateway;
import br.com.fiap.pos.soat3.lanchonete.application.gateways.ProdutoGateway;
import br.com.fiap.pos.soat3.lanchonete.application.usecases.*;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria.CategoriaDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.cliente.ClienteDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.produto.ProdutoDTOMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.categoria.CategoriaEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.categoria.CategoriaRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.cliente.ClienteEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.cliente.ClienteRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.produto.ProdutoEntityMapper;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.gateways.produto.ProdutoRepositoryGateway;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.categoria.CategoriaRepository;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.cliente.ClienteRepository;
import br.com.fiap.pos.soat3.lanchonete.infrastructure.persistence.produto.ProdutoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    CriaProdutoInteractor criaProdutoUseCase(ProdutoGateway produtoGateway){
        return new CriaProdutoInteractor(produtoGateway);
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
    CriaCategoriaInteractor criaCategoriaUseCase(CategoriaGateway categoriaGateway){
        return new CriaCategoriaInteractor(categoriaGateway);
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
    CriaClienteInteractor criaClienteUseCase(ClienteGateway clienteGateway){
        return new CriaClienteInteractor(clienteGateway);
    }
    @Bean
    BuscaClientePorCPFInteractor buscaClientePorCPFUseCase(ClienteGateway clienteGateway){
        return new BuscaClientePorCPFInteractor(clienteGateway);
    }

    @Bean
    ClienteDTOMapper clienteDTOMapper() {
        return new ClienteDTOMapper();
    }
}
