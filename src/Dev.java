package src;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> ConteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> ConteudosConcluidos = new LinkedHashSet<>();

    
    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.ConteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.ConteudosInscritos.stream().findFirst();
        //Optional: Surgiu no Java 8 para resolver retorno Nulo
        if (conteudo.isPresent()){
            this.ConteudosConcluidos.add(conteudo.get());
            this.ConteudosInscritos.remove(conteudo.get());
        } else{
            System.err.println("Você não está matriculado em nenhum conteudo");
        }
    }

    public double calcularTotalXp() {
        return this.ConteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXp()).sum();
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return ConteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        ConteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return ConteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        ConteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ConteudosConcluidos == null) ? 0 : ConteudosConcluidos.hashCode());
        result = prime * result + ((ConteudosInscritos == null) ? 0 : ConteudosInscritos.hashCode());
        result = prime * result + ((nome == null) ? 0 : nome.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Dev other = (Dev) obj;
        if (ConteudosConcluidos == null) {
            if (other.ConteudosConcluidos != null)
                return false;
        } else if (!ConteudosConcluidos.equals(other.ConteudosConcluidos))
            return false;
        if (ConteudosInscritos == null) {
            if (other.ConteudosInscritos != null)
                return false;
        } else if (!ConteudosInscritos.equals(other.ConteudosInscritos))
            return false;
        if (nome == null) {
            if (other.nome != null)
                return false;
        } else if (!nome.equals(other.nome))
            return false;
        return true;
    }


    
    


}

