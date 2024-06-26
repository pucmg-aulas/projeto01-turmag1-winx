/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author thiag
 */
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Mesa;

public class MesaDAO extends AbstractDAO {

    private static MesaDAO instance;
    private List<Mesa> mesas = new ArrayList();
    private String path = Paths.get(System.getProperty("user.dir"), "src", "main", "java", "data", "mesas.ser").toString();

    private MesaDAO() {
       
    }

    public static MesaDAO getInstance() {
        if (instance == null) {
            instance = new MesaDAO();
        }
        return instance;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public Mesa buscarMesaPorNumero(String numero) {
        for (Mesa m : mesas) {
            if (numero.equals(m.getNumero())) {
                return m;
            }
        }
        return null;
    }

    public void adicionarMesa(Mesa mesa) {
        this.mesas.add(mesa);
        gravar(path, mesas);
    }

    public void removerMesa(Mesa mesa) {
        this.mesas.remove(mesa);
        gravar(path, mesas);
    }

    private void carregarMesas() {
        this.mesas.addAll(leitura(path));
    }

}
