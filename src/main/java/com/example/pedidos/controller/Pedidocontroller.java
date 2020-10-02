package com.example.pedidos.controller;

import java.net.URI;
import java.util.List;



import com.example.pedidos.model.Pedido;
import com.example.pedidos.repository.Pedidorepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



//GET POST PUT DELET//
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pedidos")
public class Pedidocontroller{

    @Autowired
    private Pedidorepository repository;

    @GetMapping()
    public List<Pedido> getALLpedidos(){
        return repository.getAllPedidos();
    }
    @GetMapping("/{codigo}")
    public ResponseEntity<Pedido> getCliente(@PathVariable int codigo) {
         Pedido pedido = repository.getPedidoByCodigo(codigo);

         if(pedido != null){
             return ResponseEntity.ok(pedido);
         }
         else{
             return ResponseEntity.notFound().build();
        }
    }
    @PostMapping()
    public ResponseEntity<Pedido> salvar(@RequestBody Pedido pedido){
        Pedido pedidonovo = repository.salvar(pedido);
        URI uri = URI.create("http://localhost:8080/pedidos/" + pedidonovo.getCodigo());
        return ResponseEntity.created(uri).build();
    }
    @PutMapping("/{codigo}")
    public ResponseEntity<Pedido> atualizar(@RequestBody Pedido pedido, @PathVariable int codigo){
        
        if(repository.getPedidoByCodigo(codigo) != null){
            pedido.setCodigo(codigo);
            pedido = repository.update(pedido);
            return ResponseEntity.ok(pedido);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> deletar(@PathVariable int codigo){
        Pedido pedido = repository.getPedidoByCodigo(codigo);

        if(pedido != null){
            repository.remove(codigo);
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.notFound().build();
        }   
    }
}
