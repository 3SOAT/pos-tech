package br.com.fiap.pos.soat3.lanchonete.adapter.outbound.integration;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class MVPFakeClient implements MVPCliente{
    @Override
    public String realizaPagamentoMock(Long pedidoId) {
        return String.valueOf(Math.abs(new Random(pedidoId).nextInt()));
    }
}
