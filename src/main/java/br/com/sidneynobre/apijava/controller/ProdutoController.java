package br.com.sidneynobre.apijava.controller;

import br.com.sidneynobre.apijava.controller.dto.ProdutoRq;
import br.com.sidneynobre.apijava.entity.Produto;
import br.com.sidneynobre.apijava.repository.ProdutoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
@CrossOrigin
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Produto> findAllProdutoRs(){
        return produtoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Produto findById(@PathVariable("id") Long id){
        return produtoRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void saveProduto(@RequestBody ProdutoRq produtoRq){
        Produto produto = new Produto();
        produto.setNome(produtoRq.getNome());
        produto.setDescricao(produtoRq.getDescricao());
        produto.setPreco(produtoRq.getPreco());
        produtoRepository.save(produto);
    }

    @PutMapping("/{id}")
    public void updateProduto(@PathVariable("id") Long id, @RequestBody ProdutoRq produtoRq) throws Exception{
        Optional<Produto> l = produtoRepository.findById(id);

        if(l.isPresent()){
            Produto produtoSave = l.get();
            produtoSave.setNome(produtoRq.getNome());
            produtoSave.setDescricao(produtoRq.getDescricao());
            produtoSave.setPreco(produtoRq.getPreco());
            produtoRepository.save(produtoSave);

        }else{
            throw new Exception("Produto não encontrado");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteProduto(@PathVariable("id") Long id){
        produtoRepository.deleteById(id);
    }
}
