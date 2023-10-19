package me.dio.object;

public class Tarefa {
    private Long id;
    private String titulo;
    private String descricao;
    private boolean concluida;

    // Getter para o campo "id"
    public Long getId() {
        return id;
    }

    // Setter para o campo "id"
    public void setId(Long id) {
        this.id = id;
    }

    // Getter para o campo "titulo"
    public String getTitulo() {
        return titulo;
    }

    // Setter para o campo "titulo"
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Getter para o campo "descricao"
    public String getDescricao() {
        return descricao;
    }

    // Setter para o campo "descricao"
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // Getter para o campo "concluida"
    public boolean isConcluida() {
        return concluida;
    }

    // Setter para o campo "concluida"
    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}

