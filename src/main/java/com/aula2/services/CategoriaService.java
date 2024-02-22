package com.aula2.services;

import com.aula2.domain.Categoria;
import com.aula2.domain.Produto;
import com.aula2.repositories.CategoriaRepository;
import com.aula2.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository repo;

    public Categoria find(Integer id) {
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
        }


        public Categoria insert(Categoria obj){
            obj.setId(null);
            return repo.save(obj);
        }

    public Categoria update(Categoria obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id) {
        Categoria obj = find(id);

        // Remover as associações de produto
        for (Produto produto : obj.getProdutos()) {
            produto.getCategorias().remove(obj);
        }

        repo.delete(obj);
    }
}




