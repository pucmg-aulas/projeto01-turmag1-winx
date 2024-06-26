/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author thiag
 */
import model.Mesa;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class MesaDAO {
    private static MesaDAO instance;
    private List<Mesa> mesas = new ArrayList();

    private MesaDAO() {
        inicializarMesas();
    }

    public static MesaDAO getInstance() {
        if (instance == null) {
            instance = new MesaDAO();
        }
        return instance;
    }

    private void inicializarMesas() {
        Cliente c = new Cliente("afaf", "afaf");
        mesas.add(new Mesa(6, false, 1, c));
        mesas.add(new Mesa(6, false, 2, c));
        mesas.add(new Mesa(8, false, 3, c));
        mesas.add(new Mesa(10, false, 4, c));
        mesas.add(new Mesa(10, false, 4, c));
        mesas.add(new Mesa(10, false, 4, c));
        mesas.add(new Mesa(10, false, 4, c));
        mesas.add(new Mesa(10, false, 4, c));
        mesas.add(new Mesa(10, false, 4, c));
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void adicionarMesa(Mesa mesa) {
        mesas.add(mesa);
    }

    public void removerMesa(Mesa mesa) {
        mesas.remove(mesa);
    }

    public Mesa buscarMesaPorNumero(String numero) {
        for (Mesa m : mesas) {
            if (numero.equals(m.getNumero())) {
                return m;
            }
        }
        return null;
    }
}
