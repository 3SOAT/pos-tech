package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria;

import br.com.fiap.pos.soat3.lanchonete.application.usecases.categoria.CadastraCategoriaInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    private final CadastraCategoriaInteractor cadastraCategoriaUseCase;
    private final CategoriaDTOMapper categoriaDTOMapper;

    public CategoriaController(CadastraCategoriaInteractor cadastraCategoriaUseCase,
                               CategoriaDTOMapper categoriaDTOMapper) {
        this.cadastraCategoriaUseCase = cadastraCategoriaUseCase;
        this.categoriaDTOMapper = categoriaDTOMapper;
    }

    @PostMapping
    public CategoriaResponse criaCategoria(@Valid @RequestBody CategoriaRequest request) {
        Categoria categoriaBussinessObj = categoriaDTOMapper.toCategoria(request);
        Categoria categoria = cadastraCategoriaUseCase.cadastraCategoria(categoriaBussinessObj);
        return categoriaDTOMapper.toResponse(categoria);
    }

}
