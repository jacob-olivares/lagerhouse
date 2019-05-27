/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO;

import java.util.List;

/**
 *
 * @author Jacob Olivares Espinoza
 */
public interface CrudRepository<Generic>{
    public boolean insert(Generic x);
    public boolean update(Generic x);
    public boolean delete(int x);
    public List<Generic> select();
    public Generic selectById(int x);
}
