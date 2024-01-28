package br.com.fiap.pos.soat3.lanchonete.infrastructure.integration;

import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@FeignClient(name = "mvp-client", url = "${webhookmock-endpoint}")
@Headers({"Content-Type: application/json", "Accept: application/json"})
public interface MVPFakeClient extends MVPCliente {

    @Override
    default MVPResponse realizaPagamentoMock(Long pedidoId, Long pagamentoId) {
        return new MVPResponse(String.valueOf(Math.abs(new Random(pedidoId).nextInt())),
                "http://webhook-mock:9999/mock/".concat(String.valueOf(pagamentoId)));
    }
}
