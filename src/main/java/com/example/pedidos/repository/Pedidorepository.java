package com.example.pedidos.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import com.example.pedidos.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class Pedidorepository {

    private List<Pedido> Pedidos;
    private int Codigonovo;

    @PostConstruct
    public void criarListaPedido(){

        Codigonovo = 1;
        Pedidos = new ArrayList<Pedido>();

      //  Pedido p1 = new Pedido();
        
       /* p1.setCliente("gustavo");
        p1.setCodigo(1);
        p1.setDatadopedido(new Date());
        p1.setDescricao("teste");
        p1.setValor(123);

        Pedidos.add(p1);*/
        

    }
    public List<Pedido> getAllPedidos() {
        return Pedidos;
    }

    public Pedido getPedidoByCodigo(int id) {
        for (Pedido aux : Pedidos) {
            if (aux.getCodigo() == id) {
                return aux;
            }
        }

        return null;
    }

    public Pedido salvar(Pedido Pedido) {
        Pedido.setCodigo(Codigonovo++);
        Pedido.setDatadopedido(new Date());
        Pedidos.add(Pedido);
        return Pedido;
    }

    public void remove(int Codigo) {
        Pedido Pedidop = getPedidoByCodigo(Codigo);
        Pedidos.remove(Pedidop);
    }

    
    public Pedido update(Pedido Pedido){
      
    Pedido aux = getPedidoByCodigo(Pedido.getCodigo());
        
        if(aux != null){

            aux.setValor(Pedido.getValor());
            aux.setDescricao(Pedido.getDescricao());
            aux.setCliente(Pedido.getCliente());
    }
        
      return aux;
      
    }
     

}
