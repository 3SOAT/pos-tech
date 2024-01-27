package br.com.fiap.pos.soat3.lanchonete.infrastructure.controllers.categoria;

import br.com.fiap.pos.soat3.lanchonete.application.usecases.CriaCategoriaInteractor;
import br.com.fiap.pos.soat3.lanchonete.domain.entity.Categoria;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("categoria")
public class CategoriaController {

    private final CriaCategoriaInteractor criaCategoriaUseCase;
    private final CategoriaDTOMapper categoriaDTOMapper;

    public CategoriaController(CriaCategoriaInteractor criaCategoriaUseCase,
                               CategoriaDTOMapper categoriaDTOMapper) {
        this.criaCategoriaUseCase = criaCategoriaUseCase;
        this.categoriaDTOMapper = categoriaDTOMapper;
    }

    @PostMapping
    public CategoriaResponse createUser(@Valid @RequestBody CategoriaRequest request) {
        Categoria categoriaBussinessObj = categoriaDTOMapper.toCategoria(request);
        Categoria categoria = criaCategoriaUseCase.criaCategoria(categoriaBussinessObj);
        return categoriaDTOMapper.toResponse(categoria);
    }

}
