package me.dio.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.dio.object.Tarefa;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private List<Tarefa> tarefas = new ArrayList<>();
    private Long proximoId = 1L;

    @GetMapping
    public List<Tarefa> listarTarefas() {
        return tarefas;
    }

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        tarefa.setId(proximoId);
        proximoId++;
        tarefas.add(tarefa);
        return tarefa;
    }

    @GetMapping("/{id}")
    public Tarefa buscarTarefa(@PathVariable Long id) {
        return tarefas.stream()
            .filter(tarefa -> tarefa.getId().equals(id))
            .findFirst()
            .orElse(null);
    }

    @PutMapping("/{id}")
    public Tarefa atualizarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
        for (Tarefa t : tarefas) {
            if (t.getId().equals(id)) {
                t.setTitulo(tarefa.getTitulo());
                t.setDescricao(tarefa.getDescricao());
                t.setConcluida(tarefa.isConcluida());
                return t;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public boolean excluirTarefa(@PathVariable Long id) {
        return tarefas.removeIf(tarefa -> tarefa.getId().equals(id));
    }
}
