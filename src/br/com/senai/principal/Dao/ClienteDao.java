package br.com.senai.principal.Dao;

import br.com.senai.principal.modelo.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClienteDao {

    private static List<Cliente> clientes = new ArrayList<>();
    private static Integer id = 1;

    public void salvar(Cliente cliente) {
      cliente.setId(id++);
      clientes.add(cliente);
    }

    public Cliente buscarPorCpf(String cpf) {
        for (Integer index = 0; index < clientes.size(); index++){
            Cliente clienteBuscado = clientes.get(index);
            if(clienteBuscado.getCpf().equals(cpf)){
                return clienteBuscado;
            }
        }
        return null;
    }
}
