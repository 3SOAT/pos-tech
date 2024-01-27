package br.com.fiap.pos.soat3.lanchonete.domain.ports.inbound.pagamento;

public interface EnviaConfirmacaoUseCasePort {
    
    void execute(Long pedidoId, Long pagamentoId);
}
