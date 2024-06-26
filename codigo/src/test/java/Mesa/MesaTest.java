package Mesa;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import model.Mesa;

/**
 *
 * @author imcat
 */
public class MesaTest {
    
     private List<Mesa> mesas;
/**
    @BeforeEach
    public void setUp() {
        mesas = new ArrayList<>();
        mesas.add(new Mesa(4, false));
        mesas.add(new Mesa(6, false));
        mesas.add(new Mesa(8, false));
    }

    @Test
    public void testAdicionarMesa() {
        Mesa novaMesa = new Mesa(10, false);
        mesas.add(novaMesa);
        assertTrue(mesas.contains(novaMesa));
    }

    @Test
    public void testAlocarMesa() {
        Mesa mesa = mesas.get(0);
        mesa.setOcupado();
        assertTrue(mesa.getOcupado());
    }

    @Test
    public void testDesocuparMesa() {
        Mesa mesa = mesas.get(0);
        mesa.setOcupado();
        mesa.desocuparMesa();
        assertFalse(mesa.getOcupado());
    }
    * **/
    
}
