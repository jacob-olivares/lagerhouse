
import com.lagerhouse.app.DAO.product.DAOBrand;
import com.lagerhouse.app.DAO.product.DAOProduct;
import com.lagerhouse.app.DAO.provider.DAOProvider;
import com.lagerhouse.app.model.Brand;
import com.lagerhouse.app.model.Product;
import com.lagerhouse.app.model.Provider;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */

/**
 *
 * @author SOACL-L-213
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAOProduct dProduct = new DAOProduct();
        Product product = null;
        ArrayList<Product> products = (ArrayList<Product>)dProduct.select();
        for(Product p : products){
            if(p.getIdProduct() == 9){
                product = new Product(p.getIdProduct(), p.getIdBrand(), p.getIdSubCategory(), p.getBarcode(), p.getPrice(), p.getStock(), p.getMinStock(), p.getProductName(), p.getExpirationDate(), p.getIdProvider());

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String fecha = sdf.format(product.getExpirationDate()).replace("/", "");
                int fechaInt = Integer.parseInt(fecha);
                System.out.println(fechaInt);
                break;
            }
        }
        
    }
    
}
