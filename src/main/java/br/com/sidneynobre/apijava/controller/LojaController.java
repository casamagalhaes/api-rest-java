package br.com.sidneynobre.apijava.controller;


import br.com.sidneynobre.apijava.controller.dto.LojaRq;
import br.com.sidneynobre.apijava.entity.Loja;
import br.com.sidneynobre.apijava.repository.LojaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loja")
public class LojaController {

    private final LojaRepository lojaRepository;

    public LojaController(LojaRepository lojaRepository) {
        this.lojaRepository = lojaRepository;
    }

    @GetMapping("/")
    public List<Loja> findAllLojaRs(){
        return lojaRepository.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Loja findById(@PathVariable("id") Long id){
        return lojaRepository.getOne(id);
    }

    @PostMapping("/")
    public void saveLoja(@RequestBody LojaRq lojaRq){
        Loja loja = new Loja();
        loja.setNome(lojaRq.getNome());
        loja.setEndereco(lojaRq.getEndereco());
        loja.setCidade(lojaRq.getCidade());
        loja.setEstado(lojaRq.getEstado());
        lojaRepository.save(loja);
    }

    @PutMapping("/{id}")
    public void updateLoja(@PathVariable("id") Long id, @RequestBody LojaRq lojaRq) throws Exception{
        Optional<Loja> l = lojaRepository.findById(id);

        if(l.isPresent()){
            Loja lojaSave = l.get();
            lojaSave.setNome(lojaRq.getNome());
            lojaSave.setEndereco(lojaRq.getEndereco());
            lojaSave.setCidade(lojaRq.getCidade());
            lojaSave.setEstado(lojaRq.getEstado());
            lojaRepository.save(lojaSave);

        }else{
            throw new Exception("Loja não encontrada");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteLoja(@PathVariable("id") Long id){
        lojaRepository.deleteById(id);
    }
}
