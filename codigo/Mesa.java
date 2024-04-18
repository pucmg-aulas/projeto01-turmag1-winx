public class Mesa {
    public int quantidade;
    public boolean ocupado;

    public Mesa(int quantidade, boolean ocupado){
        this.quantidade = quantidade;
        this.ocupado = ocupado;
    }

    public void ocuparMesa(){
        this.ocupado = true;
    }

    public void desocuparMesa(){
        this.ocupado = false;
        
    }


    public static boolean verificarDisponibilidade() {
        return true;
    }

    public boolean verificaCapacidade(int quantPessoas){
        if (quantPessoas <= quantidade){
            return true;
        }
        return false;
    }
}
