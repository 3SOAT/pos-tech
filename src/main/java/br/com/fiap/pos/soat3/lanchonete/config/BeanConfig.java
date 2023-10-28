package br.com.fiap.pos.soat3.lanchonete.config;

import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.ListaPedidosAdapter;
import br.com.fiap.pos.soat3.lanchonete.adapter.outbound.repository.pedido.PedidoRepository;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pagamento.RealizaPagamentoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.ListaPedidosUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pedido.SalvaPedidoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.RecuperaProdutoPorCategoriaUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.cliente.BuscaClientePorCPFUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.cliente.CadastraClienteUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.AtualizaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.CriaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.DeletaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.produto.RecuperaProdutoUseCasePort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.RealizaPagamentoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pagamento.RealizaPagamentoMockPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.pedido.ListaPedidosAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.RecuperaProdutoPorCategoriaAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.categoria.RecuperaCategoriaAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.cliente.BuscaClientePorCPFAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.cliente.SalvaClienteAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.AtualizaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.DeletaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.RecuperaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.ports.outbound.produto.SalvaProdutoAdapterPort;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pagamento.RealizaPagamentoUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.pedido.ListaPedidosUseCase;
import br.com.fiap.pos.soat3.lanchonete.domain.usecase.produto.RecuperaProdutosPorCategoriaUseCase;
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
    public CriaProdutoUseCasePort criaProdutoUseCase(SalvaProdutoAdapterPort salvaProdutoAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort) {
        return new CriaProdutoUseCase(salvaProdutoAdapterPort, recuperaCategoriaAdapterPort);
    }

    @Bean
    public AtualizaProdutoUseCasePort atualizaProdutoUseCase(AtualizaProdutoAdapterPort atualizaProdutoAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort) {
        return new AtualizaProdutoUseCase(atualizaProdutoAdapterPort, recuperaCategoriaAdapterPort);
    }

    @Bean
    public DeletaProdutoUseCasePort deletaProdutoAdapterPort(DeletaProdutoAdapterPort deletaProdutoAdapterPort) {
        return new DeletaProdutoUseCase(deletaProdutoAdapterPort);
    }

    @Bean
    public RecuperaProdutoUseCasePort recuperaProdutoUseCase(RecuperaProdutoAdapterPort recuperaProdutoAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort) {
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


    @Bean
    public RecuperaProdutoPorCategoriaUseCasePort recuperaProdutoPorCategoriaUseCase(RecuperaProdutoPorCategoriaAdapterPort recuperaProdutoPorCategoriaAdapterPort, RecuperaCategoriaAdapterPort recuperaCategoriaAdapterPort) {
        return new RecuperaProdutosPorCategoriaUseCase(recuperaProdutoPorCategoriaAdapterPort, recuperaCategoriaAdapterPort);
    }

    @Bean
    public RealizaPagamentoUseCasePort realizaPagamentoUseCase(RealizaPagamentoAdapterPort realizaPagamentoAdapterPort, SalvaPedidoAdapterPort salvaPedidoAdapterPort, RealizaPagamentoMockPort realizaPagamentoMockPort) {
        return new RealizaPagamentoUseCase(realizaPagamentoAdapterPort, salvaPedidoAdapterPort, realizaPagamentoMockPort);
    }

    @Bean
    public ListaPedidosUseCasePort listaPedidosUseCase(ListaPedidosAdapterPort listaPedidosAdapterPort) {
        return new ListaPedidosUseCase(listaPedidosAdapterPort);
    }

    @Bean
    public ListaPedidosAdapterPort listaPedidosAdapter(PedidoRepository pedidoRepository) {
        return new ListaPedidosAdapter(pedidoRepository);
    }
}
